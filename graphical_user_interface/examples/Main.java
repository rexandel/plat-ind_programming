import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Application");
        JLabel label = new JLabel("Hello world!");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(label);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
