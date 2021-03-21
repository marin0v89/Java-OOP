package C07_Reflection.Exercise.barracksWars.core.factories;

import C07_Reflection.Exercise.barracksWars.interfaces.Unit;
import C07_Reflection.Exercise.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        Unit unit = null;

        try {
            Class<?> clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
            unit = (Unit) clazz.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException
                | NoSuchMethodException
                | InstantiationException
                | IllegalAccessException
                | InvocationTargetException e) {
            e.printStackTrace();
        }

        return unit;
    }
}
