package net.bamboooz.fentanyl.datagen.model;

import net.bamboooz.fentanyl.server.block.ModBlocks;
import net.bamboooz.fentanyl.server.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FENTANYL_BLOCK);

        blockStateModelGenerator.registerSimpleState(ModBlocks.SYRINGE_BLOCK);
        blockStateModelGenerator.registerSimpleState(ModBlocks.FENTANYL_SYRINGE_BLOCK);
        blockStateModelGenerator.registerSimpleState(ModBlocks.NALOXONE_SYRINGE_BLOCK);

        blockStateModelGenerator.registerSimpleState(ModBlocks.FENTANYL_FLUID_BLOCK);
        blockStateModelGenerator.registerSimpleState(ModBlocks.NALOXONE_FLUID_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SYRINGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BROKEN_SYRINGE, Models.GENERATED);

        itemModelGenerator.register(ModItems.FENTANYL_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.FENTANYL_SYRINGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FENTANYL_PILLS, Models.GENERATED);
        itemModelGenerator.register(ModItems.FENTANYL_BUCKET, Models.GENERATED);

        itemModelGenerator.register(ModItems.NALOXONE_SYRINGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.NALOXONE_BUCKET, Models.GENERATED);

        itemModelGenerator.register(ModItems.POPPY_SEEDS, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRUSHED_POPPY_SEEDS, Models.GENERATED);
        itemModelGenerator.register(ModItems.TAR, Models.GENERATED);

        itemModelGenerator.register(ModItems.FIEND_HAT, Models.GENERATED);

        itemModelGenerator.register(ModItems.SKULL, Models.GENERATED);
    }
}
