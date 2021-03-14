package C05_Polymorphism.Exercise.P02_VehicleExtension;

public class Truck extends Vehicle {
    private static final double SUMMER_CONSUMPTION = 1.6;
    private static final double TANK_PROBLEM = 0.95;

    protected Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + SUMMER_CONSUMPTION, tankCapacity);
    }

    @Override
    protected void refuel(double fuel) {
        super.refuel(fuel * TANK_PROBLEM);
    }
}
