package net.bamboooz.fentanyl.client;

import net.bamboooz.fentanyl.fluid.ModFluids;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;

@Environment(EnvType.CLIENT)
public class ModClient implements ClientModInitializer {
    public static final int FENTANYL_FLUID_TINT = 0xA8CAD1;

    @Override
    public void onInitializeClient() {
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.FENTANYL_STILL,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, FENTANYL_FLUID_TINT));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.FENTANYL_FLOWING,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, FENTANYL_FLUID_TINT));
    }
}
