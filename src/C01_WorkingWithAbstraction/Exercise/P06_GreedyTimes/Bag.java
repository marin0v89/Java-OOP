package C01_WorkingWithAbstraction.Exercise.P06_GreedyTimes;

import java.util.*;

public class Bag {
    private long capacity;
    private static long currentSum;
    private static long currentGold;
    private static long currentGems;
    private static long currentCash;
    private static LinkedHashMap<String, Map<String, Long>> bagStorage;

    public Bag(long capacity) {
        this.capacity = capacity;
        bagStorage = new LinkedHashMap<>();
        bagStorage.put("Gold", new HashMap<>());
        bagStorage.put("Gem", new HashMap<>());
        bagStorage.put("Cash", new HashMap<>());
    }

    private static void calculateSum() {
        currentSum = getSum();
        currentGold = sum("Gold");
        currentGold = sum("Gem");
        currentGold = sum("Cash");
    }

    private static long getSum() {
        return bagStorage.values()
                .stream()
                .map(Map::values)
                .flatMap(Collection::stream)
                .mapToLong(e -> e).sum();
    }

    private static long sum(String itemType) {
        return bagStorage.get(itemType)
                .values()
                .stream()
                .mapToLong(e -> e).sum();
    }

    public void putElements(String name, long amount) {
        calculateSum();
        if (name.length() == 3) {
            if ((amount + currentCash) <= currentGems && currentSum + amount <= this.capacity) {
                bagStorage.get("Cash").putIfAbsent(name, 0L);
                putItem(name, amount, "Cash");
            }

        } else if (name.toLowerCase().endsWith("gem")) {
            if (currentGold >= currentGems + amount && currentSum + amount <= this.capacity) {
                bagStorage.get("Gem").putIfAbsent(name, 0L);
                putItem(name, amount, "Gem");
            }
        } else if (name.equalsIgnoreCase("gold")) {
            if (currentSum + amount < this.capacity) {
                bagStorage.get("Gold").putIfAbsent("Gold", 0L);
                putItem("Gold", amount, "Gold");
            }
        }
    }

    private static void putItem(String name, long amount, String type) {
        long newAmount = bagStorage.get(type).get(name) + amount;
        bagStorage.get(type).put(name, newAmount);
    }

    public static void printBag() {
        for (var entry : bagStorage.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                Long sum =
                        entry
                                .getValue()
                                .values()
                                .stream()
                                .mapToLong(e -> e).sum();

                System.out.printf("<%s> $%s%n", entry.getKey(), sum);

                entry
                        .getValue ()
                        .entrySet ()
                        .stream ()
                        .sorted ((e1, e2) -> e2.getKey ().compareTo (e1.getKey ()))
                        .forEach (t -> System.out.printf ("##%s - %d%n", t.getKey (), t.getValue ()));
            }
        }
    }
}
