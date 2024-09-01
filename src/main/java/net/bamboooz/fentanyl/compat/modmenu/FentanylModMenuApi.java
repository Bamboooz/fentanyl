package net.bamboooz.fentanyl.compat.modmenu;

import com.simibubi.create.foundation.config.ui.BaseConfigScreen;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.bamboooz.fentanyl.Fentanyl;

public class FentanylModMenuApi implements ModMenuApi {
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return (screen) -> new BaseConfigScreen(screen, Fentanyl.MOD_ID);
    }
}
