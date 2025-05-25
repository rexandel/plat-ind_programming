import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Application");
        JLabel firstLabel = new JLabel("Hello world!");
        JLabel secondLabel = new JLabel("Hello, I'm here!");
        JLabel thirdLabel = new JLabel("Hello there...");

        JButton firstButton = new JButton("Press me!");
        JButton secondButton = new JButton("Don't touch other buttons...");
        JButton thirdButton = new JButton("Hello, click on me plz");

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(firstLabel);
        frame.add(secondLabel);
        frame.add(thirdLabel);

        frame.add(firstButton);
        frame.add(secondButton);
        frame.add(thirdButton);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
