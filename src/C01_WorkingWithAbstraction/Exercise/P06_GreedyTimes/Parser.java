package C01_WorkingWithAbstraction.Exercise.P06_GreedyTimes;

public class Parser {
    private final ConsoleReader reader;

    public Parser(ConsoleReader reader){
        this.reader = reader;
    }
    public long parseLong(ConsoleReader reader){
        return Long.parseLong(reader.readLine());
    }
    public String[]split(ConsoleReader reader){
        return reader.readLine().split("\\s+");
    }

}
