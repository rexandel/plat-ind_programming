package shapes;

import management.ColorParser;

import java.awt.*;
import java.util.Arrays;

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

    protected void move(double xAxisShift, double yAxisShift) {
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
        this.initialPoint = initialPoint;
    }

    private void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    private void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    @Override
    public String toString() {
        return
                "Initial Point: " + Arrays.toString(getInitialPoint()) + "\n" +
                "Line Color: " + ColorParser.getStringFromColor(getLineColor()) + "\n" +
                "Fill Color: " + ColorParser.getStringFromColor(getFillColor());
    }
}
