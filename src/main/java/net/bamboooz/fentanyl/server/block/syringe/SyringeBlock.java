package net.bamboooz.fentanyl.server.block.syringe;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SyringeBlock extends AbstractSyringeBlock {
    public SyringeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onPrick(World world, BlockPos pos, LivingEntity entity) {

    }
}
