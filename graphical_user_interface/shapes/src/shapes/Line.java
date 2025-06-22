package shapes;

import interfaces.Drawable;

import java.awt.*;
import java.util.Arrays;
import java.util.Objects;

public class Line extends Shape implements Drawable {
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
    public void moveRight(double step) {
        super.moveRight(step);

        double[] currentSidePoint = getSidePoint();

        double newSidePointX = currentSidePoint[0] + step;

        setSidePoint(new double[]{newSidePointX, currentSidePoint[1]});
    }

    @Override
    public void moveLeft(double step) {
        super.moveLeft(step);

        double[] currentSidePoint = getSidePoint();

        double newSidePointX = currentSidePoint[0] - step;

        setSidePoint(new double[]{newSidePointX, currentSidePoint[1]});
    }

    @Override
    public void moveUp(double step) {
        super.moveUp(step);

        double[] currentSidePoint = getSidePoint();

        double newSidePointY = currentSidePoint[1] + step;

        setSidePoint(new double[]{currentSidePoint[0], newSidePointY});
    }

    @Override
    public void moveDown(double step) {
        super.moveDown(step);

        double[] currentSidePoint = getSidePoint();

        double newSidePointY = currentSidePoint[1] - step;

        setSidePoint(new double[]{currentSidePoint[0], newSidePointY});
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

    @Override
    public void draw(Graphics obj) {
        obj.setColor(getLineColor());
        obj.drawLine(  // drawLine(int x1, int y1, int x2, int y2)
                (int) getInitialPoint()[0],
                (int) getInitialPoint()[1],
                (int) sidePoint[0],
                (int) sidePoint[1]
        );
    }
}
