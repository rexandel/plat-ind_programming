package shapes;

public class Circle extends Shape {
    private double radius;

    protected Circle(double[] initialPoint, double radius) {
        super(initialPoint);
        this.radius = radius;
    }

    public double square() {
        return Math.PI * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}
