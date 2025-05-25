import javax.swing.*;
import java.awt.*;

class BoxOne extends JFrame {
    public BoxOne() {
        super("BoxOne - Y");
        setSize(400, 200);
        
        Container c = getContentPane();
        BoxLayout boxy = new BoxLayout(c, BoxLayout.Y_AXIS);
        c.setLayout(boxy);
        
        c.add(new JButton("First"));
        c.add(new JButton("Second"));
        c.add(new JButton("Third"));
    }
}

class BoxTwo extends JFrame {
    public BoxTwo() {
        super("BoxTwo - X");
        setSize(400, 200);
        
        Container c = getContentPane();
        BoxLayout boxx = new BoxLayout(c, BoxLayout.X_AXIS);
        c.setLayout(boxx);
        
        c.add(new JButton("First"));
        c.add(new JButton("Second"));
        c.add(new JButton("Third"));
    }
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BoxOne frameOne = new BoxOne();
            frameOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameOne.setLocation(100, 100);
            frameOne.setVisible(true);

            BoxTwo frameTwo = new BoxTwo();
            frameTwo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameTwo.setLocation(550, 100);
            frameTwo.setVisible(true);
        });
    }
}