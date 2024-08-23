package net.bamboooz.fentanyl.mixin.entity;

import net.bamboooz.fentanyl.effect.ModEffects;
import net.bamboooz.fentanyl.sound.custom.FentanylSound;
import net.bamboooz.fentanyl.sound.ModSounds;
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
    private static final FentanylSound sound = new FentanylSound(ModSounds.MANDEVILLE, SoundCategory.AMBIENT, SoundInstance.createRandom());

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
}
