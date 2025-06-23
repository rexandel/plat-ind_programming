import gui.PaintApplication;
import shapes.Shape;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PaintApplication();
            }
        });
    }
}
