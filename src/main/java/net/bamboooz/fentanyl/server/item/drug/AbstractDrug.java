package net.bamboooz.fentanyl.server.item.drug;

import net.bamboooz.fentanyl.server.sound.ModSounds;
import net.bamboooz.fentanyl.server.util.FentanylManager;
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

    public abstract void onUse(PlayerEntity user);

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.getItemCooldownManager().set(this, 20);

        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient) {
            world.playSound(null, user.getBlockPos(), ModSounds.SNORT, SoundCategory.NEUTRAL, 1f, 1f);

            FentanylManager.applyDrug(user, fentanylUnits());

            onUse(user);
        }

        if (!user.getAbilities().creativeMode) {
            stack.decrement(1);
        }

        return TypedActionResult.success(stack, world.isClient());
    }
}
