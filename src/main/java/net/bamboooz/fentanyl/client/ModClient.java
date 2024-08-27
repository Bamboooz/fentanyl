package net.bamboooz.fentanyl.client;

import net.bamboooz.fentanyl.fluid.ModFluids;
import net.bamboooz.fentanyl.util.FentanylManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.fluid.Fluid;

@Environment(EnvType.CLIENT)
public class ModClient implements ClientModInitializer {
    private static void registerFluid(Fluid fluid, int tint) {
        FluidRenderHandlerRegistry.INSTANCE.register(fluid,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY,
                        tint));
    }

    @Override
    public void onInitializeClient() {
        registerFluid(ModFluids.FENTANYL_STILL, FentanylManager.FENTANYL_TINT);
        registerFluid(ModFluids.FENTANYL_FLOWING, FentanylManager.FENTANYL_TINT);

        registerFluid(ModFluids.NALOXONE_STILL, FentanylManager.NALOXONE_TINT);
        registerFluid(ModFluids.NALOXONE_FLOWING, FentanylManager.NALOXONE_TINT);
    }
}
