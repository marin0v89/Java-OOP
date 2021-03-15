package C05_Polymorphism.Exercise.P03_WildFarm;

public class Mouse extends Mammal {
    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eatFood(Food food) {
        if (food instanceof Meat){
            throw new IllegalArgumentException
                    (String.format("%s are not eating that type of food!",getAnimalType()));
        }
        super.eatFood(food);
    }
}
