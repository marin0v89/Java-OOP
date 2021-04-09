package P10_ExamPreparation.Bakery.repositories;

import P10_ExamPreparation.Bakery.entities.tables.interfaces.Table;
import P10_ExamPreparation.Bakery.repositories.interfaces.TableRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TableRepositoryImpl implements TableRepository<Table> {
    private Collection<Table> models;

    public TableRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Table> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Table table) {
        this.models.add(table);
    }

    @Override
    public Table getByNumber(int number) {
        for (Table model : models) {
            if (model.getTableNumber() == number) {
                return model;
            }
        }
        return null;
        //return this.models.stream().filter(t -> t.getTableNumber() == number).findFirst().orElse(null);
    }
}
