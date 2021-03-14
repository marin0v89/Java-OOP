package C05_Polymorphism.Exercise.P01_Vehicles;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
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
        this.fuelQuantity += fuel;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), getFuelQuantity());
    }
}
