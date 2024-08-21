package net.bamboooz.fentanyl.datagen.create;

import com.simibubi.create.foundation.data.recipe.CrushingRecipeGen;
import net.bamboooz.fentanyl.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.util.Identifier;

public class CrushingRecipeProvider extends CrushingRecipeGen {
    GeneratedRecipe
            CRUSHED_POPPY_SEEDS = create(Identifier.tryParse("crushed_poppy_seeds_from_poppy_seeds"), b ->
                b.require(ModItems.POPPY_SEEDS)
                .output(ModItems.CRUSHED_POPPY_SEEDS));

    public CrushingRecipeProvider(FabricDataOutput output) {
        super(output);
    }
}
