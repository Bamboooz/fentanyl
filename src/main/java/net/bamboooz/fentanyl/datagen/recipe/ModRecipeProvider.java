package net.bamboooz.fentanyl.datagen.recipe;

import net.bamboooz.fentanyl.Fentanyl;
import net.bamboooz.fentanyl.server.block.ModBlocks;
import net.bamboooz.fentanyl.server.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.FENTANYL_POWDER, RecipeCategory.DECORATIONS,
                ModBlocks.FENTANYL_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FENTANYL_BUCKET, 1)
                .input(Items.WATER_BUCKET)
                .input(ModItems.FENTANYL_POWDER)
                .criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET))
                .criterion(hasItem(ModItems.FENTANYL_POWDER), conditionsFromItem(ModItems.FENTANYL_POWDER))
                .offerTo(exporter, Identifier.of(Fentanyl.MOD_ID, getRecipeName(ModItems.FENTANYL_BUCKET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SYRINGE, 1)
                .pattern("  i")
                .pattern(" g ")
                .pattern("g  ")
                .input('i', Items.IRON_NUGGET)
                .input('g', Items.GLASS)
                .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                .criterion(hasItem(Items.GLASS), conditionsFromItem(Items.GLASS))
                .offerTo(exporter, Identifier.of(Fentanyl.MOD_ID, getRecipeName(ModItems.SYRINGE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.POPPY_SEEDS, 2)
                .input(Items.POPPY)
                .input(Items.POPPY)
                .criterion(hasItem(Items.POPPY), conditionsFromItem(Items.POPPY))
                .offerTo(exporter, Identifier.of(Fentanyl.MOD_ID, getRecipeName(ModItems.POPPY_SEEDS)));
    }
}
