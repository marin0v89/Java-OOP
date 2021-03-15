package C05_Polymorphism.Exercise.P03_WildFarm;

import java.text.DecimalFormat;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private String livingRegion;
    private Integer foodEaten;

    public Animal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.livingRegion = livingRegion;
        foodEaten = 0;

    }

    public String getLivingRegion() {
        return livingRegion;
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void makeSound() {

    }

    public void eatFood(Food food) {
        foodEaten += food.getQuantity();
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("##.##");

        return String.format("%s[%s, %s, %s, %d]",
                getAnimalType(), getAnimalName(),
                format.format(getAnimalWeight()), getLivingRegion(), getFoodEaten());
    }
}
