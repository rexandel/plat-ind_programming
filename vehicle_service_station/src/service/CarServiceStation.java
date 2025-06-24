package service;

import java.util.concurrent.Semaphore;

public class CarServiceStation {
    private static final int QUEUE_COUNT = 3;
    private static final int PARKING_CAPACITY = 10;
    private static final int TOTAL_CARS = 30;

    private final Semaphore queueSemaphore = new Semaphore(QUEUE_COUNT, true);
    private final Semaphore parkingSemaphore = new Semaphore(PARKING_CAPACITY, true);
    private int carCounter = 0;
    private int queueNumber = 0;

    public void startService() {
        System.out.println("Service station is opening with " + QUEUE_COUNT + " queues");
        System.out.println("Parking capacity: " + PARKING_CAPACITY + " cars\n");

        for (int i = 0; i < TOTAL_CARS; i++) {
            new Thread(new CarProcessor(
                    getNextQueueNumber(),
                    getNextCarId(),
                    queueSemaphore,
                    parkingSemaphore
            )).start();
        }
    }

    private synchronized int getNextQueueNumber() {
        int qNum = queueNumber;
        queueNumber = (queueNumber + 1) % QUEUE_COUNT;
        return qNum;
    }

    private synchronized int getNextCarId() {
        return ++carCounter;
    }

    public static void main(String[] args) {
        CarServiceStation station = new CarServiceStation();
        station.startService();
    }
}