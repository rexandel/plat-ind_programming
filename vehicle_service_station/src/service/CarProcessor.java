package service;

import model.Car;
import java.util.concurrent.Semaphore;

public class CarProcessor implements Runnable {
    private final int currentQueue;
    private final Car car;
    private final Semaphore queueSemaphore;
    private final Semaphore parkingSemaphore;

    public CarProcessor(int queueNumber, int carId, Semaphore queueSemaphore, Semaphore parkingSemaphore) {
        this.currentQueue = queueNumber;
        this.car = new Car(carId);
        this.queueSemaphore = queueSemaphore;
        this.parkingSemaphore = parkingSemaphore;
    }

    @Override
    public void run() {
        try {
            queueSemaphore.acquire();
            System.out.println("[Queue " + currentQueue + "]: Processing " + car);

            checkDocuments();

            if (parkingSemaphore.tryAcquire()) {
                inspectCar();
            } else {
                System.out.println("[Queue " + currentQueue + "]: " + car + " waiting for parking slot...");
                parkingSemaphore.acquire();
                inspectCar();
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            queueSemaphore.release();
        }
    }

    private void checkDocuments() throws InterruptedException {
        System.out.println("[Queue " + currentQueue + "]: Checking documents for " + car);
        Thread.sleep(100 + (int)(Math.random() * 20));
    }

    private void inspectCar() throws InterruptedException {
        try {
            System.out.println("[Queue " + currentQueue + "]: " + car + " entered parking. (Slots left: "
                    + parkingSemaphore.availablePermits() + ")");

            Thread.sleep(300 + (int)(Math.random() * 500));

            System.out.println("[Queue " + currentQueue + "]: " + car + " inspection completed, leaving parking. "
                    + "(Slots left: " + (parkingSemaphore.availablePermits() + 1) + ")");
        }
        finally {
            parkingSemaphore.release();
        }
    }
}