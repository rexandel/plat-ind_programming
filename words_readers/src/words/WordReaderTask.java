package words;

import java.io.IOException;

public class WordReaderTask implements Runnable {
    private final int threadId;
    private final FileController controller;

    public WordReaderTask(int threadId, FileController controller) {
        this.threadId = threadId;
        this.controller = controller;
    }

    @Override
    public void run() {
        try {
            controller.readWords(threadId);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
