package C04_InterfacesAndAbstraction.Exercise.P05_Telephony;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        List<String> numbers = fillTheList(scan);
        List<String> urls = fillTheList(scan);

        Smartphone smartphone = new Smartphone(numbers, urls);


        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }

    private static List<String> fillTheList(Scanner scan) {
        List<String> list = new ArrayList<>();
        String[] tokens = scan.nextLine().split("\\s+");

        Collections.addAll(list, tokens);
        return list;
    }
}

