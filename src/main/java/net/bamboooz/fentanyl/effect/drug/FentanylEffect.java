package net.bamboooz.fentanyl.effect.drug;

import net.bamboooz.fentanyl.entity.damage.ModDamageTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class FentanylEffect extends StatusEffect {
    public FentanylEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        switch (amplifier) {
            case 0:
                break; // benefits, immunity to poison/blindness/bad effects
            case 1:
                break; // nausea, blindness,bending player model
            default:
                entity.damage(ModDamageTypes.of(entity.getWorld(), ModDamageTypes.FENTANYL_OD), 1);
                break;
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
