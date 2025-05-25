import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ToggleButtonFrame extends JFrame {
    public ToggleButtonFrame() {
        super("Button Toggle Example");
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        
        JButton toggleButton = createToggleButton();
        
        JPanel panel = new JPanel();
        panel.add(toggleButton);
        
        add(panel, BorderLayout.CENTER);
        
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private JButton createToggleButton() {
        JButton button = new JButton("Hello!");
        button.addActionListener(new ToggleButtonListener());
        return button;
    }
}

class ToggleButtonListener implements ActionListener {
    private boolean flag = true;

    @Override
    public void actionPerformed(ActionEvent e) {
        flag = !flag;
        ((JButton) e.getSource()).setText(flag ? "Hello!" : "Goodbye!");
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