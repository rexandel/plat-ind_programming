package shapes;

public abstract class Shape {
    private double[] initialPoint;

    protected Shape(double[] initialPoint) {
        this.initialPoint = initialPoint;
    }

    abstract protected double square();
    abstract protected double perimeter();

    protected void move(double xAxisShift, double yAxisShift) {
        initialPoint[0] += xAxisShift;
        initialPoint[1] += yAxisShift;
    }

    protected void fill() {

    }

    public double[] getInitialPoint() {
        return initialPoint;
    }

    public void setInitialPoint(double[] initialPoint) {
        this.initialPoint = initialPoint;
    }
}
