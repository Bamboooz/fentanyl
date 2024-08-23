package net.bamboooz.fentanyl.item.drug;

import net.bamboooz.fentanyl.sound.ModSounds;
import net.bamboooz.fentanyl.util.FentanylManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public abstract class AbstractDrug extends Item {
    public AbstractDrug(Settings settings) {
        super(settings);
    }

    public abstract int fentanylUnits();

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        user.getItemCooldownManager().set(this, 20);

        if (!world.isClient) {
            world.playSound(null, user.getBlockPos(), ModSounds.SNORT, SoundCategory.NEUTRAL, 1f, 1f);

            FentanylManager.applyDrug(user, fentanylUnits());
        }

        if (!user.getAbilities().creativeMode) {
            stack.decrement(1);
        }

        return TypedActionResult.success(stack, world.isClient());
    }
}
