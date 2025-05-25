import java.awt.GridLayout;
import javax.swing.*;
import java.util.StringTokenizer;
import java.awt.Font;

class GridTest extends JFrame {
    GridTest(String title) {
        super(title);
        setLayout(new GridLayout(4, 4, 5, 5));
        
        String buttonLabels = "7 8 9 / 4 5 6 * 1 2 3 - 0 . = +";
        StringTokenizer st = new StringTokenizer(buttonLabels);
        
        while (st.hasMoreTokens()) {
            JButton button = new JButton(st.nextToken());
            button.setFont(new Font("Arial", Font.BOLD, 16));
            add(button);
        }
        
        setSize(400, 400);
    }
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GridTest frame = new GridTest("GridLayout");
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}