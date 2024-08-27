package net.bamboooz.fentanyl.util;

import net.bamboooz.fentanyl.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;

public class FentanylManager {
    public static final int FENTANYL_LEVEL_TIME = 12000;

    public static final int FENTANYL_TINT = 0xA3CAD1;
    public static final int NALOXONE_TINT = 0xFFFFFF;

    public static void applyDrug(LivingEntity entity, int amount) {
        StatusEffectInstance effect = entity.getStatusEffect(ModEffects.FENTANYL);

        int totalDuration = amount;

        if (effect != null) {
            totalDuration += (effect.getAmplifier() * FENTANYL_LEVEL_TIME) + effect.getDuration();
        }

        int newAmplifier = (totalDuration <= FENTANYL_LEVEL_TIME) ? 0 : (totalDuration <= FENTANYL_LEVEL_TIME * 2) ? 1 : 2;
        int newDuration = totalDuration - (newAmplifier * FENTANYL_LEVEL_TIME);

        StatusEffectInstance newEffect = new StatusEffectInstance(ModEffects.FENTANYL, newDuration, newAmplifier, false, false, true);

        entity.addStatusEffect(newEffect);
    }

    public static void removeFentanyl(LivingEntity entity) {
        if (entity.hasStatusEffect(ModEffects.FENTANYL)) {
            entity.removeStatusEffect(ModEffects.FENTANYL);
        }
    }

    public static boolean isCooked(LivingEntity entity) {
        StatusEffectInstance effect = entity.getStatusEffect(ModEffects.FENTANYL);

        if (effect == null) {
            return false;
        }

        return effect.getAmplifier() > 0;
    }
}
