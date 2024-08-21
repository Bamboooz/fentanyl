package net.bamboooz.fentanyl.item.syringe;

import net.bamboooz.fentanyl.block.ModBlocks;
import net.bamboooz.fentanyl.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
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
        if (state.getBlock() == ModBlocks.FENTANYL_FLUID_BLOCK) {
            world.setBlockState(pos, Blocks.AIR.getDefaultState());
            stack.decrement(1);
            user.giveItemStack(ModItems.FENTANYL_SYRINGE.getDefaultStack());

            return TypedActionResult.success(stack, world.isClient());
        }

        return TypedActionResult.pass(stack);
    }
}
