package net.bamboooz.fentanyl.effect.drug;

import net.bamboooz.fentanyl.effect.ModEffects;
import net.bamboooz.fentanyl.damage.ModDamageTypes;
import net.bamboooz.fentanyl.util.FentanylManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class FentanylEffect extends StatusEffect {
    public FentanylEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        StatusEffectInstance regeneration = new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0, true, false, false);
        StatusEffectInstance nausea = new StatusEffectInstance(StatusEffects.NAUSEA, 100, 0, true, false, false);
        StatusEffectInstance slowness = new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 3, true, false, false);

        switch (amplifier) {
            case 0:
                entity.addStatusEffect(regeneration);
                break;
            case 1:
                entity.addStatusEffect(nausea);
                entity.addStatusEffect(slowness);
                break;
            default:
                entity.addStatusEffect(nausea);
                entity.addStatusEffect(slowness);
                entity.damage(ModDamageTypes.of(entity.getWorld(), ModDamageTypes.FENTANYL_OD), 1);
                break;
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (amplifier == 0) {
            return;
        }

        StatusEffectInstance newEffect = new StatusEffectInstance(ModEffects.FENTANYL, FentanylManager.FENTANYL_LEVEL_TIME, amplifier - 1, false, false, true);

        if (entity.getStatusEffect(ModEffects.FENTANYL) != null) {
            entity.removeStatusEffect(ModEffects.FENTANYL);
        }

        entity.addStatusEffect(newEffect);
    }
}
