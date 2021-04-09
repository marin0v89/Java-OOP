package P10_ExamPreparation.Bakery.io;


import P10_ExamPreparation.Bakery.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    public void writeLine(String text) {
        System.out.println(text);
    }
}
