package C05_Polymorphism.Lab.P01_MathOperation;

public class MathOperation {
    public static int add(int first, int second) {
        return first + second;
    }

    public static int add(int first, int second, int third) {
        return add(add(first, second), third);
    }

    public static int add(int first, int second, int third, int fourth) {
        return add(add(first, second, third), fourth);
    }
}
