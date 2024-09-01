package net.bamboooz.fentanyl.mixin.entity;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.bamboooz.fentanyl.server.effect.ModEffects;
import net.bamboooz.fentanyl.server.util.FentanylManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = "baseTick", at = @At("HEAD"))
    public void baseTick(CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;
        StatusEffectInstance effect = entity.getStatusEffect(ModEffects.FENTANYL);

        if (effect == null) {
            return;
        }

        int amplifier = effect.getAmplifier();
        int duration = effect.getDuration();

        if (amplifier > 0 && duration == 1) {
            entity.removeStatusEffect(ModEffects.FENTANYL);

            FentanylManager.applyDrug(entity, amplifier * FentanylManager.FENTANYL_LEVEL_TIME);
        }
    }

    @ModifyReturnValue(method = "isClimbing", at = @At("RETURN"))
    public boolean isClimbing(boolean original) {
        LivingEntity entity = (LivingEntity) (Object) this;

        return !FentanylManager.isCooked(entity) && original;
    }
}
