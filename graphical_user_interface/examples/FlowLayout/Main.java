import java.awt.FlowLayout;
import javax.swing.*;

class FlowTest extends JFrame {
    String[] items = {
            "First element",
            "Second element",
            "Third element"
    };

    FlowTest(String title) {
        super(title);
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        add(new JButton("Button"));
        add(new JLabel("Label"));
        add(new JCheckBox("CheckBox"));
        add(new JComboBox(items));
        add(new JTextField("Input", 10));
        setSize(400, 200);
    }
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FlowTest frame = new FlowTest("FlowLayout");
            frame.setLocation(400, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}