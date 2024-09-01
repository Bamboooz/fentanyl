package net.bamboooz.fentanyl.server.tag;

import net.bamboooz.fentanyl.Fentanyl;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> FENTANYL = createTag("fentanyl");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Fentanyl.MOD_ID, name));
        }
    }

    public static void registerTags() {
        Fentanyl.LOGGER.info("Registering mod tags for " + Fentanyl.MOD_ID);
    }
}
