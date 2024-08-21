package net.bamboooz.fentanyl.util;

import net.bamboooz.fentanyl.effect.ModEffects;
import net.bamboooz.fentanyl.entity.IEntityDataSaver;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.nbt.NbtCompound;

public class FentanylData {
    public static final int FENTANYL_LEVEL_STEP = 12000;

    public static void applyDrug(LivingEntity entity, int amount) {
        IEntityDataSaver saver = (IEntityDataSaver) entity;
        NbtCompound nbt = saver.fentanyl$getPersistentData();

        int fentanylLevel = nbt.getInt("fentanyl");

        nbt.putInt("fentanyl", fentanylLevel + amount);
    }

    public static void applyEffect(LivingEntity entity, int amplifier) {
        StatusEffectInstance status = new StatusEffectInstance(
                ModEffects.FENTANYL,
                StatusEffectInstance.INFINITE,
                amplifier,
                false,
                false,
                true
        );

        entity.addStatusEffect(status);
    }

    public static int effectLevel(int fentanylLevel) {
        if (fentanylLevel <= FENTANYL_LEVEL_STEP) {
            return 0;
        } else if (fentanylLevel <= FENTANYL_LEVEL_STEP * 2) {
            return 1;
        } else {
            return 2;
        }
    }
}
