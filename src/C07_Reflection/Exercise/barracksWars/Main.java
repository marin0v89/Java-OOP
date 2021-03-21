package C07_Reflection.Exercise.barracksWars;

import C07_Reflection.Exercise.barracksWars.core.Engine;
import C07_Reflection.Exercise.barracksWars.core.factories.UnitFactoryImpl;
import C07_Reflection.Exercise.barracksWars.data.UnitRepository;
import C07_Reflection.Exercise.barracksWars.interfaces.Repository;
import C07_Reflection.Exercise.barracksWars.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
