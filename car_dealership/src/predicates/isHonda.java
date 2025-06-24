package predicates;
import cars.*;

public class isHonda implements CarPredicate {
    public boolean test(Car car) {
        return car.getBrand().equals("Honda");
    }
}