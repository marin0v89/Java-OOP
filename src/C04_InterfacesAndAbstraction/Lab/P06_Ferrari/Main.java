package C04_InterfacesAndAbstraction.Lab.P06_Ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();

        Ferrari ferrari = new Ferrari(name);

        System.out.println(ferrari);
    }
}
