package C01_WorkingWithAbstraction.Lab.P03_StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentSystem studentSystem = new StudentSystem();

        String input = scanner.nextLine();

        while (!input.equals("Exit")) {
            String output = studentSystem.parseCommand(input.split("\\s+"));
            if (output != null) {
                System.out.println(output);
            }
            input = scanner.nextLine();
        }
    }
}
