package C04_InterfacesAndAbstraction.Exercise.P05_Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            boolean valid = true;
            for (char c : number.toCharArray()) {
                if (!Character.isDigit(c)) {
                    sb.append("Invalid number!").append(System.lineSeparator());
                    valid = false;
                    break;
                }
            }
            if (valid) {
                sb.append("Calling... ").append(number).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            boolean valid = true;
            for (char u : url.toCharArray()) {
                if (Character.isDigit(u)) {
                    sb.append("Invalid URL!").append(System.lineSeparator());
                    valid = false;
                    break;
                }
            }
            if (valid) {
                sb.append("Browsing: ").append(url).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();

    }
}
