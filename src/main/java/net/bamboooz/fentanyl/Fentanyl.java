package net.bamboooz.fentanyl;

import net.bamboooz.fentanyl.advancement.ModCriterions;
import net.bamboooz.fentanyl.block.ModBlocks;
import net.bamboooz.fentanyl.effect.ModEffects;
import net.bamboooz.fentanyl.damage.ModDamageTypes;
import net.bamboooz.fentanyl.fluid.ModFluids;
import net.bamboooz.fentanyl.item.ModItemGroups;
import net.bamboooz.fentanyl.item.ModItemTags;
import net.bamboooz.fentanyl.item.ModItems;
import net.bamboooz.fentanyl.sound.ModSounds;
import net.fabricmc.api.ModInitializer;

import net.minecraft.advancement.criterion.Criterion;
import net.minecraft.item.FoodComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fentanyl implements ModInitializer {
	public static final String MOD_ID = "fentanyl";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModCriterions.registerModCriterions();

		ModItems.registerItems();
		ModItemTags.registerItemTags();
		ModItemGroups.registerItemGroups();

		ModBlocks.registerBlocks();
		ModFluids.registerFluids();

		ModEffects.registerEffects();
		ModDamageTypes.registerDamageTypes();
		ModSounds.registerSounds();
	}
}
