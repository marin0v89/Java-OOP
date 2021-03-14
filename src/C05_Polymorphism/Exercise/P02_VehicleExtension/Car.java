package C05_Polymorphism.Exercise.P02_VehicleExtension;

public class Car extends Vehicle{
    private static final double SUMMER_CONSUMPTION = 0.9;

    protected Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption+SUMMER_CONSUMPTION, tankCapacity);
    }
}
