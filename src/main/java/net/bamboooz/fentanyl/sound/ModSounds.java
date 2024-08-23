package net.bamboooz.fentanyl.sound;

import net.bamboooz.fentanyl.Fentanyl;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent PRICK = registerSound("prick");
    public static final SoundEvent SNORT = registerSound("snort");
    public static final SoundEvent MANDEVILLE = registerSound("mandeville");

    private static SoundEvent registerSound(String name) {
        Identifier id = Identifier.of(Fentanyl.MOD_ID, name);

        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        Fentanyl.LOGGER.info("Registering mod sounds for " + Fentanyl.MOD_ID);
    }
}
