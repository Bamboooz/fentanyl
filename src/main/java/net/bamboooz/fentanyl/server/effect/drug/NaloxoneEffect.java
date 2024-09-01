package net.bamboooz.fentanyl.server.effect.drug;

import net.bamboooz.fentanyl.server.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class NaloxoneEffect extends StatusEffect {
    public NaloxoneEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.hasStatusEffect(ModEffects.FENTANYL)) {
            entity.removeStatusEffect(ModEffects.FENTANYL);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
