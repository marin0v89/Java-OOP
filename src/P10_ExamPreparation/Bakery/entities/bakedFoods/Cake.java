package P10_ExamPreparation.Bakery.entities.bakedFoods;

public class Cake extends BaseFood {
    private static final double CAKE_PORTION = 200;

    public Cake(String name, double price) {
        super(name, CAKE_PORTION, price);
    }
}
