package C07_Reflection.Lab;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class P02_GettersAndSetters {

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

        System.out.println(getters.stream().map(get -> String.format("%s will return class %s",
                get.getName(), get.getReturnType().toString().replace("class ", "")))
                .collect(Collectors.joining(System.lineSeparator())));
        System.out.println(setters.stream().map(set -> String.format("%s and will set field of class %s",
                set.getName(), set.getParameterTypes()[0].toString().replace("class ", "")))
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
