package net.bamboooz.fentanyl.loot;

import net.bamboooz.fentanyl.Fentanyl;
import net.bamboooz.fentanyl.loot.custom.VillagerProfessionLootCondition;
import net.minecraft.loot.condition.LootConditionType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModLootConditions {
    public static final LootConditionType VILLAGER_PROFESSION = registerLootCondition("villager_profession", new LootConditionType(new VillagerProfessionLootCondition.Serializer()));

    private static LootConditionType registerLootCondition(String name, LootConditionType condition) {
        return Registry.register(Registries.LOOT_CONDITION_TYPE, Identifier.of(Fentanyl.MOD_ID, name), condition);
    }

    public static void registerLootConditions() {
        Fentanyl.LOGGER.info("Registering mod loot conditions for " + Fentanyl.MOD_ID);
    }
}
