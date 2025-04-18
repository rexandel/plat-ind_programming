package shapes;

import interfaces.Squareable;

import java.awt.Color;
import java.util.Arrays;
import java.util.Objects;

public class Rectangle extends Shape implements Squareable {
    private double[] sidePoint;
    private double length;
    private double height;

    public Rectangle(double[] initialPoint, double[] sidePoint) {
        super(initialPoint);
        setSidePoint(sidePoint);
        setLength(Math.max(initialPoint[0], sidePoint[0]) - Math.min(initialPoint[0], sidePoint[0]));
        setHeight(Math.max(initialPoint[1], sidePoint[1]) - Math.min(initialPoint[1], sidePoint[1]));
    }

    public Rectangle(double[] initialPoint, double[] sidePoint, Color lineColor) {
        super(initialPoint, lineColor);
        setSidePoint(sidePoint);
        setLength(Math.max(initialPoint[0], sidePoint[0]) - Math.min(initialPoint[0], sidePoint[0]));
        setHeight(Math.max(initialPoint[1], sidePoint[1]) - Math.min(initialPoint[1], sidePoint[1]));
    }

    public Rectangle(double[] initialPoint, double[] sidePoint, Color lineColor, Color fillColor) {
        super(initialPoint, lineColor, fillColor);
        setSidePoint(sidePoint);
        setLength(Math.max(initialPoint[0], sidePoint[0]) - Math.min(initialPoint[0], sidePoint[0]));
        setHeight(Math.max(initialPoint[1], sidePoint[1]) - Math.min(initialPoint[1], sidePoint[1]));
    }

    @Override
    public double square() {
        return length * height;
    }

    public double perimeter() {
        return 2 * (length + height);
    }

    private void setSidePoint(double[] sidePoint) {
        if (sidePoint == null) {
            throw new IllegalArgumentException("Array with coordinates of side point cannot be null.");
        }

        if (sidePoint.length != 2) {
            throw new IllegalArgumentException("Array with coordinates of side point must contain exactly two elements.");
        }

        if (Arrays.equals(sidePoint, getInitialPoint())) {
            throw new IllegalArgumentException("Side point cannot match initial point.");
        }

        this.sidePoint = sidePoint;
    }

    private void setLength(double length) {
        if (length < 0) {
            throw new IllegalArgumentException("Height cannot be less than zero.");
        }

        if (length == 0) {
            throw new IllegalArgumentException("Length cannot be zero.");
        }

        this.length = length;
    }

    private void setHeight(Double height) {
        if (height < 0) {
            throw new IllegalArgumentException("Height cannot be less than zero.");
        }

        if (height == 0) {
            throw new IllegalArgumentException("Height cannot be zero.");
        }

        this.height = height;
    }

    @Override
    public String toString() {
        return
                super.toString() + "\n" +
                "Side Point: " + Arrays.toString(getSidePoint()) + "\n" +
                "Length: " + getLength() + "\n" +
                "Height: " + getHeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(length, rectangle.length) == 0 && Double.compare(height, rectangle.height) == 0 && Objects.deepEquals(sidePoint, rectangle.sidePoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Arrays.hashCode(sidePoint), length, height);
    }

    public double[] getSidePoint() {
        return sidePoint;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }
}
