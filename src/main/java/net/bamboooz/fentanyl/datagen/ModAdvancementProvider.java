package net.bamboooz.fentanyl.datagen;

import net.bamboooz.fentanyl.Fentanyl;
import net.bamboooz.fentanyl.effect.ModEffects;
import net.bamboooz.fentanyl.item.ModItemTags;
import net.bamboooz.fentanyl.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.EffectsChangedCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.entity.EntityEffectPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement rootAdvancement = Advancement.Builder.create()
                .display(
                        ModItems.FENTANYL_POWDER,
                        Text.literal("Fentanyl"),
                        Text.literal("Obtain fentanyl in any form for the first time"),
                        new Identifier("textures/block/snow.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("obtain_fentanyl", InventoryChangedCriterion.Conditions.items(
                        ItemPredicate.Builder.create()
                                .tag(ModItemTags.FENTANYL)
                                .build())
                )
                .build(consumer, Fentanyl.MOD_ID + "/root");

        Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.FENT_OVERDOSE,
                        Text.literal("I saw him fent"),
                        Text.literal("Overdose on fentanyl"),
                        new Identifier("textures/block/snow.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("overdose_on_fentanyl", EffectsChangedCriterion.Conditions.create(
                        EntityEffectPredicate.create()
                                .withEffect(ModEffects.FENTANYL, new EntityEffectPredicate.EffectData(NumberRange.IntRange.atLeast(2), NumberRange.IntRange.ANY, null, null))
                ))
                .build(consumer, Fentanyl.MOD_ID + "/overdose_on_fentanyl");

        Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.FENT_FRIDAY,
                        Text.literal("Fent Friday"),
                        Text.literal("Get freaky on a friday night"),
                        new Identifier("textures/block/snow.png"),
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false
                )
                .criterion("ingest_fentanyl_on_friday", EffectsChangedCriterion.Conditions.create(
                        EntityEffectPredicate.create()
                                .withEffect(ModEffects.FENTANYL)
                ))
                .build(consumer, Fentanyl.MOD_ID + "/ingest_fentanyl_on_friday");
    }
}
