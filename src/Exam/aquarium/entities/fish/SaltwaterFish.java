package Exam.aquarium.entities.fish;

public class SaltwaterFish extends BaseFish{
    private int size;
    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
        int size = 5;
    }

    @Override
    public int getSize() {
        return size +=2;
    }
}
