package P10_ExamPreparation.Bakery.repositories;

import P10_ExamPreparation.Bakery.entities.bakedFoods.BaseFood;
import P10_ExamPreparation.Bakery.entities.drinks.interfaces.Drink;
import P10_ExamPreparation.Bakery.repositories.interfaces.DrinkRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DrinkRepositoryImpl implements DrinkRepository<Drink> {
    private Collection<Drink> models;

    public DrinkRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        for (Drink model : models) {
            if (model.getName().equals(drinkName)
                    && model.getBrand().equals(drinkBrand)) {
                return model;
            }
        }
        return null;
    }

    @Override
    public Collection<Drink> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Drink drink) {
        this.models.add(drink);
    }
}
