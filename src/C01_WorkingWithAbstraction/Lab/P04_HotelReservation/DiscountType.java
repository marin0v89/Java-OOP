package C01_WorkingWithAbstraction.Lab.P04_HotelReservation;

public enum DiscountType {
    VIP(20),
    SECONDVISIT(10),
    NONE(0);

    private int percentage;

    DiscountType(int percentage){
        this.percentage=percentage;
    }

    public int getPercentage() {
        return percentage;
    }
}
