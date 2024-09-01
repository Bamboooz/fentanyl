package net.bamboooz.fentanyl.server.entity.villager;

import com.google.common.collect.ImmutableSet;
import net.bamboooz.fentanyl.Fentanyl;
import net.bamboooz.fentanyl.server.block.ModBlocks;
import net.bamboooz.fentanyl.server.sound.ModSounds;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public static final RegistryKey<PointOfInterestType> FIEND_POI_KEY = poiKey("fiend_poi");
    public static final PointOfInterestType FIEND_POI = registerPoi("fiend_poi", ModBlocks.FENTANYL_BLOCK);

    public static final VillagerProfession FIEND = registerProfession("fiend", FIEND_POI_KEY);

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, Identifier.of(Fentanyl.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), ModSounds.SNORT));
    }

    private static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(Identifier.of(Fentanyl.MOD_ID, name), 1, 1, block);
    }

    private static RegistryKey<PointOfInterestType> poiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(Fentanyl.MOD_ID, name));
    }

    public static void registerVillagers() {
        Fentanyl.LOGGER.info("Registering mod villagers for " + Fentanyl.MOD_ID);
    }
}
