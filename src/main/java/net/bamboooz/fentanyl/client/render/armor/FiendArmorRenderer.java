package net.bamboooz.fentanyl.client.render.armor;

import net.bamboooz.fentanyl.client.model.armor.FiendArmorModel;
import net.bamboooz.fentanyl.server.item.armor.FiendArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class FiendArmorRenderer extends GeoArmorRenderer<FiendArmorItem> {
    public FiendArmorRenderer() {
        super(new FiendArmorModel());
    }
}
