package C07_Reflection.Exercise.barracksWars.core.commands;

import C07_Reflection.Exercise.barracksWars.interfaces.Executable;
import C07_Reflection.Exercise.barracksWars.interfaces.Repository;
import C07_Reflection.Exercise.barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {
    private String [] data;
    private Repository repository;
    private UnitFactory unitFactory;

    protected Command(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    protected String[] getData() {
        return data;
    }

    protected Repository getRepository() {
        return repository;
    }

    protected UnitFactory getUnitFactory() {
        return unitFactory;
    }
}
