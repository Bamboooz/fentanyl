package net.bamboooz.fentanyl.datagen.recipe.create;

import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import com.simibubi.create.foundation.data.recipe.ProcessingRecipeGen;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import net.bamboooz.fentanyl.server.fluid.ModFluids;
import net.bamboooz.fentanyl.server.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.Identifier;

public class MixingRecipeProvider extends ProcessingRecipeGen {
    GeneratedRecipe
            LIQUID_FENTANYL = create(Identifier.tryParse("liquid_fentanyl"), b -> b
                .require(Fluids.WATER, FluidConstants.BUCKET)
                .require(ModItems.CRUSHED_POPPY_SEEDS)
                .output(ModFluids.FENTANYL_STILL, FluidConstants.BOTTLE)
                .output(ModItems.TAR)
                .requiresHeat(HeatCondition.HEATED)),

            FENTANYL_POWDER = create(Identifier.tryParse("fentanyl_powder"), b -> b
                .require(ModFluids.FENTANYL_STILL, FluidConstants.BUCKET)
                .output(ModItems.FENTANYL_POWDER)
                .requiresHeat(HeatCondition.SUPERHEATED)),

            LIQUID_NALOXONE = create(Identifier.tryParse("liquid_naloxone"), b -> b
                .require(ModFluids.FENTANYL_STILL, FluidConstants.BUCKET)
                .output(ModFluids.NALOXONE_STILL, FluidConstants.BOTTLE)
                .requiresHeat(HeatCondition.SUPERHEATED));

    public MixingRecipeProvider(FabricDataOutput generator) {
        super(generator);
    }

    @Override
    protected IRecipeTypeInfo getRecipeType() {
        return AllRecipeTypes.MIXING;
    }
}
