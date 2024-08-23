package net.bamboooz.fentanyl.util;

import net.bamboooz.fentanyl.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;

public class FentanylManager {
    public static final int FENTANYL_LEVEL_TIME = 12000;
    public static final int MAX_FENTANYL_LEVEL = 2;
    public static final int FENTANYL_TINT = 0xA3CAD1;

    public static void applyDrug(LivingEntity entity, int amount) {
        StatusEffectInstance effect = entity.getStatusEffect(ModEffects.FENTANYL);

        int newTotalDuration;

        if (effect != null) {
            int amplifier = effect.getAmplifier();
            int currentTotalDuration = (amplifier * FENTANYL_LEVEL_TIME) + effect.getDuration();
            newTotalDuration = currentTotalDuration + amount;
        } else {
            newTotalDuration = amount;
        }

        int newAmplifier = Math.min(newTotalDuration / (FENTANYL_LEVEL_TIME + 1), MAX_FENTANYL_LEVEL);
        int newDuration = newTotalDuration - (newAmplifier * FENTANYL_LEVEL_TIME);

        StatusEffectInstance newEffect = new StatusEffectInstance(ModEffects.FENTANYL, newDuration, newAmplifier, false, false, true);

        if (effect != null) {
            entity.removeStatusEffect(ModEffects.FENTANYL);
        }

        entity.addStatusEffect(newEffect);
    }
}
