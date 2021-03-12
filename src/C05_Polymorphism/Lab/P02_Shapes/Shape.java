package C05_Polymorphism.Lab.P02_Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    protected void setArea(Double area) {
        this.area = area;
    }

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public Double getArea() {
        return area;
    }

    public Double getPerimeter() {
        return perimeter;
    }

    protected abstract void calculatePerimeter();


    public abstract void calculateArea();
}
