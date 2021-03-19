package C07_Reflection.Exercise.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Class<RichSoilLand> clazz = RichSoilLand.class;

        String modifier = scan.nextLine();
        while (!"HARVEST".equals(modifier)) {

            returnModifier(modifier, clazz);

            modifier = scan.nextLine();
        }
    }

    private static void returnModifier(String modifier, Class<RichSoilLand> clazz) {

        Field[] declaredFields = clazz.getDeclaredFields();
        switch (modifier) {
            case "private":
                returnFields(declaredFields, "private");
                break;
            case "protected":
                returnFields(declaredFields, "protected");
                break;
            case "public":
                returnFields(declaredFields, "public");
                break;
            case "all":
                for (Field all : declaredFields) {
                    System.out.println(String.format
                            ("%s %s %s", Modifier.toString(all.getModifiers()),
                                    all.getType().getSimpleName(), all.getName()));
                }
                break;
        }
    }

    private static void returnFields(Field[] declaredFields, String matcher) {
        for (Field f : declaredFields) {
            if (Modifier.toString(f.getModifiers()).equals(matcher)) {
                System.out.println(String.format
                        ("%s %s %s", Modifier.toString(f.getModifiers()),
                                f.getType().getSimpleName(), f.getName()));
            }
        }
    }
}
