package comparators;

import cars.*;
import java.util.Comparator;

public class YearComparator implements Comparator<Car> {
    public int compare(Car c1, Car c2) {
        return Integer.compare(c1.getYear(), c2.getYear());
    }
}
