package P09_DesignPatterns.Lab.P01_Singleton;

public class Main {
    public static void main(String[] args) {
        SingletonContainer.init();

        PopulationTracker tracker = SingletonContainer.getTracker();
        tracker.add("Sofia", 25);
        tracker.add("Dobrich", 69);

        readNewPopulationData();
        System.out.println();
    }

    private static void readNewPopulationData() {
        PopulationTracker tracker = SingletonContainer.getTracker();
        tracker.add("Sofia", 25);
        tracker.add("Dobrich", 69);
    }
}
