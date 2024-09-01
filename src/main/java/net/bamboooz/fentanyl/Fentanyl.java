package net.bamboooz.fentanyl;

import net.bamboooz.fentanyl.server.block.ModBlocks;
import net.bamboooz.fentanyl.server.effect.ModEffects;
import net.bamboooz.fentanyl.server.entity.damage.ModDamageTypes;
import net.bamboooz.fentanyl.server.entity.villager.ModVillagers;
import net.bamboooz.fentanyl.server.fluid.ModFluids;
import net.bamboooz.fentanyl.server.item.ModItemGroups;
import net.bamboooz.fentanyl.server.entity.villager.ModCustomTrades;
import net.bamboooz.fentanyl.server.loot.ModLootConditions;
import net.bamboooz.fentanyl.server.tag.ModTags;
import net.bamboooz.fentanyl.server.item.ModItems;
import net.bamboooz.fentanyl.server.sound.ModSounds;
import net.bamboooz.fentanyl.server.loot.ModifyLootTables;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fentanyl implements ModInitializer {
	public static final String MOD_ID = "fentanyl";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerItems();
		ModItemGroups.registerItemGroups();

		ModBlocks.registerBlocks();
		ModFluids.registerFluids();
		ModTags.registerTags();

		ModEffects.registerEffects();
		ModDamageTypes.registerDamageTypes();
		ModSounds.registerSounds();

		ModLootConditions.registerLootConditions();
		ModifyLootTables.modifyLootTables();

		ModVillagers.registerVillagers();
		ModCustomTrades.registerCustomTrades();
	}
}
