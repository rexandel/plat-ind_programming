import utils.PrintSimulator;
import utils.SentenceGenerator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String generatedSentence = SentenceGenerator.generateSentence();

        System.out.println("Generated sentence: " + generatedSentence + " " + generatedSentence.length());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Now, please enter your own sentence:");
        String userSentence = scanner.nextLine();

        PrintSimulator printSimulatorObject = new PrintSimulator(userSentence, generatedSentence);

        System.out.println();

        System.out.println("Your statistic:");
        System.out.println(printSimulatorObject);
    }
}
