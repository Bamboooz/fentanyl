package net.bamboooz.fentanyl.server.item.syringe;

import net.bamboooz.fentanyl.server.block.ModBlocks;
import net.bamboooz.fentanyl.server.item.ModItems;
import net.bamboooz.fentanyl.server.util.FentanylManager;
import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;

public class FentanylSyringe extends AbstractSyringe {
    public FentanylSyringe(Settings settings) {
        super(settings);
    }

    @Override
    public Block syringeBlock() {
        return ModBlocks.FENTANYL_SYRINGE_BLOCK;
    }

    @Override
    public void onPrick(ItemStack stack, PlayerEntity user, LivingEntity entity) {
        user.incrementStat(Stats.USED.getOrCreateStat(this));

        FentanylManager.applyDrug(entity, 12000);

        if (!user.getAbilities().creativeMode) {
            stack.decrement(1);
        }

        user.giveItemStack(ModItems.SYRINGE.getDefaultStack());
    }
}
