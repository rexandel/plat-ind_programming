package game;

import java.util.Random;

public class GameController {
    private final String secretTransport;
    private String winnerName;
    private String winnerTransport;
    private volatile boolean gameOver = false;
    private final String[] transports = {"land", "sea", "air"};

    public GameController() {
        this.secretTransport = transports[new Random().nextInt(transports.length)];
    }

    public synchronized boolean checkGuess(String participantName, String guess) {
        if (gameOver) return false;

        if (guess.equals(secretTransport)) {
            gameOver = true;
            this.winnerName = participantName;
            this.winnerTransport = guess;
            return true;
        }
        return false;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public String getSecretTransport() {
        return secretTransport;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public String getWinnerTransport() {
        return winnerTransport;
    }

    public String[] getTransports() {
        return transports;
    }
}