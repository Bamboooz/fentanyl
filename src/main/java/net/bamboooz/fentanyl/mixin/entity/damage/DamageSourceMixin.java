package net.bamboooz.fentanyl.mixin.entity.damage;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(DamageSource.class)
public class DamageSourceMixin {
    @Shadow
    @Nullable
    @Final
    private Entity attacker;

    @Shadow
    @Nullable
    @Final
    private Entity source;

    @Inject(method = "getDeathMessage", at = @At("HEAD"), cancellable = true)
    public void getDeathMessage(LivingEntity killed, CallbackInfoReturnable<Text> cir) {
        DamageSource damageSource = (DamageSource) (Object) this;

        String id = damageSource.getType().msgId();

        if (!Objects.equals(id, "pricking")) {
            return;
        }

        if (this.attacker == killed || this.source == killed) {
            return;
        }

        if (this.attacker != null) {
            String entry = "death.attack.pricking.player";

            Text text = Text.translatable(entry, killed.getDisplayName(), this.attacker.getDisplayName());

            cir.setReturnValue(text);
        }
    }
}
