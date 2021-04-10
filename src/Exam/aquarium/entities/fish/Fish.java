package Exam.aquarium.entities.fish;

import aquarium.entities.aquariums.Aquarium;

public interface Fish {
    void setName(String name);

    void eat();

    int getSize();

    String getName();

    double getPrice();
}
