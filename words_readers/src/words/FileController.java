package words;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileController {
    private final int threadCount;
    private final List<List<String>> threadWords;
    private int currentThread = 0;
    private BufferedReader reader;
    private boolean fileFinished = false;

    public FileController(int threadCount, String filePath) {
        this.threadCount = threadCount;
        this.threadWords = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            threadWords.add(new ArrayList<>());
        }
        try {
            this.reader = new BufferedReader(new FileReader(filePath));
        } catch (IOException e) {
            System.err.println("Error opening file: " + e.getMessage());
            System.exit(1);
        }
    }

    public synchronized void readWords(int threadId) throws IOException, InterruptedException {
        while (true) {
            while (!fileFinished && currentThread != threadId) {
                wait();
            }

            if (fileFinished) {
                break;
            }

            String line = reader.readLine();
            if (line == null) {
                fileFinished = true;
                notifyAll();
                break;
            }

            threadWords.get(threadId).add(line.trim());

            currentThread = (currentThread + 1) % threadCount;
            notifyAll();
        }
    }

    public void printResults() {
        for (int i = 0; i < threadCount; i++) {
            System.out.println("Thread " + (i + 1) + " words:");
            for (String word : threadWords.get(i)) {
                System.out.println(word);
            }
            System.out.println();
        }
    }

    public void close() throws IOException {
        reader.close();
    }
}
