package net.bamboooz.fentanyl.server.util;

import net.bamboooz.fentanyl.server.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;

public class NaloxoneManager {
    public static final int NALOXONE_TINT = 0xFFFFFF;

    public static void applyDrug(LivingEntity entity) {
        StatusEffectInstance naloxone = new StatusEffectInstance(ModEffects.NALOXONE, 1, 0, true, false, false);

        if (entity.hasStatusEffect(ModEffects.NALOXONE)) {
            entity.removeStatusEffect(ModEffects.NALOXONE);
        }

        entity.addStatusEffect(naloxone);
    }
}
