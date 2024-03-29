package P10_ExamPreparation.Bakery.core;

import P10_ExamPreparation.Bakery.common.ExceptionMessages;
import P10_ExamPreparation.Bakery.common.OutputMessages;
import P10_ExamPreparation.Bakery.common.enums.BakedFoodType;
import P10_ExamPreparation.Bakery.common.enums.DrinkType;
import P10_ExamPreparation.Bakery.common.enums.TableTYpe;
import P10_ExamPreparation.Bakery.core.interfaces.Controller;
import P10_ExamPreparation.Bakery.entities.bakedFoods.Bread;
import P10_ExamPreparation.Bakery.entities.bakedFoods.Cake;
import P10_ExamPreparation.Bakery.entities.bakedFoods.interfaces.BakedFood;
import P10_ExamPreparation.Bakery.entities.drinks.Tea;
import P10_ExamPreparation.Bakery.entities.drinks.Water;
import P10_ExamPreparation.Bakery.entities.drinks.interfaces.Drink;
import P10_ExamPreparation.Bakery.entities.tables.InsideTable;
import P10_ExamPreparation.Bakery.entities.tables.OutsideTable;
import P10_ExamPreparation.Bakery.entities.tables.interfaces.Table;
import P10_ExamPreparation.Bakery.repositories.interfaces.DrinkRepository;
import P10_ExamPreparation.Bakery.repositories.interfaces.FoodRepository;
import P10_ExamPreparation.Bakery.repositories.interfaces.TableRepository;

public class ControllerImpl implements Controller {


    private FoodRepository<BakedFood> foodRepository;
    private DrinkRepository<Drink> drinkRepository;
    private TableRepository<Table> tableRepository;
    private double totalIncome;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {

        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
        this.totalIncome = 0.0;
    }


    @Override
    public String addFood(String type, String name, double price) {
        BakedFood bakedFood = this.foodRepository.getByName(name);
        if (bakedFood != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
        }
        BakedFoodType bakedFoodType = BakedFoodType.valueOf(type);
        if (bakedFoodType.equals(BakedFoodType.Bread)) {
            bakedFood = new Bread(name, price);

        } else if (bakedFoodType.equals(BakedFoodType.Cake)) {
            bakedFood = new Cake(name, price);
        }
        this.foodRepository.add(bakedFood);

        return String.format(OutputMessages.FOOD_ADDED, name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        Drink drink = this.drinkRepository.getByNameAndBrand(name, brand);
        if (drink != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
        }
        DrinkType drinkType = DrinkType.valueOf(type);

        if (drinkType.equals(DrinkType.Tea)) {
            drink = new Tea(name, portion, brand);
        } else if (drinkType.equals(DrinkType.Water)) {
            drink = new Water(name, portion, brand);
        }
        this.drinkRepository.add(drink);
        return String.format(OutputMessages.DRINK_ADDED, name, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = this.tableRepository.getByNumber(tableNumber);
        if (table != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_EXIST, tableNumber));
        }
        TableTYpe tableType = TableTYpe.valueOf(type);
        if (tableType.equals(TableTYpe.InsideTable)) {
            table = new InsideTable(tableNumber, capacity);
        } else if (tableType.equals(TableTYpe.OutsideTable)) {
            table = new OutsideTable(tableNumber, capacity);
        }
        this.tableRepository.add(table);
        return String.format(OutputMessages.TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        for (Table table : this.tableRepository.getAll()) {
            if (!table.isReserved() && table.getCapacity() >= numberOfPeople) {
                table.reserve(numberOfPeople);
                return String.format(OutputMessages.TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
            }
        }
        return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        Table table = this.tableRepository.getByNumber(tableNumber);
        if (table == null || !table.isReserved()) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }
        BakedFood bakedFood = this.foodRepository.getByName(foodName);
        if (bakedFood == null) {
            return String.format(OutputMessages.NONE_EXISTENT_FOOD, foodName);
        }
        table.orderFood(bakedFood);
        return String.format(OutputMessages.FOOD_ORDER_SUCCESSFUL, tableNumber, foodName);
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        Table table = this.tableRepository.getByNumber(tableNumber);
        if (table == null || !table.isReserved()) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }
        Drink drink = this.drinkRepository.getByNameAndBrand(drinkName, drinkBrand);
        if (drink == null) {
            return String.format(OutputMessages.NON_EXISTENT_DRINK, drinkName, drinkBrand);
        }
        table.orderDrink(drink);
        return String.format(OutputMessages.DRINK_ORDER_SUCCESSFUL, tableNumber, drinkName, drinkBrand);

    }

    @Override
    public String leaveTable(int tableNumber) {
        Table table = this.tableRepository.getByNumber(tableNumber);
        double bill = table.getBill();
        this.totalIncome += bill;
        table.clear();
        return String.format(OutputMessages.BILL, tableNumber, bill);
    }

    @Override
    public String getFreeTablesInfo() {
        StringBuilder sb = new StringBuilder();
        for (Table table : this.tableRepository.getAll()) {
            if (!table.isReserved()) {
                sb
                        .append(table.getFreeTableInfo())
                        .append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String getTotalIncome() {
        return String.format(OutputMessages.TOTAL_INCOME, this.totalIncome);
    }
}
