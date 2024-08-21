package net.bamboooz.fentanyl.datagen.create;

import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import com.simibubi.create.foundation.data.recipe.ProcessingRecipeGen;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import net.bamboooz.fentanyl.fluid.ModFluids;
import net.bamboooz.fentanyl.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.Identifier;

public class MixingRecipeProvider extends ProcessingRecipeGen {
    GeneratedRecipe
            LIQUID_FENTANYL = create(Identifier.tryParse("liquid_fentanyl_from_water_and_crushed_poppy_seeds"), b -> b
                .require(Fluids.WATER, FluidConstants.BUCKET)
                .require(ModItems.CRUSHED_POPPY_SEEDS)
                .output(ModFluids.FENTANYL_STILL, FluidConstants.BOTTLE)
                .output(ModItems.TAR)
                .requiresHeat(HeatCondition.HEATED)),

            FENTANYL_POWDER = create(Identifier.tryParse("fentanyl_powder_from_liquid_fentanyl"), b -> b
                .require(ModFluids.FENTANYL_STILL, FluidConstants.BUCKET)
                .output(ModItems.FENTANYL_POWDER)
                .requiresHeat(HeatCondition.SUPERHEATED)),

            FENTANYL_SYRINGE = create(Identifier.tryParse("fentanyl_syringe_from_liquid_fentanyl_and_syringe"), b -> b
                .require(ModFluids.FENTANYL_STILL, FluidConstants.BUCKET)
                .require(ModItems.SYRINGE)
                .output(ModItems.FENTANYL_SYRINGE));

    public MixingRecipeProvider(FabricDataOutput generator) {
        super(generator);
    }

    @Override
    protected IRecipeTypeInfo getRecipeType() {
        return AllRecipeTypes.MIXING;
    }
}
