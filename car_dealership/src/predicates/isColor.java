package predicates;
import cars.*;

public class isColor implements CarPredicate {
    private String color;
    public isColor(String color) { this.color = color; }
    public boolean test(Car car) { return car.getColor().equalsIgnoreCase(color); }
}
