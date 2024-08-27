package net.bamboooz.fentanyl.block;

import net.bamboooz.fentanyl.Fentanyl;
import net.bamboooz.fentanyl.block.syringe.FentanylSyringeBlock;
import net.bamboooz.fentanyl.block.syringe.NaloxoneSyringeBlock;
import net.bamboooz.fentanyl.block.syringe.SyringeBlock;
import net.bamboooz.fentanyl.fluid.ModFluids;
import net.bamboooz.fentanyl.item.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block SYRINGE_BLOCK = registerBlock("syringe_block",
            new SyringeBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque()));
    public static final Block FENTANYL_SYRINGE_BLOCK = registerBlock("fentanyl_syringe_block",
            new FentanylSyringeBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque()));
    public static final Block NALOXONE_SYRINGE_BLOCK = registerBlock("naloxone_syringe_block",
            new NaloxoneSyringeBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque()));

    public static final Block FENTANYL_FLUID_BLOCK = registerBlockWithoutBlockItem("fentanyl_fluid_block",
            new FluidBlock(ModFluids.FENTANYL_STILL, FabricBlockSettings.copyOf(Blocks.WATER)
                    .noCollision().nonOpaque().dropsNothing()));
    public static final Block NALOXONE_FLUID_BLOCK = registerBlockWithoutBlockItem("naloxone_fluid_block",
            new FluidBlock(ModFluids.NALOXONE_STILL, FabricBlockSettings.copyOf(Blocks.WATER)
                    .noCollision().nonOpaque().dropsNothing()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);

        return Registry.register(Registries.BLOCK, Identifier.of(Fentanyl.MOD_ID, name), block);
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(Fentanyl.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        ModItems.registerItem(name, new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerBlocks() {
        Fentanyl.LOGGER.info("Registering mod blocks for " + Fentanyl.MOD_ID);
    }
}
