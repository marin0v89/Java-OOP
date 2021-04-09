package P10_ExamPreparation.Bakery;

import P10_ExamPreparation.Bakery.core.ControllerImpl;
import P10_ExamPreparation.Bakery.core.EngineImpl;
import P10_ExamPreparation.Bakery.core.interfaces.Controller;
import P10_ExamPreparation.Bakery.entities.bakedFoods.interfaces.BakedFood;
import P10_ExamPreparation.Bakery.entities.drinks.interfaces.Drink;
import P10_ExamPreparation.Bakery.entities.tables.interfaces.Table;

import P10_ExamPreparation.Bakery.io.ConsoleReader;
import P10_ExamPreparation.Bakery.io.ConsoleWriter;
import P10_ExamPreparation.Bakery.repositories.DrinkRepositoryImpl;
import P10_ExamPreparation.Bakery.repositories.FoodRepositoryImpl;
import P10_ExamPreparation.Bakery.repositories.TableRepositoryImpl;
import P10_ExamPreparation.Bakery.repositories.interfaces.*;

public class Main {
    public static void main(String[] args) {

        FoodRepository<BakedFood> foodRepository = new FoodRepositoryImpl();
        DrinkRepository<Drink> drinkRepository = new DrinkRepositoryImpl();
        TableRepository<Table> tableRepository = new TableRepositoryImpl();

        Controller controller = new ControllerImpl(foodRepository, drinkRepository, tableRepository);


        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
