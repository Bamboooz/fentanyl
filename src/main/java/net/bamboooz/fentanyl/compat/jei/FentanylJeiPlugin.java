package net.bamboooz.fentanyl.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import net.bamboooz.fentanyl.Fentanyl;
import net.minecraft.util.Identifier;

import javax.annotation.Nonnull;
import java.util.Objects;

@JeiPlugin
public class FentanylJeiPlugin implements IModPlugin {
    @Override
    @Nonnull
    public Identifier getPluginUid() {
        return Objects.requireNonNull(Identifier.of(Fentanyl.MOD_ID, "jei_plugin"));
    }
}
