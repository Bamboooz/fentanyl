package net.bamboooz.fentanyl.util;

import net.bamboooz.fentanyl.Fentanyl;
import net.bamboooz.fentanyl.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModifyLootTables {
    public static final Identifier SUSPICIOUS_SAND_LOOT_TABLE_ID = Blocks.SUSPICIOUS_SAND.getLootTableId();
    public static final Identifier SUSPICIOUS_GRAVEL_LOOT_TABLE_ID = Blocks.SUSPICIOUS_GRAVEL.getLootTableId();

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            boolean isSuspicious = SUSPICIOUS_SAND_LOOT_TABLE_ID.equals(id) || SUSPICIOUS_GRAVEL_LOOT_TABLE_ID.equals(id);

            if (source.isBuiltin() && isSuspicious) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f))
                        .with(ItemEntry.builder(ModItems.FENTANYL_PILLS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder);
            }
        });

        Fentanyl.LOGGER.info("Modifying loot tables for " + Fentanyl.MOD_ID);
    }
}
