package paintoval;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Random Circles");
            frame.setContentPane(new DrawingPanel());
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class DrawingPanel extends JPanel {
    private final LinkedList<Circle> circles = new LinkedList<>();
    private final Random random = new Random();

    public DrawingPanel() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                circles.add(createRandomCircle(e.getX(), e.getY()));
                repaint();
            }
        });
    }

    private Circle createRandomCircle(int x, int y) {
        int size = random.nextInt(51) + 30;
        Color color = new Color(
            random.nextInt(256),
            random.nextInt(256), 
            random.nextInt(256),
            random.nextInt(157) + 100
        );
        return new Circle(x, y, size, color);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        circles.forEach(c -> {
            g.setColor(c.getColor());
            g.fillOval(c.getX(), c.getY(), c.getSize(), c.getSize());
        });
    }
}

class Circle {
    private final int x, y, size;
    private final Color color;

    public Circle(int x, int y, int size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getSize() { return size; }
    public Color getColor() { return color; }
}