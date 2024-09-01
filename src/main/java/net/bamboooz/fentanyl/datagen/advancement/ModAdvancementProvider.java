package net.bamboooz.fentanyl.datagen.advancement;

import net.bamboooz.fentanyl.Fentanyl;
import net.bamboooz.fentanyl.server.effect.ModEffects;
import net.bamboooz.fentanyl.server.tag.ModTags;
import net.bamboooz.fentanyl.server.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.*;
import net.minecraft.item.Items;
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
                        Text.translatable("advancement.fentanyl.root.title"),
                        Text.translatable("advancement.fentanyl.root.description"),
                        Identifier.of(Fentanyl.MOD_ID, "textures/gui/advancements.png"),
                        AdvancementFrame.TASK,
                        false,
                        false,
                        true
                )
                .criterion("always", InventoryChangedCriterion.Conditions.items(ItemPredicate.ANY))
                .build(consumer, Fentanyl.MOD_ID + "/root");

        Advancement precursorAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.POPPY_SEEDS,
                        Text.translatable("advancement.fentanyl.obtain_precursor_to_fentanyl.title"),
                        Text.translatable("advancement.fentanyl.obtain_precursor_to_fentanyl.description"),
                        Identifier.of(Fentanyl.MOD_ID, "textures/gui/advancements.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("obtain_precursor_to_fentanyl", InventoryChangedCriterion.Conditions.items(
                        ItemPredicate.Builder.create()
                                .items(ModItems.POPPY_SEEDS)
                                .build())
                )
                .build(consumer, Fentanyl.MOD_ID + "/obtain_precursor_to_fentanyl");

        Advancement fentanylAdvancement = Advancement.Builder.create().parent(precursorAdvancement)
                .display(
                        ModItems.FENTANYL_SYRINGE,
                        Text.translatable("advancement.fentanyl.obtain_fentanyl.title"),
                        Text.translatable("advancement.fentanyl.obtain_fentanyl.description"),
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
                        ModItems.FIEND_HAT,
                        Text.translatable("advancement.fentanyl.obtain_fiend_hat.title"),
                        Text.translatable("advancement.fentanyl.obtain_fiend_hat.description"),
                        Identifier.of(Fentanyl.MOD_ID, "textures/gui/advancements.png"),
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false
                )
                .criterion("obtain_fiend_hat", InventoryChangedCriterion.Conditions.items(ModItems.FIEND_HAT))
                .build(consumer, Fentanyl.MOD_ID + "/obtain_fiend_hat");

        Advancement fentanylOverdoseAdvancement = Advancement.Builder.create().parent(fentanylAdvancement)
                .display(
                        ModItems.SKULL,
                        Text.translatable("advancement.fentanyl.overdose_on_fentanyl.title"),
                        Text.translatable("advancement.fentanyl.overdose_on_fentanyl.description"),
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

        Advancement.Builder.create().parent(fentanylOverdoseAdvancement)
                .display(
                        ModItems.NALOXONE_SYRINGE,
                        Text.translatable("advancement.fentanyl.treat_an_overdose.title"),
                        Text.translatable("advancement.fentanyl.treat_an_overdose.description"),
                        Identifier.of(Fentanyl.MOD_ID, "textures/gui/advancements.png"),
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("treat_an_overdose", EffectsChangedCriterion.Conditions.create(
                        EntityEffectPredicate.create()
                                .withEffect(ModEffects.NALOXONE)
                                .withEffect(ModEffects.FENTANYL, new EntityEffectPredicate.EffectData(NumberRange.IntRange.atLeast(2), NumberRange.IntRange.ANY, null, null))
                ))
                .build(consumer, Fentanyl.MOD_ID + "/treat_an_overdose");

        Advancement.Builder.create().parent(fentanylAdvancement)
                .display(
                        Items.FIREWORK_ROCKET,
                        Text.translatable("advancement.fentanyl.ingest_fentanyl.title"),
                        Text.translatable("advancement.fentanyl.ingest_fentanyl.description"),
                        Identifier.of(Fentanyl.MOD_ID, "textures/gui/advancements.png"),
                        AdvancementFrame.TASK,
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
