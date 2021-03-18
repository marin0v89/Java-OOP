package C07_Reflection.Lab;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class P03_HighQualityMistakes {

    public static class ComparingMethod implements Comparator<Method> {

        @Override
        public int compare(Method first, Method second) {
            return first.getName().compareTo(second.getName());
        }
    }

    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;

        Method[] declaredMethods = clazz.getDeclaredMethods();

        Set<Method> getters = new TreeSet<>(new ComparingMethod());
        Set<Method> setters = new TreeSet<>(new ComparingMethod());

        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getName().contains("get")) {
                getters.add(declaredMethod);
            } else if (declaredMethod.getName().contains("set")) {
                setters.add(declaredMethod);
            }
        }
        Arrays.stream(clazz.getDeclaredFields())
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f -> System.out.println(f.getName() + " must be private!"));

        for (Method getter : getters) {
            if (!Modifier.isPublic(getter.getModifiers())) {
                System.out.println(getter.getName() + " have to be public!");
            }
        }
        for (Method setter : setters) {
            if (!Modifier.isPrivate(setter.getModifiers())) {
                System.out.println(setter.getName() + " have to be private!");
            }
        }
    }
}
