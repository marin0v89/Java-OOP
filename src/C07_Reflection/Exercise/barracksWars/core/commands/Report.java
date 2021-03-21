package C07_Reflection.Exercise.barracksWars.core.commands;

import C07_Reflection.Exercise.barracksWars.interfaces.Repository;
import C07_Reflection.Exercise.barracksWars.interfaces.UnitFactory;

public class Report extends Command {

    public Report(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return getRepository().getStatistics();

    }
}
