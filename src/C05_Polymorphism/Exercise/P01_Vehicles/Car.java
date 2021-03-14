package C05_Polymorphism.Exercise.P01_Vehicles;

public class Car extends Vehicle {
    private static final double SUMMER_CONSUMPTION = 0.9;

    protected Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + SUMMER_CONSUMPTION);
    }
}
