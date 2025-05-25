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

        JPanel panel = new JPanel();

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.add(firstLabel);
        panel.add(secondLabel);
        panel.add(thirdLabel);

        panel.add(firstButton);
        panel.add(secondButton);
        panel.add(thirdButton);

        frame.add(panel);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
