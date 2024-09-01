package net.bamboooz.fentanyl.client.sound;

import net.minecraft.client.sound.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.random.Random;

public class MandevilleSound extends MovingSoundInstance {
    public MandevilleSound(SoundEvent soundEvent, SoundCategory soundCategory, Random random) {
        super(soundEvent, soundCategory, random);
    }

    @Override
    public void tick() {

    }
}
