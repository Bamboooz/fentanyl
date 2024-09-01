package net.bamboooz.fentanyl.server.item.drug;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.stat.Stats;

public class FentanylPowder extends AbstractDrug {
    public FentanylPowder(Settings settings) {
        super(settings);
    }

    @Override
    public int fentanylUnits() {
        return 24000;
    }

    @Override
    public void onUse(PlayerEntity user) {
        user.incrementStat(Stats.USED.getOrCreateStat(this));
    }
}
