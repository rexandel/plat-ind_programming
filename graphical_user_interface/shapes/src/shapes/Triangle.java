package shapes;

import interfaces.Drawable;
import interfaces.Squareable;

import java.awt.*;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

public class Triangle extends Shape implements Squareable, Drawable {
    private double[] vertexPoint;
    private double[] sidePoint;
    private double aSide;
    private double bSide;
    private double cSide;

    public Triangle(double[] initialPoint, double[] vertexPoint, double[] sidePoint) {
        super(initialPoint);
        setPoints(vertexPoint, sidePoint);
        setSides();
    }

    public Triangle(double[] initialPoint, double[] vertexPoint, double[] sidePoint, Color lineColor) {
        super(initialPoint, lineColor);
        setPoints(vertexPoint, sidePoint);
        setSides();
    }

    public Triangle(double[] initialPoint, double[] vertexPoint, double[] sidePoint, Color lineColor, Color fillColor) {
        super(initialPoint, lineColor, fillColor);
        setPoints(vertexPoint, sidePoint);
        setSides();
    }

    @Override
    public void moveRight(double step) {
        super.moveRight(step);

        double[] currentVertexPoint = getVertexPoint();
        double[] currentSidePoint = getSidePoint();

        double newVertexPointX = currentVertexPoint[0] + step;
        double newSidePointX = currentSidePoint[0] + step;

        setVertexPoint(new double[]{newVertexPointX, currentVertexPoint[1]});
        setSidePoint(new double[]{newSidePointX, currentSidePoint[1]});
    }

    @Override
    public void moveLeft(double step) {
        super.moveLeft(step);

        double[] currentVertexPoint = getVertexPoint();
        double[] currentSidePoint = getSidePoint();

        double newVertexPointX = currentVertexPoint[0] - step;
        double newSidePointX = currentSidePoint[0] - step;

        setVertexPoint(new double[]{newVertexPointX, currentVertexPoint[1]});
        setSidePoint(new double[]{newSidePointX, currentSidePoint[1]});
    }

    @Override
    public void moveUp(double step) {
        super.moveUp(step);

        double[] currentVertexPoint = getVertexPoint();
        double[] currentSidePoint = getSidePoint();

        double newVertexPointY = currentVertexPoint[1] + step;
        double newSidePointY = currentSidePoint[1] + step;

        setVertexPoint(new double[]{currentVertexPoint[0], newVertexPointY});
        setSidePoint(new double[]{currentSidePoint[0], newSidePointY});
    }

    @Override
    public void moveDown(double step) {
        super.moveDown(step);

        double[] currentVertexPoint = getVertexPoint();
        double[] currentSidePoint = getSidePoint();

        double newVertexPointY = currentVertexPoint[1] - step;
        double newSidePointY = currentSidePoint[1] - step;

        setVertexPoint(new double[]{currentVertexPoint[0], newVertexPointY});
        setSidePoint(new double[]{currentSidePoint[0], newSidePointY});
    }

    @Override
    public double square() {
        double semiPerimeter = this.perimeter() / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - getASide()) * (semiPerimeter - getBSide()) * (semiPerimeter - getCSide()));
    }

    @Override
    public double perimeter() {
        return getASide() + getBSide() +getCSide();
    }

    private void setVertexPoint(double[] vertexPoint) {
        if (vertexPoint == null) {
            throw new IllegalArgumentException("Array with coordinates of vertex point cannot be null.");
        }

        if (vertexPoint.length != 2) {
            throw new IllegalArgumentException("Array with coordinates of vertex point must contain exactly two elements.");
        }

        this.vertexPoint = vertexPoint;
    }

    private void setSidePoint(double[] sidePoint) {
        if (sidePoint == null) {
            throw new IllegalArgumentException("Array with coordinates of side point cannot be null.");
        }

        if (sidePoint.length != 2) {
            throw new IllegalArgumentException("Array with coordinates of side point must contain exactly two elements.");
        }

        this.sidePoint = sidePoint;
    }

    private void setPoints(double[] vertexPoint, double[] sidePoint) {
        if (Arrays.equals(vertexPoint, sidePoint) || Arrays.equals(vertexPoint, getInitialPoint()) || Arrays.equals(sidePoint, getInitialPoint())) {
            throw new IllegalArgumentException("Points should not match.");
        }

        if (arePointsCollinear(getInitialPoint(), vertexPoint, sidePoint)) {
            throw new IllegalArgumentException("Points should not lie on the same line.");
        }

        setVertexPoint(vertexPoint);
        setSidePoint(sidePoint);
    }

    private void setSides() {
        double a = Math.sqrt(Math.pow(getInitialPoint()[0] - getVertexPoint()[0], 2) + Math.pow(getInitialPoint()[1] - getVertexPoint()[1], 2));
        double b = Math.sqrt(Math.pow(getVertexPoint()[0] - getSidePoint()[0], 2) + Math.pow(getVertexPoint()[1] - getSidePoint()[1], 2));
        double c = Math.sqrt(Math.pow(getInitialPoint()[0] - getSidePoint()[0], 2) + Math.pow(getInitialPoint()[1] - getSidePoint()[1], 2));

        if (a + b <= c || a + c <= b || c + b <= a) {
            throw new IllegalArgumentException("Sum of two sides should not be less than third side.");
        }

        setASide(a);
        setBSide(b);
        setCSide(c);
    }

    private void setASide(double aSide) {
        if (aSide < 0) {
            throw new IllegalArgumentException("Side length cannot be less than zero.");
        }

        if (aSide == 0) {
            throw new IllegalArgumentException("Side length cannot be zero.");
        }

        this.aSide = aSide;
    }

    private void setBSide(double bSide) {
        if (bSide < 0) {
            throw new IllegalArgumentException("Side length cannot be less than zero.");
        }

        if (bSide == 0) {
            throw new IllegalArgumentException("Side length cannot be zero.");
        }

        this.bSide = bSide;
    }

    private void setCSide(double cSide) {
        if (cSide < 0) {
            throw new IllegalArgumentException("Side length cannot be less than zero.");
        }

        if (cSide == 0) {
            throw new IllegalArgumentException("Side length cannot be zero.");
        }

        this.cSide = cSide;
    }

    @Override
    public String toString() {
        return
                super.toString() + "\n" +
                "Square: " + String.format(Locale.ENGLISH,"%.2f", square()) + "\n" +
                "Vertex Point: " + Arrays.toString(getVertexPoint()) + "\n" +
                "Side Point: " + Arrays.toString(getSidePoint()) + "\n" +
                "A Side: " + String.format(Locale.ENGLISH,"%.2f", getASide()) + "\n" +
                "B Side: " + String.format(Locale.ENGLISH,"%.2f", getBSide()) + "\n" +
                "C Side: " + String.format(Locale.ENGLISH,"%.2f", getCSide());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(aSide, triangle.aSide) == 0 && Double.compare(bSide, triangle.bSide) == 0 && Double.compare(cSide, triangle.cSide) == 0 && Objects.deepEquals(vertexPoint, triangle.vertexPoint) && Objects.deepEquals(sidePoint, triangle.sidePoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Arrays.hashCode(vertexPoint), Arrays.hashCode(sidePoint), aSide, bSide, cSide);
    }

    public double[] getVertexPoint() {
        return vertexPoint;
    }

    public double[] getSidePoint() {
        return sidePoint;
    }

    public double getASide() {
        return aSide;
    }

    public double getBSide() {
        return bSide;
    }

    public double getCSide() {
        return cSide;
    }

    private boolean arePointsCollinear(double[] initialPoint, double[] vertexPoint, double[] sidePoint) {
        double determinant =
                (initialPoint[0] * (vertexPoint[1] - sidePoint[1]) +
                vertexPoint[0] * (sidePoint[1] - initialPoint[1]) +
                sidePoint[0] * (initialPoint[1] - vertexPoint[1]));

        return Math.abs(determinant) < 1e-10;
    }

    @Override
    public void draw(Graphics obj) {
        int[] xPoints = {
                (int) getInitialPoint()[0],
                (int) vertexPoint[0],
                (int) sidePoint[0]
        };
        int[] yPoints = {
                (int) getInitialPoint()[1],
                (int) vertexPoint[1],
                (int) sidePoint[1]
        };

        obj.setColor(getLineColor());
        obj.drawPolygon(xPoints, yPoints, 3);  // drawPolygon(int[] xPoints, int[] yPoints, int nPoints)
        if (getFillColor() != null) {
            obj.setColor(getFillColor());
            obj.fillPolygon(xPoints, yPoints, 3);  // fillPolygon(int[] xPoints, int[] yPoints, int nPoints)
        }
    }
}
