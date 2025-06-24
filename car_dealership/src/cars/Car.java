package cars;

import predicates.CarPredicate;
import java.util.*;

public class Car {
    private String brand;
    private String model;
    private int year;
    private String color;
    private double engineVolume;
    private double price;

    public Car(String brand, String model, int year, String color, double engineVolume, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.engineVolume = engineVolume;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public double getPrice() {
        return price;
    }

    public static List<Car> filterByPredicate(List<Car> list, CarPredicate predicate) {
        List<Car> result = new ArrayList<>();
        for (Car car : list) {
            if (predicate.test(car)) {
                result.add(car);
            }
        }
        return result;
    }

    public static Car findByModel(List<Car> list, String model) {
        for (Car car : list) {
            if (car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return brand + " " + model + " (" + year + "), Color: " + color +
                ", Engine: " + engineVolume + "L, Price: $" + price;
    }
}