package C07_Reflection.Lab;

import java.lang.reflect.InvocationTargetException;


public class P01_Reflection {
    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;
        Class<? super Reflection> superclass = clazz.getSuperclass();
        Class<?>[] interfaces = clazz.getInterfaces();

        System.out.println(clazz);
        System.out.println(superclass);
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        try {
            Object initiateObject = clazz.getDeclaredConstructor().newInstance();

            System.out.println(initiateObject);

        } catch (InstantiationException
                | IllegalAccessException
                | InvocationTargetException
                | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
