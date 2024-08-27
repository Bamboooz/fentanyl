package net.bamboooz.fentanyl.item.syringe;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BrokenSyringe extends AbstractSyringe {
    public BrokenSyringe(Settings settings) {
        super(settings);
    }

    @Override
    public Block syringeBlock() {
        return null;
    }

    @Override
    public void onPrick(ItemStack stack, PlayerEntity user, LivingEntity entity) {

    }

    @Override
    public TypedActionResult<ItemStack> useOnFluid(World world, BlockState state, BlockPos pos, PlayerEntity user, ItemStack stack) {
        return TypedActionResult.pass(stack);
    }
}
