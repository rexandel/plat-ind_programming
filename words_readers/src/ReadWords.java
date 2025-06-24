import words.FileController;
import words.WordReaderTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadWords {
    private static final int threadCount = 4;
    public static final String filePath = "C:/Users/rexandel/Desktop/GitHub/platform-independent_programming/words_readers/src/words.txt";

    public static void main(String[] args) {
        try {
            FileController controller = new FileController(threadCount, filePath);

            List<Thread> threads = new ArrayList<>();
            for (int i = 0; i < threadCount; i++) {
                WordReaderTask task = new WordReaderTask(i, controller);
                Thread thread = new Thread(task);
                threads.add(thread);
                thread.start();
            }

            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            controller.printResults();
            controller.close();

        } catch (IOException e) {
            System.err.println("Error initializing words.FileController: " + e.getMessage());
        }
    }
}
