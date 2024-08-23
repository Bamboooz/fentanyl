package net.bamboooz.fentanyl.item;

import net.bamboooz.fentanyl.Fentanyl;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
    public static final TagKey<Item> FENTANYL = createTag("fentanyl");

    private static TagKey<Item> createTag(String name) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(Fentanyl.MOD_ID, name));
    }

    public static void registerItemTags() {
        Fentanyl.LOGGER.info("Registering mod item tags for " + Fentanyl.MOD_ID);
    }
}
