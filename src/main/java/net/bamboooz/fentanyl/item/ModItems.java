package net.bamboooz.fentanyl.item;

import net.bamboooz.fentanyl.Fentanyl;
import net.bamboooz.fentanyl.fluid.ModFluids;
import net.bamboooz.fentanyl.item.drug.FentanylPowder;
import net.bamboooz.fentanyl.item.drug.Tar;
import net.bamboooz.fentanyl.item.syringe.BrokenSyringe;
import net.bamboooz.fentanyl.item.syringe.FentanylSyringe;
import net.bamboooz.fentanyl.item.syringe.Syringe;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SYRINGE = registerItem("syringe", new Syringe(new Item.Settings()));
    public static final Item BROKEN_SYRINGE = registerItem("broken_syringe", new BrokenSyringe(new Item.Settings()));

    public static final Item FENTANYL_POWDER = registerItem("fentanyl_powder", new FentanylPowder(new Item.Settings()));
    public static final Item FENTANYL_SYRINGE = registerItem("fentanyl_syringe", new FentanylSyringe(new Item.Settings()));
    public static final Item FENTANYL_BUCKET = registerItem("fentanyl_bucket", new BucketItem(ModFluids.FENTANYL_STILL, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));

    public static final Item POPPY_SEEDS = registerItem("poppy_seeds", new Item(new Item.Settings()));
    public static final Item CRUSHED_POPPY_SEEDS = registerItem("crushed_poppy_seeds", new Item(new Item.Settings()));
    public static final Item TAR = registerItem("tar", new Tar(new Item.Settings()));

    public static final Item FENT_FRIDAY = registerItem("fent_friday", new Item(new Item.Settings()));
    public static final Item FENT_OVERDOSE = registerItem("fent_overdose", new Item(new Item.Settings()));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Fentanyl.MOD_ID, name), item);
    }

    public static void registerItems() {
        Fentanyl.LOGGER.info("Registering mod items for " + Fentanyl.MOD_ID);
    }
}
