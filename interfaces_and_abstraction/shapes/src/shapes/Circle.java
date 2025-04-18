package shapes;

import interfaces.Squareable;

import java.awt.Color;
import java.util.Objects;

public class Circle extends Shape implements Squareable {
    private double radius;

    public Circle(double[] initialPoint, double radius) {
        super(initialPoint);
        setRadius(radius);
    }

    public Circle(double[] initialPoint, double radius, Color lineColor) {
        super(initialPoint, lineColor);
        setRadius(radius);
    }

    public Circle(double[] initialPoint, double radius, Color lineColor, Color fillColor) {
        super(initialPoint, lineColor, fillColor);
        setRadius(radius);
    }

    @Override
    public double square() {
        return Math.PI * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    private void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be less than zero.");
        }

        if (radius == 0) {
            throw new IllegalArgumentException("Radius cannot be zero.");
        }

        this.radius = radius;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Radius: " + getRadius();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return Double.compare(radius, circle.radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), radius);
    }

    public double getRadius() {
        return radius;
    }
}
