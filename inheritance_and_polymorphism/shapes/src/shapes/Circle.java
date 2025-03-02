package shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(double[] initialPoint, double radius) {
        super(initialPoint);
        setRadius(radius);
    }

    public double square() {
        return Math.PI * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Radius: " + getRadius();
    }
}
