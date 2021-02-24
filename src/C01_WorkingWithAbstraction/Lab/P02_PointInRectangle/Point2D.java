package C01_WorkingWithAbstraction.Lab.P02_PointInRectangle;

public class Point2D {
    private int x;
    private int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isGreaterOrEqualByX(Point2D other) {
        return this.x >= other.x;
    }

    public boolean isWithEqualX(Point2D other) {
        return this.x == other.x;
    }

    public boolean isLessOrEqualByX(Point2D other) {
        return this.x <= other.x;
    }

    public boolean isGreaterOrEqualByY(Point2D other) {
        return this.y >= other.y;
    }

    public boolean isWithEqualY(Point2D other) {
        return this.y == other.y;
    }

    public boolean isLessOrEqualByY(Point2D other) {
        return this.y <= other.y;
    }

}
