package net.bamboooz.fentanyl.fluid;

import net.bamboooz.fentanyl.Fentanyl;
import net.bamboooz.fentanyl.fluid.drug.FentanylFluid;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
    public static final FlowableFluid FENTANYL_STILL = registerFluid("fentanyl_still", new FentanylFluid.Still());
    public static final FlowableFluid FENTANYL_FLOWING = registerFluid("fentanyl_flowing", new FentanylFluid.Flowing());

    private static FlowableFluid registerFluid(String name, FlowableFluid flowableFluid) {
        return Registry.register(Registries.FLUID, Identifier.of(Fentanyl.MOD_ID, name), flowableFluid);
    }

    public static void registerFluids() {
        Fentanyl.LOGGER.info("Registering mod fluids for " + Fentanyl.MOD_ID);
    }
}
