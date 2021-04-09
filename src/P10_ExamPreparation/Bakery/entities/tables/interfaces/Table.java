package P10_ExamPreparation.Bakery.entities.tables.interfaces;

import P10_ExamPreparation.Bakery.entities.bakedFoods.interfaces.BakedFood;
import P10_ExamPreparation.Bakery.entities.drinks.interfaces.Drink;

public interface Table {
    int getTableNumber();

    int getCapacity();

    int getNumberOfPeople();

    double getPricePerPerson();

    boolean isReserved();

    double getPrice();

    void reserve(int numberOfPeople);

    void orderFood(BakedFood food);

    void orderDrink(Drink drink);

    double getBill();

    void clear();

    String getFreeTableInfo();
}
