package P10_ExamPreparation.Bakery.entities.bakedFoods;

public class Bread extends BaseFood {
    private static final double BREAD_PORTION = 200;

    public Bread(String name, double price) {
        super(name, BREAD_PORTION, price);
    }
}
