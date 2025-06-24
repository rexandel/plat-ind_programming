package predicates;
import cars.*;

public class isToyota implements CarPredicate {
    public boolean test(Car car) {
        return car.getBrand().equals("Toyota");
    }
}