package net.bamboooz.fentanyl.datagen;

import net.bamboooz.fentanyl.datagen.recipe.*;
import net.bamboooz.fentanyl.datagen.advancement.ModAdvancementProvider;
import net.bamboooz.fentanyl.datagen.poi.ModPoiTagProvider;
import net.bamboooz.fentanyl.datagen.model.ModModelProvider;
import net.bamboooz.fentanyl.datagen.recipe.create.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class FentanylDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModAdvancementProvider::new);
		pack.addProvider(ModPoiTagProvider::new);

		pack.addProvider(MixingRecipeProvider::new);
		pack.addProvider(CrushingRecipeProvider::new);
		pack.addProvider(MillingRecipeProvider::new);
		pack.addProvider(PressingRecipeProvider::new);
		pack.addProvider(FillingRecipeProvider::new);
	}
}
