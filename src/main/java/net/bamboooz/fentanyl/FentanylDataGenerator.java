package net.bamboooz.fentanyl;

import net.bamboooz.fentanyl.datagen.ModAdvancementProvider;
import net.bamboooz.fentanyl.datagen.ModPoiTagProvider;
import net.bamboooz.fentanyl.datagen.create.CrushingRecipeProvider;
import net.bamboooz.fentanyl.datagen.create.MillingRecipeProvider;
import net.bamboooz.fentanyl.datagen.create.MixingRecipeProvider;
import net.bamboooz.fentanyl.datagen.ModModelProvider;
import net.bamboooz.fentanyl.datagen.ModRecipeProvider;
import net.bamboooz.fentanyl.datagen.create.PressingRecipeProvider;
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
	}
}
