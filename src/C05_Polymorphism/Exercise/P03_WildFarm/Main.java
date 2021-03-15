package C05_Polymorphism.Exercise.P03_WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String input = scan.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            Animal animal = animalConstructor(tokens);

            String[] foodGiven = scan.next().split("\\s+");

            Food food = null;

            String foodName = foodGiven[0];
            Integer foodWeight = Integer.parseInt(foodGiven[1]);

            if (foodName.equals("Meat")) {
                food = new Meat(foodWeight);
            } else if (foodName.equals("Vegetable")) {
                food = new Vegetable(foodWeight);
            }

            animal.makeSound();

            try {
                assert food != null;
                animal.eatFood(food);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            animals.add(animal);
            input = scan.nextLine();
        }
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    private static Animal animalConstructor(String[] tokens) {
        String animalType = tokens[0];
        String animalName = tokens[1];
        Double animalWeight = Double.parseDouble(tokens[2]);
        String livingRegion = tokens[3];
        Animal animal;

        switch (animalType) {
            case "Cat" -> {
                String catBreed = tokens[4];
                animal = new Cat(animalName, animalType, animalWeight, livingRegion, catBreed);
            }
            case "Tiger" -> animal = new Tiger(animalName, animalType, animalWeight, livingRegion);
            case "Zebra" -> animal = new Zebra(animalName, animalType, animalWeight, livingRegion);
            case "Mouse" -> animal = new Mouse(animalName, animalType, animalWeight, livingRegion);
            default -> throw new IllegalStateException("Unexpected value: " + animalType);
        }
        return animal;
    }
}
