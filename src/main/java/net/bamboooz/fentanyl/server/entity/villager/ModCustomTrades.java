package net.bamboooz.fentanyl.server.entity.villager;

import net.bamboooz.fentanyl.Fentanyl;
import net.bamboooz.fentanyl.server.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;

public class ModCustomTrades {
    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(ModVillagers.FIEND, 1,
                factories -> factories.add((entity, random) -> new TradeOffer(
                        new ItemStack(Items.EMERALD, 2),
                        new ItemStack(ModItems.SYRINGE, 1),
                        10, 5, 0.05f)));

        TradeOfferHelper.registerVillagerOffers(ModVillagers.FIEND, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 6),
                            new ItemStack(ModItems.FENTANYL_SYRINGE, 1),
                            1, 24, 0.075f));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 12),
                            new ItemStack(ModItems.FENTANYL_POWDER, 1),
                            1, 48, 0.1f));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 12),
                            new ItemStack(ModItems.FENTANYL_PILLS, 1),
                            1, 48, 0.1f));
                });

        Fentanyl.LOGGER.info("Registering mod trades for " + Fentanyl.MOD_ID);
    }
}
