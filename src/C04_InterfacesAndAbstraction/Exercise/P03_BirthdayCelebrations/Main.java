package C04_InterfacesAndAbstraction.Exercise.P03_BirthdayCelebrations;

import C04_InterfacesAndAbstraction.Exercise.P02_MultipleImplementation.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Birthable> birthList = new ArrayList<>();

        String input = scan.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");

            String infoType = tokens[0];

            switch (infoType) {
                case "Citizen":
                    String name = tokens[1];
                    int age = Integer.parseInt(tokens[2]);
                    String id = tokens[3];
                    String birthDate = tokens[4];
                    Citizen citizen = new Citizen(name, age, id, birthDate);
                    birthList.add(citizen);
                    break;
                case "Robot":
                    id = tokens[1];
                    String model = tokens[2];
                    Robot robot = new Robot(model, id);
                    break;
                case "Pet":
                    name = tokens[1];
                    birthDate = tokens[2];
                    Pet pet = new Pet(name, birthDate);
                    birthList.add(pet);
                    break;
            }

            input = scan.nextLine();
        }
        String endsWith = scan.nextLine();

        birthList.forEach(b->{
            if (b.getBirthDate().endsWith(endsWith)){
                System.out.println(b.getBirthDate());
            }else {
                System.out.println("<no output>");
            }
        });
    }
}
