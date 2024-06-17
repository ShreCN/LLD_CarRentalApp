package lld.design.zoomcar.strategies;

public class DailyPricingStrategy implements PricingStrategy{

    @Override
    public double pricing(double noOfDays) {
        return noOfDays * 100;
    }
}
