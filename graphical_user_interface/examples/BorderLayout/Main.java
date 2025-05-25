import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;

class BorderTest extends JFrame {
    BorderTest(String title) {
        super(title);
        setLayout(new BorderLayout());
        
        add(new JButton("North"), BorderLayout.NORTH);
        add(new JButton("South"), BorderLayout.SOUTH);
        add(new JButton("West"), BorderLayout.WEST);
        add(new JButton("East"), BorderLayout.EAST);
        
        JTextField tf = new JTextField("Center");
        tf.setBackground(Color.YELLOW);
        tf.setForeground(Color.RED);
        tf.setHorizontalAlignment(JTextField.CENTER);
        add(tf, BorderLayout.CENTER);
        
        setSize(400, 200);
    }
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BorderTest frame = new BorderTest("BorderLayout");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        });
    }
}