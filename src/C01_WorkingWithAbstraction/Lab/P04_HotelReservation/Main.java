package C01_WorkingWithAbstraction.Lab.P04_HotelReservation;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        runHoliday(scan);

    }

    private static void runHoliday(Scanner scan) {
        String[] tokens = scan.nextLine().split("\\s+");
        PriceCalculator calculator = createCalculator(tokens);
        System.out.printf("%.2f%n", calculator.calculate());
    }

    private static PriceCalculator createCalculator(String[] tokens) {
        double price = Double.parseDouble(tokens[0]);
        int multiplayer = Integer.parseInt(tokens[1]);
        Season seasonType = Season.valueOf(tokens[2].toUpperCase());
        DiscountType discountType = DiscountType.valueOf(tokens[3].toUpperCase());

        return new PriceCalculator(price, multiplayer, discountType, seasonType);
    }
}
