package P10_ExamPreparation.Bakery.entities.drinks;

public class Tea extends BaseDrink {
    private final static double TEA_PRICE = 2.50;

    public Tea(String name, int portion, String brand) {
        super(name, portion, TEA_PRICE, brand);
    }
}
