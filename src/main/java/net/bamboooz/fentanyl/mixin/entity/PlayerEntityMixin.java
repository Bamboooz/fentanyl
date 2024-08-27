package net.bamboooz.fentanyl.mixin.entity;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.bamboooz.fentanyl.effect.ModEffects;
import net.bamboooz.fentanyl.sound.custom.MandevilleSound;
import net.bamboooz.fentanyl.sound.ModSounds;
import net.bamboooz.fentanyl.util.FentanylManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
    @Unique
    private static final MandevilleSound sound = new MandevilleSound(ModSounds.MANDEVILLE, SoundCategory.AMBIENT, SoundInstance.createRandom());

    @Inject(method = "tick", at = @At("HEAD"))
    public void tick(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        MinecraftClient client = MinecraftClient.getInstance();
        SoundManager manager = client.getSoundManager();

        boolean hasEffect = player.hasStatusEffect(ModEffects.FENTANYL);
        boolean isPlaying = manager.isPlaying(sound);

        if (hasEffect && !isPlaying) {
            manager.play(sound);
        } else if (!hasEffect && isPlaying) {
            manager.stop(sound);
        }
    }

    @ModifyReturnValue(method = "shouldSwimInFluids", at = @At("RETURN"))
    public boolean shouldSwimInFluids(boolean original) {
        PlayerEntity player = (PlayerEntity) (Object) this;

        boolean isInFluid = !player.getWorld().getBlockState(player.getBlockPos()).getFluidState().isEmpty();

        return (!FentanylManager.isCooked(player) || !isInFluid) && original;
    }

    @ModifyReturnValue(method = "isSwimming", at = @At("RETURN"))
    public boolean isSwimming(boolean original) {
        PlayerEntity player = (PlayerEntity) (Object) this;

        return !FentanylManager.isCooked(player) && original;
    }
}
