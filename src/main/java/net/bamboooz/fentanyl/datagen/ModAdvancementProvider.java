package net.bamboooz.fentanyl.datagen;

import net.bamboooz.fentanyl.Fentanyl;
import net.bamboooz.fentanyl.effect.ModEffects;
import net.bamboooz.fentanyl.util.ModTags;
import net.bamboooz.fentanyl.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.*;
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
                        Text.literal("Create: Fentanyl"),
                        Text.literal("Let there be fent"),
                        Identifier.of(Fentanyl.MOD_ID, "textures/gui/advancements.png"),
                        AdvancementFrame.TASK,
                        false,
                        false,
                        true
                )
                .criterion("always", InventoryChangedCriterion.Conditions.items(ItemPredicate.ANY))
                .build(consumer, Fentanyl.MOD_ID + "/root");

        Advancement fentanylAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.FENTANYL_SYRINGE,
                        Text.literal("Fentanyl"),
                        Text.literal("Obtain fentanyl in any form for the first time"),
                        Identifier.of(Fentanyl.MOD_ID, "textures/gui/advancements.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("obtain_fentanyl", InventoryChangedCriterion.Conditions.items(
                        ItemPredicate.Builder.create()
                                .tag(ModTags.Items.FENTANYL)
                                .build())
                )
                .build(consumer, Fentanyl.MOD_ID + "/obtain_fentanyl");

        Advancement.Builder.create().parent(fentanylAdvancement)
                .display(
                        ModItems.NALOXONE_SYRINGE,
                        Text.literal("Party Pooper"),
                        Text.literal("Inject someones ass with naloxone"),
                        Identifier.of(Fentanyl.MOD_ID, "textures/gui/advancements.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("use_naloxone", new ImpossibleCriterion.Conditions())
                .build(consumer, Fentanyl.MOD_ID + "/use_naloxone");

        Advancement.Builder.create().parent(fentanylAdvancement)
                .display(
                        ModItems.ADVANCEMENT_FENT_OVERDOSE,
                        Text.literal("I saw him fent"),
                        Text.literal("Overdose on fentanyl"),
                        Identifier.of(Fentanyl.MOD_ID, "textures/gui/advancements.png"),
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

        Advancement.Builder.create().parent(fentanylAdvancement)
                .display(
                        ModItems.ADVANCEMENT_FENT_FRIDAY,
                        Text.literal("Fent Friday"),
                        Text.literal("Get fentanyl into your system"),
                        Identifier.of(Fentanyl.MOD_ID, "textures/gui/advancements.png"),
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("ingest_fentanyl", EffectsChangedCriterion.Conditions.create(
                        EntityEffectPredicate.create()
                                .withEffect(ModEffects.FENTANYL)
                ))
                .build(consumer, Fentanyl.MOD_ID + "/ingest_fentanyl");
    }
}
