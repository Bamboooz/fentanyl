package net.bamboooz.fentanyl.server.item;

import net.bamboooz.fentanyl.Fentanyl;
import net.bamboooz.fentanyl.server.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup FENTANYL_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(Fentanyl.MOD_ID, "fentanyl_syringe"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.fentanyl"))
                    .icon(() -> new ItemStack(ModItems.FENTANYL_SYRINGE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.POPPY_SEEDS);
                        entries.add(ModItems.CRUSHED_POPPY_SEEDS);
                        entries.add(ModItems.TAR);
                        entries.add(ModItems.SYRINGE);
                        entries.add(ModItems.BROKEN_SYRINGE);
                        entries.add(ModItems.FENTANYL_SYRINGE);
                        entries.add(ModItems.FENTANYL_POWDER);
                        entries.add(ModBlocks.FENTANYL_BLOCK);
                        entries.add(ModItems.FENTANYL_BUCKET);
                        entries.add(ModItems.FENTANYL_PILLS);
                        entries.add(ModItems.NALOXONE_SYRINGE);
                        entries.add(ModItems.NALOXONE_BUCKET);
                        entries.add(ModItems.SKULL);
                        entries.add(ModItems.FIEND_HAT);
                    }).build()
    );

    public static void registerItemGroups() {
        Fentanyl.LOGGER.info("Registering mod item groups for " + Fentanyl.MOD_ID);
    }
}
