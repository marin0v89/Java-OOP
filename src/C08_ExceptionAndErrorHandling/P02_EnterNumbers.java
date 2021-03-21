package C08_ExceptionAndErrorHandling;

import com.sun.source.tree.IfTree;

import java.util.Scanner;

public class P02_EnterNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            printNumbers(scan);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printNumbers(Scanner scan) {
        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());
        //1 < start < end < 100
        if (start < 1 || end > 100) {
            throw new NumberFormatException("Invalid number");
        }
        System.out.println("First: " + start);
        System.out.println("Second: " + end);
    }
}
