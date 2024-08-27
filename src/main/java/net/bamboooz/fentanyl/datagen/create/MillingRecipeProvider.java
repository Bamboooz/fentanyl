package net.bamboooz.fentanyl.datagen.create;

import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.foundation.data.recipe.ProcessingRecipeGen;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import net.bamboooz.fentanyl.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.util.Identifier;

public class MillingRecipeProvider extends ProcessingRecipeGen {
    GeneratedRecipe
            CRUSHED_POPPY_SEEDS = create(Identifier.tryParse("crushed_poppy_seeds"), b -> b
                .duration(50)
                .require(ModItems.POPPY_SEEDS)
                .output(ModItems.CRUSHED_POPPY_SEEDS));

    public MillingRecipeProvider(FabricDataOutput generator) {
        super(generator);
    }

    @Override
    protected IRecipeTypeInfo getRecipeType() {
        return AllRecipeTypes.MILLING;
    }
}
