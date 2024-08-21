package net.bamboooz.fentanyl.block.syringe;

import net.bamboooz.fentanyl.block.ModBlocks;
import net.bamboooz.fentanyl.util.FentanylData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FentanylSyringeBlock extends AbstractSyringeBlock {
    public boolean empty = false;

    public FentanylSyringeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onPrick(World world, BlockPos pos, LivingEntity entity) {
        if (!empty) {
            FentanylData.applyDrug(entity, 12000);

            world.setBlockState(pos, ModBlocks.SYRINGE_BLOCK.getDefaultState());

            empty = true;
        }
    }
}
