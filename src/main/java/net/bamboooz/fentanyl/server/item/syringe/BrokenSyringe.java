package net.bamboooz.fentanyl.server.item.syringe;

import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;

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
        user.incrementStat(Stats.USED.getOrCreateStat(this));
    }
}
