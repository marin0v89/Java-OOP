package C07_Reflection.Exercise.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Constructor<BlackBoxInt> ctor = BlackBoxInt.class.getDeclaredConstructor();
        ctor.setAccessible(true);
        BlackBoxInt blackBoxInt = ctor.newInstance();

        Method[] methods = blackBoxInt.getClass().getDeclaredMethods();
        Field innerValue = blackBoxInt.getClass().getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        while (!"END".equals(input)) {
            String[] tokens = input.split("_");
            String command = tokens[0];
            int number = Integer.parseInt(tokens[1]);

            Method method = methods.getClass().getDeclaredMethod(command, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, number);

            System.out.println(innerValue.getInt(blackBoxInt));

            input = scan.nextLine();

        }
    }
}
