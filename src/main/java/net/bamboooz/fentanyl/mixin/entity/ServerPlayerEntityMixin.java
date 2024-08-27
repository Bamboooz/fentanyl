package net.bamboooz.fentanyl.mixin.entity;

import net.bamboooz.fentanyl.block.ModBlocks;
import net.bamboooz.fentanyl.util.FentanylManager;
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
            FentanylManager.applyDrug(entity, 400);
        }

        if (state.getBlock() == ModBlocks.NALOXONE_FLUID_BLOCK) {
            FentanylManager.removeFentanyl(entity);
        }
    }
}
