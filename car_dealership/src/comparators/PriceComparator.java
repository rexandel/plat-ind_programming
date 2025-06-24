package comparators;

import cars.*;
import java.util.Comparator;

public class PriceComparator implements Comparator<Car> {
    public int compare(Car c1, Car c2) {
        return Double.compare(c1.getPrice(), c2.getPrice());
    }
}