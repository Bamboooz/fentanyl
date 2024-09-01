package net.bamboooz.fentanyl.server.item.syringe;

import net.bamboooz.fentanyl.server.entity.damage.ModDamageTypes;
import net.bamboooz.fentanyl.server.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public abstract class AbstractSyringe extends Item {
    public AbstractSyringe(Settings settings) {
        super(settings);
    }

    public abstract Block syringeBlock();

    public abstract void onPrick(ItemStack stack, PlayerEntity user, LivingEntity entity);

    private static boolean canPlaceSyringe(WorldView world, BlockPos pos) {
        boolean canPlace = Block.hasTopRim(world, pos) || Block.sideCoversSmallSquare(world, pos, Direction.UP);
        boolean spaceFree = world.getBlockState(pos.up()).getBlock() == Blocks.AIR;

        return canPlace && spaceFree;
    }

    private void prick(World world, ItemStack stack, PlayerEntity user, LivingEntity entity) {
        if (world.isClient) {
            return;
        }

        world.playSound(null, entity.getBlockPos(), ModSounds.PRICK, SoundCategory.NEUTRAL, 1f, 1f);

        entity.damage(ModDamageTypes.of(world, user, user, ModDamageTypes.PRICKING), 1);

        onPrick(stack, user, entity);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.getItemCooldownManager().set(this, 20);

        ItemStack stack = user.getStackInHand(hand);

        prick(world, stack, user, user);

        return TypedActionResult.success(stack, world.isClient());
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity user = context.getPlayer();
        ItemStack stack = context.getStack();

        if (user == null || !canPlaceSyringe(world, pos)) {
            return ActionResult.PASS;
        }

        world.setBlockState(pos.up(), syringeBlock().getDefaultState());

        if (!user.getAbilities().creativeMode) {
            stack.decrement(1);
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        user.getItemCooldownManager().set(this, 20);

        World world = user.getWorld();

        prick(world, stack, user, entity);

        return ActionResult.SUCCESS;
    }
}
