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
        setLineColor(Color.black);
        setFillColor(new Color(255, 255, 255, 0));
    }

    protected Shape(double[] initialPoint, Color lineColor) {
        setInitialPoint(initialPoint);
        setLineColor(lineColor);
        setFillColor(new Color(0, 0, 0, 0));
    }

    protected void move(double xAxisShift, double yAxisShift) {
        double[] currentPoint = getInitialPoint();

        double newX = currentPoint[0] + xAxisShift;
        double newY = currentPoint[1] + yAxisShift;

        setInitialPoint(new double[]{newX, newY});
    }

    private void setInitialPoint(double[] initialPoint) {
        if (initialPoint == null) {
            throw new IllegalArgumentException("Array with coordinates of initial point cannot be null.");
        }

        if (initialPoint.length != 2) {
            throw new IllegalArgumentException("Array with coordinates of initial point must contain exactly two elements.");
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
                "Line Color: " + ColorParser.getStringFromRGBA(ColorParser.getRGBAFromColor(getLineColor())) + "\n" +
                "Fill Color: " + ColorParser.getStringFromRGBA(ColorParser.getRGBAFromColor(getFillColor()));
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
        int result = Arrays.hashCode(initialPoint);
        result += 31 * result + Objects.hashCode(lineColor);
        result += 31 * result + Objects.hashCode(fillColor);
        return result;
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
}
