package C02_Encapsulation.Exercise.P01_ClassBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double l = Double.parseDouble(scan.nextLine());
        double w = Double.parseDouble(scan.nextLine());
        double h = Double.parseDouble(scan.nextLine());

        try {
            Box box = new Box(l ,w ,h);
            System.out.println(String.format("Surface Area - %.2f", box.calculateSurfaceArea()));
            System.out.println(String.format("Lateral Surface Area - %.2f", box.calculateLateralSurfaceArea()));
            System.out.println(String.format("Volume - %.2f", box.calculateVolume()));
        }catch (IllegalArgumentException iea){
            System.out.println(iea.getMessage());
        }
    }
}
