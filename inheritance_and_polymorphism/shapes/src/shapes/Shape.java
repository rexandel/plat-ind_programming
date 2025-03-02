package shapes;

public abstract class Shape {
    private double[] initialPoint;

    protected Shape(double[] initialPoint) {
        setInitialPoint(initialPoint);
    }

    abstract protected double square();
    abstract protected double perimeter();

    protected void move(double xAxisShift, double yAxisShift) {
        getInitialPoint()[0] += xAxisShift;
        getInitialPoint()[1] += yAxisShift;
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
