package shapes;

import java.awt.*;

public abstract class Shape {
    protected double[] initialPoint;
    protected Color lineColor;
    protected Color fillColor;

    abstract protected double square();
    abstract protected double perimeter();

    protected Shape(double[] initialPoint) {
        setInitialPoint(initialPoint);
        setLineColor(Color.white);
        setFillColor(Color.black);
    }

    protected void move(double xAxisShift, double yAxisShift) {
        getInitialPoint()[0] += xAxisShift;
        getInitialPoint()[1] += yAxisShift;
    }

    public double[] getInitialPoint() {
        return initialPoint;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public Color getFillColor() {
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
}
