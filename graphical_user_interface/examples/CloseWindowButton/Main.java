import javax.swing.*;

class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Window Title");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        JButton button = new JButton("Press me!");
        button.addActionListener(_ -> System.exit(0));
        
        panel.add(button);
        add(panel);
    }
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}