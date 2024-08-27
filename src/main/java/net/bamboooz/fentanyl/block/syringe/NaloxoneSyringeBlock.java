package net.bamboooz.fentanyl.block.syringe;

import net.bamboooz.fentanyl.util.FentanylManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class NaloxoneSyringeBlock extends AbstractSyringeBlock {
    public NaloxoneSyringeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onPrick(World world, BlockPos pos, LivingEntity entity) {
        FentanylManager.removeFentanyl(entity);
    }
}
