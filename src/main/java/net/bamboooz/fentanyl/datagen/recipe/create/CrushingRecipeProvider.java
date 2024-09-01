package net.bamboooz.fentanyl.datagen.recipe.create;

import com.simibubi.create.foundation.data.recipe.CrushingRecipeGen;
import net.bamboooz.fentanyl.server.block.ModBlocks;
import net.bamboooz.fentanyl.server.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.util.Identifier;

public class CrushingRecipeProvider extends CrushingRecipeGen {
    GeneratedRecipe
            CRUSHED_POPPY_SEEDS = create(Identifier.tryParse("crushed_poppy_seeds"), b -> b
                .duration(50)
                .require(ModItems.POPPY_SEEDS)
                .output(ModItems.CRUSHED_POPPY_SEEDS)),

            FENTANYL_POWDER = create(Identifier.tryParse("fentanyl_powder"), b -> b
                    .duration(50)
                    .require(ModItems.FENTANYL_PILLS)
                    .output(ModItems.FENTANYL_POWDER)),

            FENTANYL_POWDER_FROM_BLOCK = create(Identifier.tryParse("fentanyl_powder_from_block"), b -> b
                    .duration(100)
                    .require(ModBlocks.FENTANYL_BLOCK)
                    .output(ModItems.FENTANYL_POWDER, 9));

    public CrushingRecipeProvider(FabricDataOutput output) {
        super(output);
    }
}
