package C03_Inheritance.E05_Restaurant;

import java.math.BigDecimal;

public class HotBeverage extends Beverage {

    public HotBeverage(String name, BigDecimal price, double milliliters) {
        super(name, price, milliliters);
    }
}