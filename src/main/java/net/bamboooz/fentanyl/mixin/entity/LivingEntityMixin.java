package net.bamboooz.fentanyl.mixin.entity;

import net.bamboooz.fentanyl.effect.ModEffects;
import net.bamboooz.fentanyl.entity.IEntityDataSaver;
import net.bamboooz.fentanyl.util.FentanylData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = "baseTick", at = @At("HEAD"))
    public void baseTick(CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;
        IEntityDataSaver saver = (IEntityDataSaver) entity;
        NbtCompound nbt = saver.fentanyl$getPersistentData();

        int fentanylLevel = nbt.getInt("fentanyl");
        // entity.sendMessage(Text.literal("Fentanyl Level: " + fentanylLevel));

        if (fentanylLevel == 0) {
            entity.removeStatusEffect(ModEffects.FENTANYL);
            return;
        }

        int effectLevel = FentanylData.effectLevel(fentanylLevel);

        StatusEffectInstance currentEffect = entity.getStatusEffect(ModEffects.FENTANYL);

        if (currentEffect != null && currentEffect.getAmplifier() != effectLevel) {
            entity.removeStatusEffect(ModEffects.FENTANYL);

            FentanylData.applyEffect(entity, effectLevel);
        } else {
            FentanylData.applyEffect(entity, effectLevel);
        }

        fentanylLevel = Math.max(fentanylLevel - 1, 0);

        nbt.putInt("fentanyl", fentanylLevel);
    }
}
