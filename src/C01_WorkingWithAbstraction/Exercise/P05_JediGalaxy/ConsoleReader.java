package C01_WorkingWithAbstraction.Exercise.P05_JediGalaxy;

import java.util.Scanner;

public class ConsoleReader {

    private Scanner scanner;

    public ConsoleReader() {
        this.scanner = new Scanner(System.in);
    }

    public String readLine() {
        return this.scanner.nextLine();
    }
}
