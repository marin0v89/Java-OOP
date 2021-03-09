package C04_InterfacesAndAbstraction.Lab.P05_BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        List<Citizen> citizenList = new ArrayList<>();
        List<Robot> robotList = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            if (tokens.length == 3) {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];
                Citizen citizen = new Citizen(name, age, id);
                citizenList.add(citizen);
            } else if (tokens.length == 2) {
                String model = tokens[0];
                String id = tokens[1];
                Robot robot = new Robot(model, id);
                robotList.add(robot);
            }

            input = scan.nextLine();
        }
        String idCheck = scan.nextLine();

        for (Citizen citizen : citizenList) {
            if (citizen.getId().endsWith(idCheck)) {
                System.out.println(citizen.getId());
            }
        }
        robotList.forEach(r -> {
            if (r.getId().endsWith(idCheck)) {
                System.out.println(r.getId());
            }
        });
    }
}
