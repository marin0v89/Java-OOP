package C05_Polymorphism.Exercise.P02_VehicleExtension;

public class Bus extends Vehicle {
    private static final double SUMMER_CONSUMPTION = 1.4;
    public boolean isEmpty = false;

    protected Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        if (isEmpty) {
            super.setFuelConsumption(fuelConsumption);
        } else {
            super.setFuelConsumption(fuelConsumption + SUMMER_CONSUMPTION);
        }
    }
}
