package lld.design.zoomcar.strategies;

import jakarta.persistence.Embeddable;

@Embeddable
public interface PricingStrategy {

    public double pricing(double price);
}
