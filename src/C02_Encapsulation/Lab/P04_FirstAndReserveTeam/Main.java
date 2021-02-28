package C02_Encapsulation.Lab.P04_FirstAndReserveTeam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Team team = new Team("Black Eagles");

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            Person person = new Person(tokens[0], tokens[1], Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3]));

            team.addPlayer(person);
        }
        System.out.println(("First team have " + team.getFirstTeam().size()) + " players");
        System.out.println("Reserve team have " + team.getReserveTeam().size() + " players");
    }
}
