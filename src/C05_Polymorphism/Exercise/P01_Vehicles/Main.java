package C05_Polymorphism.Exercise.P01_Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] carInfo = scan.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carInfo[1]),
                Double.parseDouble(carInfo[2]));

        String[] truckInfo = scan.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]),
                Double.parseDouble(truckInfo[2]));

        int n = Integer.parseInt(scan.nextLine());

        while (n-- > 0) {
            String[] input = scan.nextLine().split("\\s+");
            String command = input[0];
            String vehicle = input[1];
            double amount = Double.parseDouble(input[2]);

            switch (command) {
                case "Drive":
                    if (vehicle.equals("Car")) {
                        car.drive(amount);
                    } else {
                        truck.drive(amount);
                    }
                    break;
                case "Refuel":
                    if (vehicle.equals("Car")) {
                        car.refuel(amount);
                    } else {
                        truck.refuel(amount);
                    }
            }
        }
        System.out.println(car);
        System.out.println(truck);
    }
}
