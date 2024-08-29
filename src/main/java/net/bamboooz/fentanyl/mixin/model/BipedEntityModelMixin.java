package net.bamboooz.fentanyl.mixin.model;

import net.bamboooz.fentanyl.effect.ModEffects;
import net.bamboooz.fentanyl.util.FentanylManager;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BipedEntityModel.class)
public class BipedEntityModelMixin<T extends LivingEntity> {
    @Final
    @Shadow
    public ModelPart head;

    @Final
    @Shadow
    public ModelPart hat;

    @Final
    @Shadow
    public ModelPart body;

    @Final
    @Shadow
    public ModelPart rightArm;

    @Final
    @Shadow
    public ModelPart leftArm;

    @Inject(method = "setAngles(Lnet/minecraft/entity/LivingEntity;FFFFF)V", at = @At("HEAD"))
    public void setAngles(T livingEntity, float f, float g, float h, float i, float j, CallbackInfo ci) {
        if (FentanylManager.isCooked(livingEntity)) {
            this.head.pitch = MathHelper.PI / 2;
            this.head.pivotY = 10;
            this.head.pivotZ = -10;

            this.hat.pitch = MathHelper.PI / 2;
            this.hat.pivotY = 10;
            this.hat.pivotZ = -10;

            this.body.pitch = MathHelper.PI / 2;
            this.body.pivotY = 10;
            this.body.pivotZ = -10;

            this.leftArm.pitch = 0;
            this.leftArm.pivotY = 10;
            this.leftArm.pivotZ = -8;

            this.rightArm.pitch = 0;
            this.rightArm.pivotY = 10;
            this.rightArm.pivotZ = -8;
        }
    }
}
