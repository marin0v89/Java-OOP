package C03_Inheritance.E04_NeedForSpeed;

public class RaceMotorcycle extends Motorcycle {
    public RaceMotorcycle(double fuel, int horsepower) {
        super(fuel, horsepower);
        super.setFuelConsumption(8);
    }

}
