package net.bamboooz.fentanyl.datagen.create;

import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.foundation.data.recipe.ProcessingRecipeGen;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import net.bamboooz.fentanyl.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.util.Identifier;

public class PressingRecipeProvider extends ProcessingRecipeGen {
    GeneratedRecipe
            FENTANYL_PILLS = create(Identifier.tryParse("fentanyl_pills"), b -> b
                .require(ModItems.FENTANYL_POWDER)
                .output(ModItems.FENTANYL_PILLS));

    public PressingRecipeProvider(FabricDataOutput generator) {
        super(generator);
    }

    @Override
    protected IRecipeTypeInfo getRecipeType() {
        return AllRecipeTypes.PRESSING;
    }
}
