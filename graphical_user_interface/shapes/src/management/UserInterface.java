package management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserInterface extends JPanel {
    public UserInterface() {
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));

        JButton circleButton = new JButton("Draw Circle");
        JButton rectangleButton = new JButton("Draw Rectangle");
        JButton lineButton = new JButton("Draw Line");
        JButton triangleButton = new JButton("Draw Triangle");

        buttonPanel.add(circleButton);
        buttonPanel.add(rectangleButton);
        buttonPanel.add(lineButton);
        buttonPanel.add(triangleButton);

        add(buttonPanel, BorderLayout.NORTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}

class DrawingPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {

    }
}
