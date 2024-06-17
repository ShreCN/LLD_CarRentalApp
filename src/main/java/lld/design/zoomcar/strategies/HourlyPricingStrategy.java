package lld.design.zoomcar.strategies;

public class HourlyPricingStrategy implements PricingStrategy{
    @Override
    public double pricing(double noOfHours) {
        return noOfHours * 10;
    }
}
