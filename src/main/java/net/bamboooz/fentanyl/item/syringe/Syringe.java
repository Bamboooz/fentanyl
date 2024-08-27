package net.bamboooz.fentanyl.item.syringe;

import net.bamboooz.fentanyl.block.ModBlocks;
import net.bamboooz.fentanyl.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Syringe extends AbstractSyringe {
    public Syringe(Settings settings) {
        super(settings);
    }

    @Override
    public Block syringeBlock() {
        return ModBlocks.SYRINGE_BLOCK;
    }

    @Override
    public void onPrick(ItemStack stack, PlayerEntity user, LivingEntity entity) {

    }

    @Override
    public TypedActionResult<ItemStack> useOnFluid(World world, BlockState state, BlockPos pos, PlayerEntity user, ItemStack stack) {
        boolean isFentanyl = state.getBlock() == ModBlocks.FENTANYL_FLUID_BLOCK;
        boolean isNaloxone = state.getBlock() == ModBlocks.NALOXONE_FLUID_BLOCK;

        if (!isFentanyl && !isNaloxone) {
            return TypedActionResult.pass(stack);
        }

        world.setBlockState(pos, Blocks.AIR.getDefaultState());

        if (!user.getAbilities().creativeMode) {
            stack.decrement(1);
        }

        Item item = isFentanyl ? ModItems.FENTANYL_SYRINGE : ModItems.NALOXONE_SYRINGE;

        user.giveItemStack(item.getDefaultStack());

        return TypedActionResult.success(stack, world.isClient());
    }
}
