package net.bamboooz.fentanyl.client.model.armor;

import net.bamboooz.fentanyl.Fentanyl;
import net.bamboooz.fentanyl.server.item.armor.FiendArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class FiendArmorModel extends GeoModel<FiendArmorItem> {
    @Override
    public Identifier getModelResource(FiendArmorItem animatable) {
        return Identifier.of(Fentanyl.MOD_ID, "geo/fiend_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(FiendArmorItem animatable) {
        return Identifier.of(Fentanyl.MOD_ID, "textures/armor/fiend_armor.png");
    }

    @Override
    public Identifier getAnimationResource(FiendArmorItem animatable) {
        return Identifier.of(Fentanyl.MOD_ID, "player_animation/fiend_armor.animation.json");
    }
}
