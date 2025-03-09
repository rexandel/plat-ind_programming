package shapes;

import management.ColorParser;

import java.awt.Color;
import java.util.Arrays;
import java.util.Objects;

public abstract class Shape {
    protected double[] initialPoint;
    protected Color lineColor;
    protected Color fillColor;

    abstract protected double square();
    abstract protected double perimeter();

    protected Shape(double[] initialPoint) {
        setInitialPoint(initialPoint);
        setLineColor(Color.white);
        setFillColor(new Color(0, 0, 0, 0));
    }

    protected Shape(double[] initialPoint, Color lineColor) {
        setInitialPoint(initialPoint);
        setLineColor(lineColor);
        setFillColor(new Color(0, 0, 0, 0));
    }

    protected void move(Double xAxisShift, Double yAxisShift) {
        if (xAxisShift == null) {
            xAxisShift = 0.0;
        }
        if (yAxisShift == null) {
            yAxisShift = 0.0;
        }
        getInitialPoint()[0] += xAxisShift;
        getInitialPoint()[1] += yAxisShift;
    }

    protected double[] getInitialPoint() {
        return initialPoint;
    }

    protected Color getLineColor() {
        return lineColor;
    }

    protected Color getFillColor() {
        return fillColor;
    }

    private void setInitialPoint(double[] initialPoint) {
        if (initialPoint == null) {
            throw new IllegalArgumentException("The array cannot be null.");
        }

        if (initialPoint.length != 2) {
            throw new IllegalArgumentException("The array must contain exactly two elements.");
        }

        if (Arrays.stream(initialPoint).anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("The array elements cannot be null.");
        }

        this.initialPoint = initialPoint;
    }

    private void setLineColor(Color lineColor) {
        if (lineColor == null) {
            throw new IllegalArgumentException("Line color cannot be null.");
        }
        this.lineColor = lineColor;
    }

    private void setFillColor(Color fillColor) {
        if (fillColor == null) {
            throw new IllegalArgumentException("Fill color cannot be null.");
        }
        this.fillColor = fillColor;
    }

    @Override
    public String toString() {
        return
                "Initial Point: " + Arrays.toString(getInitialPoint()) + "\n" +
                "Line Color: " + ColorParser.getStringFromColor(getLineColor()) + "\n" +
                "Fill Color: " + ColorParser.getStringFromColor(getFillColor());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return Objects.deepEquals(initialPoint, shape.initialPoint) && Objects.equals(lineColor, shape.lineColor) && Objects.equals(fillColor, shape.fillColor);
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (initialPoint == null ? 0 : Arrays.hashCode(initialPoint));
        result = 31 * result + (lineColor == null ? 0 : Objects.hashCode(lineColor));
        result = 31 * result + (fillColor == null ? 0 : Objects.hashCode(fillColor));
        return result;
    }
}
