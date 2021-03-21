package C07_Reflection.Exercise.barracksWars.core.commands;


import C07_Reflection.Exercise.barracksWars.interfaces.Repository;
import C07_Reflection.Exercise.barracksWars.interfaces.Unit;
import C07_Reflection.Exercise.barracksWars.interfaces.UnitFactory;

public class Add extends Command {

    public Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        Unit unitToAdd = getUnitFactory().createUnit(unitType);
        getRepository().addUnit(unitToAdd);
        return unitType + " added!";
    }
}
