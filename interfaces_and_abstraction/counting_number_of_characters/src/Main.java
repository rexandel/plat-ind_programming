import utils.PrintSimulator;

public class Main {
    public static void main(String[] args) {
            PrintSimulator printSimulatorObject = new PrintSimulator("abcd", "abracadabra");

            System.out.println(printSimulatorObject.getCountOfCorrectCharacters());
        }
}