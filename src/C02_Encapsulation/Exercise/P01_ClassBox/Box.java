package C02_Encapsulation.Exercise.P01_ClassBox;

public class Box {

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (dataValidation(length)) {
            this.length = length;
        }
    }

    private void setWidth(double width) {
        if (dataValidation(width)) {
            this.width = width;
        }
    }

    private void setHeight(double height) {
        if (dataValidation(height)) {
            this.height = height;
        }
    }

    private boolean dataValidation(double num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Number cannot be zero or negative.");
        }
        return true;
    }

    public double calculateSurfaceArea() {
        return (2 * this.length * this.width) +
                (2 * this.length * this.height) +
                (2 * this.width * this.height);
    }

    public double calculateLateralSurfaceArea() {
        return (2 * this.length * this.height) + (2 * this.width * this.height);
    }

    public double calculateVolume() {
        return this.length * this.width * this.height;
    }

}
