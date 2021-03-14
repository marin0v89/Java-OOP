package C05_Polymorphism.Exercise.P02_VehicleExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] carInfo = scan.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carInfo[1]),
                Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3]));

        String[] truckInfo = scan.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]),
                Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3]));

        String[] busInfo = scan.nextLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(busInfo[1]),
                Double.parseDouble(busInfo[2]), Double.parseDouble(busInfo[3]));

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);

        int n = Integer.parseInt(scan.nextLine());

        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            String command = tokens[0];
            String vehicle = tokens[1];
            double liters = Double.parseDouble(tokens[2]);

            switch (command) {
                case "Drive":
                    vehicles.get(vehicle).drive(liters);
                    break;

                case "Refuel":
                    try {
                        vehicles.get(vehicle).refuel(liters);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "DriveEmpty":
                    bus.setEmpty(false);
                    bus.drive(liters);
                    break;
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
