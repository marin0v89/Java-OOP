package C02_Encapsulation.Exercise.P04_PizzaCalories;

import java.util.Map;

public class Dough {

    private static final Map<String, Double> FLOUR_TYPE
            = Map.of("White", 1.5, "Wholegrain", 1.0);
    private static final Map<String, Double> BAKING_TYPE
            = Map.of("Wholegrain", 0.9, "Chewy", 1.1, "Homemade", 1.0);
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight < 0 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private void setFlourType(String flourType) {
        if (!FLOUR_TYPE.containsKey(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!BAKING_TYPE.containsKey(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public double calculateCalories() {
        return 2 * this.FLOUR_TYPE.get(this.flourType) * this.BAKING_TYPE.get(this.bakingTechnique);
    }

}
