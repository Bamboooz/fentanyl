package net.bamboooz.fentanyl.item.drug;

public class Tar extends AbstractDrug{
    public Tar(Settings settings) {
        super(settings);
    }

    @Override
    public int fentanylUnits() {
        return 1200;
    }
}
