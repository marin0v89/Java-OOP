package C04_InterfacesAndAbstraction.Exercise.P04_FoodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, Buyer> buyer = new HashMap<>();

        while (n-- < 0) {
            String[] tokens = scan.nextLine().split("\\s+");

            if (tokens.length == 4) {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];
                String birthDate = tokens[3];
                Citizen citizen = new Citizen(name, age, id, birthDate);
                buyer.put(name, citizen);

            } else if (tokens.length == 3) {

                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String group = tokens[2];
                Rebel rebel = new Rebel(name, age, group);
                buyer.put(name, rebel);
            }
        }

        String shoppers = scan.nextLine();

        int food = 0;

        while (!"End".equals(shoppers)) {
            if (buyer.containsKey(shoppers)) {
                food += buyer.get(shoppers).getFood();
            }

            shoppers = scan.nextLine();
        }
        System.out.println(food);
    }
}
