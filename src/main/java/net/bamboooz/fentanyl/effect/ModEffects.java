package net.bamboooz.fentanyl.effect;

import net.bamboooz.fentanyl.Fentanyl;
import net.bamboooz.fentanyl.effect.drug.FentanylEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final StatusEffect FENTANYL = registerEffect("fentanyl", new FentanylEffect(StatusEffectCategory.NEUTRAL, 0xA8CAD1));

    private static StatusEffect registerEffect(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, Identifier.of(Fentanyl.MOD_ID, name), effect);
    }

    public static void registerEffects() {
        Fentanyl.LOGGER.info("Registering mod effects for " + Fentanyl.MOD_ID);
    }
}
