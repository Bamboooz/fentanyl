package net.bamboooz.fentanyl.item.client;

import net.bamboooz.fentanyl.item.armor.FiendArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class FiendArmorRenderer extends GeoArmorRenderer<FiendArmorItem> {
    public FiendArmorRenderer() {
        super(new FiendArmorModel());
    }
}
