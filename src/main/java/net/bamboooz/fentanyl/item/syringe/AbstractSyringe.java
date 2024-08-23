package net.bamboooz.fentanyl.item.syringe;

import net.bamboooz.fentanyl.damage.ModDamageTypes;
import net.bamboooz.fentanyl.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public abstract class AbstractSyringe extends Item {
    public AbstractSyringe(Settings settings) {
        super(settings);
    }

    public abstract Block syringeBlock();

    public abstract void onPrick(ItemStack stack, PlayerEntity user, LivingEntity entity);

    public abstract TypedActionResult<ItemStack> useOnFluid(World world, BlockState state, BlockPos pos, PlayerEntity user, ItemStack stack);

    private static boolean canPlaceSyringe(WorldView world, BlockPos pos) {
        boolean canPlace = Block.hasTopRim(world, pos) || Block.sideCoversSmallSquare(world, pos, Direction.UP);
        boolean spaceFree = world.getBlockState(pos.up()).getBlock() == Blocks.AIR;

        return canPlace && spaceFree;
    }

    private void prick(World world, ItemStack stack, PlayerEntity user, LivingEntity entity) {
        if (!world.isClient) {
            world.playSound(null, entity.getBlockPos(), ModSounds.PRICK, SoundCategory.NEUTRAL, 1f, 1f);
            entity.damage(ModDamageTypes.of(world, user, entity, ModDamageTypes.PRICKING), 1);

            onPrick(stack, user, entity);
        }
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        BlockHitResult blockHitResult = raycast(world, user, RaycastContext.FluidHandling.SOURCE_ONLY);

        if (blockHitResult.getType() != BlockHitResult.Type.MISS && syringeBlock() != null) {
            if (blockHitResult.getType() == BlockHitResult.Type.BLOCK) {
                BlockPos blockPos = blockHitResult.getBlockPos();

                if (!world.canPlayerModifyAt(user, blockPos)) {
                    return TypedActionResult.pass(stack);
                }

                return useOnBlockOrFluid(stack, world, user, blockPos);
            }
        } else {
            user.getItemCooldownManager().set(this, 20);

            prick(world, stack, user, user);

            return TypedActionResult.success(stack, world.isClient());
        }

        return TypedActionResult.pass(stack);
    }

    private TypedActionResult<ItemStack> useOnBlockOrFluid(ItemStack stack, World world, PlayerEntity user, BlockPos pos) {
        BlockState state = world.getBlockState(pos);

        boolean isFluid = !state.getFluidState().isEmpty();

        if (isFluid) {
            return useOnFluid(world, state, pos, user, stack);
        }

        if (!canPlaceSyringe(world, pos)) {
            return TypedActionResult.pass(stack);
        }

        world.setBlockState(pos.up(), syringeBlock().getDefaultState());

        if (!user.getAbilities().creativeMode) {
            stack.decrement(1);
        }

        return TypedActionResult.success(stack, world.isClient());
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        user.getItemCooldownManager().set(this, 20);

        World world = user.getWorld();

        prick(world, stack, user, entity);

        return ActionResult.SUCCESS;
    }
}
