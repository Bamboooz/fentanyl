package net.bamboooz.fentanyl;

import net.bamboooz.fentanyl.datagen.create.CrushingRecipeProvider;
import net.bamboooz.fentanyl.datagen.create.MixingRecipeProvider;
import net.bamboooz.fentanyl.datagen.ModModelProvider;
import net.bamboooz.fentanyl.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class FentanylDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(MixingRecipeProvider::new);
		pack.addProvider(CrushingRecipeProvider::new);
	}
}
