import java.awt.*;
import javax.swing.*;

class BorderPanelTest extends JFrame {
    BorderPanelTest(String title) {
        super(title);
        setLayout(new BorderLayout());
        
        JPanel p1 = new JPanel(new BorderLayout());
        
        JPanel p2 = new JPanel();
        JLabel label = new JLabel("This is panel p2:");
        label.setForeground(Color.BLUE);
        p2.add(label);
        p2.add(new JButton("Execute"));
        p2.add(new JButton("Cancel"));
        p2.add(new JButton("Exit"));
        
        p1.add(new JTextField("Input field", 20), BorderLayout.NORTH);
        p1.add(new JScrollPane(new JTextArea("Input area", 20, 5)), BorderLayout.CENTER);
        p1.add(p2, BorderLayout.SOUTH);
        p1.setBorder(BorderFactory.createEtchedBorder());
        
        add(p1, BorderLayout.CENTER);
        
        add(new JButton("Quit completely"), BorderLayout.SOUTH);
        
        setSize(400, 200);
    }
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BorderPanelTest frame = new BorderPanelTest("BorderLayout");
            frame.setLocation(400, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}