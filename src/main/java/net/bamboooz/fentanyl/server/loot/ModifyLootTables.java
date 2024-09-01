package net.bamboooz.fentanyl.server.loot;

import net.bamboooz.fentanyl.Fentanyl;
import net.bamboooz.fentanyl.server.entity.villager.ModVillagers;
import net.bamboooz.fentanyl.server.item.ModItems;
import net.bamboooz.fentanyl.server.loot.condition.VillagerProfessionLootCondition;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModifyLootTables {
    public static final Identifier VILLAGER_ID = EntityType.VILLAGER.getLootTableId();

    public static final Identifier SUSPICIOUS_DESERT_PYRAMID_ID = Identifier.of("minecraft", "archaeology/desert_pyramid");
    public static final Identifier SUSPICIOUS_DESERT_WELL_ID = Identifier.of("minecraft", "archaeology/desert_well");
    public static final Identifier SUSPICIOUS_OCEAN_RUIN_COLD_ID = Identifier.of("minecraft", "archaeology/ocean_ruin_cold");
    public static final Identifier SUSPICIOUS_OCEAN_RUIN_WARM_ID = Identifier.of("minecraft", "archaeology/ocean_ruin_warm");
    public static final Identifier SUSPICIOUS_TRAIL_RUINS_COMMON_ID = Identifier.of("minecraft", "archaeology/trail_ruins_common");
    public static final Identifier SUSPICIOUS_TRAIL_RUINS_RARE_ID = Identifier.of("minecraft", "archaeology/trail_ruins_rare");

    private static boolean isSuspicious(Identifier id) {
        return SUSPICIOUS_DESERT_PYRAMID_ID.equals(id)
                || SUSPICIOUS_DESERT_WELL_ID.equals(id)
                || SUSPICIOUS_OCEAN_RUIN_COLD_ID.equals(id)
                || SUSPICIOUS_OCEAN_RUIN_WARM_ID.equals(id)
                || SUSPICIOUS_TRAIL_RUINS_COMMON_ID.equals(id)
                || SUSPICIOUS_TRAIL_RUINS_RARE_ID.equals(id);
    }

    private static void modifyVillagerLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && VILLAGER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.005f))
                        .conditionally(VillagerProfessionLootCondition.builder(ModVillagers.FIEND))
                        .with(ItemEntry.builder(ModItems.FIEND_HAT));

                tableBuilder.pool(poolBuilder.build());
            }
        });
    }

    private static void modifySuspiciousBlockLootTables() {
        LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
            if (isSuspicious(id)) {
                List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));
                entries.add(ItemEntry.builder(ModItems.SYRINGE).build());
                entries.add(ItemEntry.builder(ModItems.FENTANYL_PILLS).build());

                LootPool.Builder pool = LootPool.builder().with(entries);

                return LootTable.builder().pool(pool).build();
            }

            return null;
        });
    }

    public static void modifyLootTables() {
        modifyVillagerLootTables();
        modifySuspiciousBlockLootTables();

        Fentanyl.LOGGER.info("Modifying loot tables for " + Fentanyl.MOD_ID);
    }
}
