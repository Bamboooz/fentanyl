package net.bamboooz.fentanyl.datagen.recipe.create;

import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.foundation.data.recipe.ProcessingRecipeGen;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import net.bamboooz.fentanyl.server.fluid.ModFluids;
import net.bamboooz.fentanyl.server.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.minecraft.util.Identifier;

public class FillingRecipeProvider extends ProcessingRecipeGen {
    GeneratedRecipe
            FENTANYL_SYRINGE = create(Identifier.tryParse("fentanyl_syringe"), b -> b
                .require(ModFluids.FENTANYL_STILL, FluidConstants.BUCKET / 2)
                .require(ModItems.SYRINGE)
                .output(ModItems.FENTANYL_SYRINGE)),

            NALOXONE_SYRINGE = create(Identifier.tryParse("naloxone_syringe"), b -> b
                .require(ModFluids.NALOXONE_STILL, FluidConstants.BUCKET / 2)
                .require(ModItems.SYRINGE)
                .output(ModItems.NALOXONE_SYRINGE));

    public FillingRecipeProvider(FabricDataOutput generator) {
        super(generator);
    }

    @Override
    protected IRecipeTypeInfo getRecipeType() {
        return AllRecipeTypes.FILLING;
    }
}
