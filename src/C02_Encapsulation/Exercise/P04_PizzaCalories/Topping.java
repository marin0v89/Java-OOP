package C02_Encapsulation.Exercise.P04_PizzaCalories;

import java.util.Map;

public class Topping {

    private static final Map<String, Double> TOPPING_MODS
            = Map.of("Meat", 1.2, "Veggies", 0.8, "Cheese", 1.1, "Sauce", 0.9);
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (!TOPPING_MODS.containsKey(toppingType)) {
            throw new IllegalArgumentException
                    (String.format("Cannot place %s on top of your pizza.", this.toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 0 || weight > 50) {
            throw new IllegalArgumentException
                    (String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return 2 * this.weight * TOPPING_MODS.get(toppingType);
    }
}
