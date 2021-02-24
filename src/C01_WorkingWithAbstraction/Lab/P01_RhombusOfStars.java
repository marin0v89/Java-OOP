package C01_WorkingWithAbstraction.Lab;

import java.util.Scanner;

public class P01_RhombusOfStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        System.out.println(getTriangleOfStars(n, true));
        System.out.println(getTriangleOfStars(n, false));

    }

    public static String getTriangleOfStars(int n, boolean isUpwardsOriented) {
        StringBuilder sb = new StringBuilder();

        for (int r = 1; r <= n; r++) {
            int spacesCount = isUpwardsOriented ? n - r : r;
            int starsCount = isUpwardsOriented ? r : n - r;
            sb.append(repeatString(spacesCount, " "));
            sb.append(repeatString(starsCount, "* "));
            if (r != n) {
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public static String repeatString(int count, String toRepeat) {
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < count; i++) {
            out.append(toRepeat);
        }
        return out.toString();
    }

}
