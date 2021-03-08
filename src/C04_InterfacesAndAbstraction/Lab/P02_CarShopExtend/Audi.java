package C04_InterfacesAndAbstraction.Lab.P02_CarShopExtend;

public class Audi extends CarImpl implements Rentable {
    private Integer minRentDay;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower,
                String countryProduced, Integer minRentDay, Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String toString() {
        String output = String.format("This is %s produced in %s and have %d tires",
                this.getModel(), this.countryProduced(), TIRES);
        return String.format("%s%nMinimum rental period of %d days. Price per day %f",
                output, this.getMinRentDay(), this.getPricePerDay());
    }
}
