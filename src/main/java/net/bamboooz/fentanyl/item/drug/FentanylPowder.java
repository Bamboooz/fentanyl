package net.bamboooz.fentanyl.item.drug;

public class FentanylPowder extends AbstractDrug {
    public FentanylPowder(Settings settings) {
        super(settings);
    }

    @Override
    public int fentanylUnits() {
        return 24000;
    }
}
