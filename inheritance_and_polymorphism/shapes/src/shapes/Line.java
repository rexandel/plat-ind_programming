package shapes;

import java.awt.*;
import java.util.Arrays;
import java.util.Objects;

public class Line extends Shape {
    private double[] sidePoint;

    public Line(double[] initialPoint, double[] sidePoint) {
        super(initialPoint);
        setSidePoint(sidePoint);
    }

    public Line(double[] initialPoint, double[] sidePoint, Color lineColor) {
        super(initialPoint, lineColor);
        setSidePoint(sidePoint);
    }

    public Line(double[] initialPoint, double[] sidePoint, Color lineColor, Color fillColor) {
        super(initialPoint, lineColor, fillColor);
        setSidePoint(sidePoint);
    }

    @Override
    public void move(double xAxisShift, double yAxisShift) {
        super.move(xAxisShift, yAxisShift);
    }

    @Override
    public double square() {
        return 0;
    }

    @Override
    public double perimeter() {
        return Math.sqrt(Math.pow(getSidePoint()[0] - getInitialPoint()[0], 2) + Math.pow(getSidePoint()[1] - getInitialPoint()[1], 2));
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

    @Override
    public String toString() {
        return
                super.toString() + "\n" +
                "Side Point: " + Arrays.toString(getSidePoint());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Line line = (Line) o;
        return Objects.deepEquals(sidePoint, line.sidePoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Arrays.hashCode(sidePoint));
    }

    public double[] getSidePoint() {
        return sidePoint;
    }
}
