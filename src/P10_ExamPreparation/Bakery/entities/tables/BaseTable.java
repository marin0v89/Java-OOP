package P10_ExamPreparation.Bakery.entities.tables;

import P10_ExamPreparation.Bakery.common.ExceptionMessages;
import P10_ExamPreparation.Bakery.entities.bakedFoods.interfaces.BakedFood;
import P10_ExamPreparation.Bakery.entities.drinks.interfaces.Drink;
import P10_ExamPreparation.Bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseTable implements Table {
    private Collection<BakedFood> foodOrders;
    private Collection<Drink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.tableNumber = tableNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
    }

    public void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getTableNumber() {
        return this.tableNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.setNumberOfPeople(numberOfPeople);
        this.price = numberOfPeople * this.getPricePerPerson();
        this.isReserved = true;
    }

    @Override
    public void orderFood(BakedFood food) {
        this.foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        this.drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        double bill = this.getPrice();
        bill += this.foodOrders.stream().mapToDouble(BakedFood::getPrice).sum();
        bill += this.drinkOrders.stream().mapToDouble(Drink::getPrice).sum();
        return bill;
    }

    @Override
    public void clear() {
        this.foodOrders.clear();
        this.drinkOrders.clear();
        this.price = 0;
        this.isReserved = false;
    }

    @Override
    public String getFreeTableInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Table: %s", this.tableNumber))
                .append(System.lineSeparator())
                .append(String.format("Type: %s", this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("Capacity: %d", this.capacity))
                .append(System.lineSeparator())
                .append(String.format("Price per Person: %.2f", this.pricePerPerson));

        return sb.toString().trim();
    }
}
