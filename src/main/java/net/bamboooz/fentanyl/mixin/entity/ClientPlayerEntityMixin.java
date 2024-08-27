package net.bamboooz.fentanyl.mixin.entity;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.bamboooz.fentanyl.util.FentanylManager;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
    @ModifyReturnValue(method = "isRiding", at = @At("RETURN"))
    public boolean isRiding(boolean original) {
        ClientPlayerEntity player = (ClientPlayerEntity) (Object) this;

        return !FentanylManager.isCooked(player) && original;
    }
}
