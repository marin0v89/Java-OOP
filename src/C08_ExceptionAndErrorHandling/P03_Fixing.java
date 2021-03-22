package C08_ExceptionAndErrorHandling;

import java.util.Scanner;

public class P03_Fixing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] weekdays = new String[]
                {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        try {
            for (String weekday : weekdays) {
                System.out.println(weekday);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        scan.nextLine();
    }
}
