package C05_Polymorphism.Exercise.P02_VehicleExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        setFuelConsumption(fuelConsumption);
        setTankCapacity(tankCapacity);
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void drive(double kilometers) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        if (this.fuelQuantity < this.fuelConsumption * kilometers) {
            System.out.println(String.format("%s needs refueling", getClass().getSimpleName()));
        } else {
            this.fuelQuantity -= this.fuelConsumption * kilometers;
            System.out.println(String.format("%s travelled %s km",
                    getClass().getSimpleName(), decimalFormat.format(kilometers)));
        }
    }

    protected void refuel(double fuel) {
        if (fuel <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (this.fuelQuantity + fuel > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += fuel;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), getFuelQuantity());
    }
}
