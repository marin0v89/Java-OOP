package C02_Encapsulation.Exercise.P04_PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] pizzaItems = scan.nextLine().split("\\s+");

        try {
            Pizza pizza = new Pizza(pizzaItems[1], Integer.parseInt(pizzaItems[2]));
            String[] doughItems = scan.nextLine().split("\\s+");
            Dough dough = new Dough(doughItems[1], doughItems[2], Double.parseDouble(doughItems[3]));
            pizza.setDough(dough);
            String input = scan.nextLine();
            while (!"END".equals(input)) {
                String[] toppingItems = input.split("\\s+");
                Topping topping = new Topping(toppingItems[1], Double.parseDouble(toppingItems[2]));
                pizza.addTopping(topping);
                input = scan.nextLine();
            }
            System.out.println(pizza.toString());

        } catch (IllegalArgumentException ieo) {
            System.out.println(ieo.getMessage());
        }
    }
}
