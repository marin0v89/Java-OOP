package C03_Inheritance.E06_Animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        List<Animal> animals = new ArrayList<>();
        while (!"Beast!".equals(input)) {


            String[] tokens = scan.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String gender = tokens[2];

            try {
                switch (input) {
                    case "Dog" -> {
                        Dog dog = new Dog(name, age, gender);
                        animals.add(dog);
                    }
                    case "Cat" -> {
                        Cat cat = new Cat(name, age, gender);
                        animals.add(cat);
                    }
                    case "Frog" -> {
                        Frog frog = new Frog(name, age, gender);
                        animals.add(frog);
                    }
                    case "Kittens" -> {
                        Kittens kittens = new Kittens(name, age, gender);
                        animals.add(kittens);
                    }
                    case "Tomcat" -> {
                        Tomcat tomcat = new Tomcat(name, age, gender);
                        animals.add(tomcat);
                    }
                    default -> System.out.println("Invalid input!");
                }

            } catch (IllegalArgumentException ex) {
                System.out.println (ex.getMessage ());
            }
            input = scan.nextLine();
        }
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
