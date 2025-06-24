package predicates;
import cars.*;

public class isFord implements CarPredicate {
    public boolean test(Car car) { return car.getBrand().equalsIgnoreCase("Ford"); }
}