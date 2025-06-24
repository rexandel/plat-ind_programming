package model;

import game.GameController;
import java.util.Random;

public class Participant implements Runnable {
    private final String name;
    private final GameController game;
    private final Random random = new Random();

    public Participant(String name, GameController game) {
        this.name = name;
        this.game = game;
    }

    @Override
    public void run() {
        try {
            while (!game.isGameOver()) {
                Thread.sleep(random.nextInt(1000));
                String guess = game.getTransports()[random.nextInt(game.getTransports().length)];

                if (game.checkGuess(name, guess)) {
                    System.out.println(name + " guessed right: " + guess + " (winner)");
                } else {
                    System.out.println(name + " guessed: " + guess);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}