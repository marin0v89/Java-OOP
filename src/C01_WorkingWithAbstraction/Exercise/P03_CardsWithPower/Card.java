package C01_WorkingWithAbstraction.Exercise.P03_CardsWithPower;


public class Card {
    private RankPower rank;
    private CardSuit suit;
    private int power;

    public Card(RankPower rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
        calculatePower();
    }

    private void calculatePower() {
        this.power = rank.getPower() + suit.getSuitPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", this.rank, this.suit, this.power);
    }
}
