package net.bamboooz.fentanyl.server.item.drug;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.stat.Stats;

public class Tar extends AbstractDrug {
    public Tar(Settings settings) {
        super(settings);
    }

    @Override
    public int fentanylUnits() {
        return 600;
    }

    @Override
    public void onUse(PlayerEntity user) {
        user.incrementStat(Stats.USED.getOrCreateStat(this));
    }
}
