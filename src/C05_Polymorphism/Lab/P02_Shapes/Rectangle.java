package C05_Polymorphism.Lab.P02_Shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
        this.calculatePerimeter();
        this.calculateArea();
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(this.width * 2 + this.height * 2);
    }

    @Override
    public void calculateArea() {
        setArea(this.width * this.height);
    }
}
