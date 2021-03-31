package P09_DesignPatterns.Lab.P01_Singleton;

public class SingletonContainer {
    private SingletonContainer() {

    }

    private static PopulationTracker tracker;
    private static boolean isInit;

    public static PopulationTracker getTracker() {
        if (!isInit) {
            throw new IllegalStateException(
                    "SingletonContainer not initialized call.init() first");
        }
        return tracker;
    }

    public static void init() {
        if (!isInit) {
            isInit = true;
            tracker = PopulationTracker.getInstance();
        }
    }
}

