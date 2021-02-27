package C01_WorkingWithAbstraction.Exercise.P06_GreedyTimes;

public class Main {
    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();
        Parser parser = new Parser(reader);
        long input = parser.parseLong(reader);
        Bag bag = new Bag(input);

        String [] safe = parser.split(reader);

        for (int i = 0; i < safe.length; i+=2) {
            String name = safe[i];
            long amount = Long.parseLong(safe[i+1]);
            bag.putElements(name,amount);
        }
        Bag.printBag();
    }
}
