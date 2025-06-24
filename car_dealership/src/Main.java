import comparators.*;
import cars.*;
import predicates.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Car> carList = Arrays.asList(
                new Car("Toyota", "Camry", 2020, "black", 2.5, 25000),
                new Car("Toyota", "Corolla", 2021, "white", 1.8, 20000),
                new Car("Toyota", "RAV4", 2022, "blue", 2.0, 32000),
                new Car("Toyota", "Highlander", 2021, "silver", 3.5, 42000),
                new Car("Honda", "Accord", 2020, "black", 2.4, 27000),
                new Car("Honda", "Civic", 2022, "white", 1.5, 22000),
                new Car("Honda", "CR-V", 2021, "red", 1.5, 30000),
                new Car("Honda", "Pilot", 2020, "gray", 3.5, 38000),
                new Car("Ford", "Focus", 2019, "white", 2.0, 15000),
                new Car("Ford", "Mustang", 2022, "yellow", 5.0, 45000),
                new Car("Ford", "Explorer", 2021, "black", 3.0, 35000),
                new Car("Ford", "F-150", 2020, "blue", 3.5, 48000),
                new Car("BMW", "X5", 2022, "black", 3.0, 65000),
                new Car("BMW", "3 Series", 2021, "white", 2.0, 42000),
                new Car("Mercedes", "C-Class", 2022, "silver", 2.0, 45000),
                new Car("Mercedes", "GLE", 2021, "black", 3.0, 68000),
                new Car("Audi", "A4", 2020, "gray", 2.0, 38000),
                new Car("Audi", "Q7", 2022, "blue", 3.0, 62000),
                new Car("Tesla", "Model 3", 2022, "red", 0.0, 48000),
                new Car("Tesla", "Model X", 2021, "white", 0.0, 95000)
        );

        // 1. Разделение по маркам
        List<Car> toyotas = Car.filterByPredicate(carList, new isToyota());
        List<Car> hondas = Car.filterByPredicate(carList, new isHonda());
        for (Car car : toyotas) {
            System.out.println(car);
        }
        System.out.println();

        // 2. Сортировка по году выпуска
        toyotas.sort(new YearComparator());
        for (Car car : toyotas) {
            System.out.println(car);
        }
        System.out.println();

        hondas.sort(new YearComparator());

        // 3. Сортировка по цене
        toyotas.sort(new PriceComparator());
        for (Car car : toyotas) {
            System.out.println(car);
        }
        System.out.println();

        hondas.sort(new PriceComparator());

        // 4. Поиск по модели
        Car found = Car.findByModel(carList, "Civic");

        // Фильтрация по цвету
        System.out.println("Белые автомобили:");
        Car.filterByPredicate(carList, new isColor("white")).forEach(System.out::println);

        System.out.println();

        // 5. Фильтрация автомобилей по цвету и объему двигателя (с использованием лямбда-выражений)
        List<Car> blackCars = Car.filterByPredicate(carList, (Car car) -> car.getColor().equals("black"));
        List<Car> carsWithSmallEngine = Car.filterByPredicate(carList, (Car car) -> car.getEngineVolume() < 2.0);
        System.out.println("Черные автомобили: " + blackCars);
        System.out.println("Автомобили с малым объемом двигателя: " + carsWithSmallEngine);
    }
}