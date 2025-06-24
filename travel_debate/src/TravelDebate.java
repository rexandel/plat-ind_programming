import game.GameController;
import model.Participant;

public class TravelDebate {
    public static void main(String[] args) throws InterruptedException {
        GameController game = new GameController();

        System.out.println("Presenter thought of a way to move...");

        Thread[] participants = {
                new Thread(new Participant("Participant 1", game)),
                new Thread(new Participant("Participant 2", game)),
                new Thread(new Participant("Participant 3", game))
        };

        for (Thread t : participants) t.start();
        for (Thread t : participants) t.join();

        System.out.println("\nResults:");
        System.out.println("Winner: " + game.getWinnerName());
        System.out.println("Guessed way: " + game.getWinnerTransport());
    }
}