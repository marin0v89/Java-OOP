package C01_WorkingWithAbstraction.Exercise.P03_CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String cardRank = scan.nextLine();
        String cardSuit = scan.nextLine();

        Card card = new Card(RankPower.valueOf(cardRank), CardSuit.valueOf(cardSuit));
        System.out.println(card);
    }
}
