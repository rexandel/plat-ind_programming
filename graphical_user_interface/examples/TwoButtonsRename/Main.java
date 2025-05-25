import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonTextHandler implements ActionListener {
    private boolean flag = true;
    private final JButton targetButton;
    
    public ButtonTextHandler(JButton targetButton) {
        this.targetButton = targetButton;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        flag = !flag;
        targetButton.setText(flag ? "Hello!" : "Goodbye!");
    }
}

class EventsFrame extends JFrame {
    public EventsFrame() {
        super("Events Demo");
        setupUI();
        configureFrame();
    }
    
    private void setupUI() {
        JPanel panel = new JPanel();
        
        JButton button1 = new JButton("Hello!");
        JButton button2 = new JButton("Hello!");
        
        button1.addActionListener(new ButtonTextHandler(button2));
        button2.addActionListener(new ButtonTextHandler(button1));
        
        panel.add(button1);
        panel.add(button2);
        
        add(panel);
    }
    
    private void configureFrame() {
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EventsFrame frame = new EventsFrame();
            frame.setVisible(true);
        });
    }
}