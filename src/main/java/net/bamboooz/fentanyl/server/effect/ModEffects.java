package net.bamboooz.fentanyl.server.effect;

import net.bamboooz.fentanyl.Fentanyl;
import net.bamboooz.fentanyl.server.effect.drug.FentanylEffect;
import net.bamboooz.fentanyl.server.effect.drug.NaloxoneEffect;
import net.bamboooz.fentanyl.server.util.FentanylManager;
import net.bamboooz.fentanyl.server.util.NaloxoneManager;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final StatusEffect FENTANYL = registerEffect("fentanyl", new FentanylEffect(StatusEffectCategory.HARMFUL, FentanylManager.FENTANYL_TINT));
    public static final StatusEffect NALOXONE = registerEffect("naloxone", new NaloxoneEffect(StatusEffectCategory.BENEFICIAL, NaloxoneManager.NALOXONE_TINT));

    private static StatusEffect registerEffect(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, Identifier.of(Fentanyl.MOD_ID, name), effect);
    }

    public static void registerEffects() {
        Fentanyl.LOGGER.info("Registering mod effects for " + Fentanyl.MOD_ID);
    }
}
