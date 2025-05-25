import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ToggleButtonFrame extends JFrame {
    public ToggleButtonFrame() {
        super("Button Decrease Number Example");
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        
        JButton button = createButton();
        
        JPanel panel = new JPanel();
        panel.add(button);
        
        add(panel, BorderLayout.CENTER);
        
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private JButton createButton() {
        JButton button = new JButton("10");
        button.addActionListener(new MyButtonListener());
        return button;
    }
}

class MyButtonListener implements ActionListener {
    private int number = 10;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (number != 1) {
            number--;
            ((JButton) e.getSource()).setText(String.valueOf(number));
        } else {
            System.exit(0);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ToggleButtonFrame frame = new ToggleButtonFrame();
            frame.setVisible(true);
        });
    }
}