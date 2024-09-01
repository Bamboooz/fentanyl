package net.bamboooz.fentanyl.server.item.drug;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Skull extends AbstractDrug {
    public Skull(Settings settings) {
        super(settings);
    }

    @Override
    public int fentanylUnits() {
        return 2147483647;
    }

    @Override
    public void onUse(PlayerEntity user) {
        user.incrementStat(Stats.USED.getOrCreateStat(this));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.fentanyl.skull"));

        super.appendTooltip(stack, world, tooltip, context);
    }
}
