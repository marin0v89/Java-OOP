package C01_WorkingWithAbstraction.Exercise.P01_CardSuit;

public class Main {
    public static void main(String[] args) {
        CardSuit[] cardSuits = CardSuit.values();
        System.out.println("Card Suits:");
        for (CardSuit cardSuit : cardSuits) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s",cardSuit.ordinal(),cardSuit.name()));
        }
    }
}
