package C08_ExceptionAndErrorHandling;

import java.util.Scanner;

public class P01_SquareRoot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            double n = Integer.parseInt(scan.nextLine());
            System.out.println(Math.sqrt(n));
        } catch (NumberFormatException e) {
            System.out.println("Invalid number");
        } finally {
            System.out.println("Good bye");
        }
    }
}
