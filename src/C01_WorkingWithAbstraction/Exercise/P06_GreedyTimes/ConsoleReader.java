package C01_WorkingWithAbstraction.Exercise.P06_GreedyTimes;

import java.util.Scanner;

public class ConsoleReader {
    private final Scanner scan;

    public ConsoleReader(){
        this.scan = new Scanner(System.in);
    }

    public String readLine(){
        return this.scan.nextLine();
    }
}
