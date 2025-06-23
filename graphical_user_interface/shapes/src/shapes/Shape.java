package shapes;

import color.ColorParser;
import interfaces.Drawable;
import interfaces.Movable;

import java.awt.*;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

public abstract class Shape implements Movable, Drawable {
    protected double[] initialPoint;
    protected Color lineColor;
    protected Color fillColor;

    abstract protected double perimeter();

    protected Shape(double[] initialPoint) {
        setInitialPoint(initialPoint);
        setLineColor(Color.black);
        setFillColor(new Color(255, 255, 255, 0));
    }

    protected Shape(double[] initialPoint, Color lineColor) {
        setInitialPoint(initialPoint);
        setLineColor(lineColor);
        setFillColor(new Color(255, 255, 255, 0));
    }

    protected Shape(double[] initialPoint, Color lineColor, Color fillColor) {
        setInitialPoint(initialPoint);
        setLineColor(lineColor);
        setFillColor(fillColor);
    }

    @Override
    public void moveRight(double step) {
        double[] currentPoint = getInitialPoint();

        double newInitialPointX = currentPoint[0] + step;

        setInitialPoint(new double[]{newInitialPointX, currentPoint[1]});
    }

    @Override
    public void moveLeft(double step) {
        double[] currentPoint = getInitialPoint();

        double newInitialPointX = currentPoint[0] - step;

        setInitialPoint(new double[]{newInitialPointX, currentPoint[1]});
    }

    @Override
    public void moveUp(double step) {
        double[] currentPoint = getInitialPoint();

        double newInitialPointY = currentPoint[1] + step;

        setInitialPoint(new double[]{currentPoint[0], newInitialPointY});
    }

    @Override
    public void moveDown(double step) {
        double[] currentPoint = getInitialPoint();

        double newInitialPointY = currentPoint[1] - step;

        setInitialPoint(new double[]{currentPoint[0], newInitialPointY});
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

    public void setFillColor(Color fillColor) {
        if (fillColor == null) {
            throw new IllegalArgumentException("Fill color cannot be null.");
        }

        this.fillColor = fillColor;
    }

    @Override
    public String toString() {
        return
                "Class Name: "      + this.getClass().getSimpleName() + "\n" +
                "Line Color: "      + ColorParser.getStringFromRGBA(ColorParser.getRGBAFromColor(getLineColor())) + "\n" +
                "Fill Color: "      + ColorParser.getStringFromRGBA(ColorParser.getRGBAFromColor(getFillColor())) + "\n" +
                "Initial Point: "   + Arrays.toString(getInitialPoint()) + "\n" +
                "Perimeter: "       + String.format(Locale.ENGLISH, "%.2f", perimeter());
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

    public void draw(Graphics obj) { }
}
