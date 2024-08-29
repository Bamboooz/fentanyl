package net.bamboooz.fentanyl;

import net.bamboooz.fentanyl.block.ModBlocks;
import net.bamboooz.fentanyl.effect.ModEffects;
import net.bamboooz.fentanyl.entity.damage.ModDamageTypes;
import net.bamboooz.fentanyl.entity.villager.ModVillagers;
import net.bamboooz.fentanyl.fluid.ModFluids;
import net.bamboooz.fentanyl.item.ModItemGroups;
import net.bamboooz.fentanyl.entity.villager.ModCustomTrades;
import net.bamboooz.fentanyl.loot.ModLootConditions;
import net.bamboooz.fentanyl.util.ModTags;
import net.bamboooz.fentanyl.item.ModItems;
import net.bamboooz.fentanyl.sound.ModSounds;
import net.bamboooz.fentanyl.loot.ModifyLootTables;
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
