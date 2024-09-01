package net.bamboooz.fentanyl.mixin.server;

import net.bamboooz.fentanyl.server.block.ModBlocks;
import net.bamboooz.fentanyl.server.util.FentanylManager;
import net.bamboooz.fentanyl.server.util.NaloxoneManager;
import net.minecraft.block.BlockState;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntityMixin {
    @Inject(method = "onBlockCollision", at = @At("HEAD"))
    protected void onBlockCollision(BlockState state, CallbackInfo ci) {
        ServerPlayerEntity entity = (ServerPlayerEntity) (Object) this;

        if (state.getBlock() == ModBlocks.FENTANYL_FLUID_BLOCK) {
            FentanylManager.applyDrug(entity, 600);
        }

        if (state.getBlock() == ModBlocks.NALOXONE_FLUID_BLOCK) {
            NaloxoneManager.applyDrug(entity);
        }
    }
}
