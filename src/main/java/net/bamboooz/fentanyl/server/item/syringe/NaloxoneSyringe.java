package net.bamboooz.fentanyl.server.item.syringe;

import net.bamboooz.fentanyl.server.block.ModBlocks;
import net.bamboooz.fentanyl.server.item.ModItems;
import net.bamboooz.fentanyl.server.util.NaloxoneManager;
import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;

public class NaloxoneSyringe extends AbstractSyringe {
    public NaloxoneSyringe(Settings settings) {
        super(settings);
    }

    @Override
    public Block syringeBlock() {
        return ModBlocks.NALOXONE_SYRINGE_BLOCK;
    }

    @Override
    public void onPrick(ItemStack stack, PlayerEntity user, LivingEntity entity) {
        user.incrementStat(Stats.USED.getOrCreateStat(this));

        NaloxoneManager.applyDrug(entity);

        if (!user.getAbilities().creativeMode) {
            stack.decrement(1);
        }

        user.giveItemStack(ModItems.SYRINGE.getDefaultStack());
    }
}
