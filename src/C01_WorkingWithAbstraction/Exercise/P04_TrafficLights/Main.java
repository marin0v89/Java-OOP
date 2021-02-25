package C01_WorkingWithAbstraction.Exercise.P04_TrafficLights;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] tokens = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(scan.nextLine());

        List<TrafficLight> trafficLights = new LinkedList<>();

        for (String token : tokens) {
            TrafficLight trafficLight = new TrafficLight(TrafficLightState.valueOf(token));
            trafficLights.add(trafficLight);
        }
        for (int i = 0; i < n; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.update();
                System.out.print(trafficLight+" ");
            }
            System.out.println();
        }

    }
}
