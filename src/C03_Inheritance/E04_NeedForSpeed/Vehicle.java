package C03_Inheritance.E04_NeedForSpeed;

public class Vehicle {
    private final static double DEFAULT_FUEL_CONSUMPTION = 1.25;
    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public double getFuel() {
        return fuel;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void drive(double kilometers) {
        double lKm = kilometers * this.fuelConsumption;
        if (lKm <= fuel) {
            this.fuel -= lKm;
        }
    }
}
