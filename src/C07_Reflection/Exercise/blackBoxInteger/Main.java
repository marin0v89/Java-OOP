package C07_Reflection.Exercise.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Constructor<BlackBoxInt> ctor = BlackBoxInt.class.getDeclaredConstructor();
        ctor.setAccessible(true);
        BlackBoxInt blackBoxInt = ctor.newInstance();


        while (!"END".equals(input)) {

            input = scan.nextLine();

        }
    }
}
