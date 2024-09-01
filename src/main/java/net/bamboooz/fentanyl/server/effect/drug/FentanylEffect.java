package net.bamboooz.fentanyl.server.effect.drug;

import net.bamboooz.fentanyl.server.entity.damage.ModDamageTypes;
import net.bamboooz.fentanyl.server.util.FentanylManager;
import net.minecraft.entity.LivingEntity;
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
        StatusEffectInstance resistance = new StatusEffectInstance(StatusEffects.RESISTANCE, 100, 0, true, false, false);
        StatusEffectInstance nausea = new StatusEffectInstance(StatusEffects.NAUSEA, 100, 0, true, false, false);
        StatusEffectInstance slowness = new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 2, true, false, false);

        entity.addStatusEffect(resistance);

        if (FentanylManager.isImmune(entity) || amplifier == 0) {
            return;
        }

        entity.addStatusEffect(nausea);
        entity.addStatusEffect(slowness);

        if (amplifier > 1) {
            entity.damage(ModDamageTypes.of(entity.getWorld(), ModDamageTypes.FENTANYL_OD), 1);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
