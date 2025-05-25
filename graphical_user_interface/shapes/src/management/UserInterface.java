package management;

import shapes.Circle;
import shapes.Rectangle;
import shapes.Line;
import shapes.Triangle;
import interfaces.IDrawFigure;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.*;

class DrawingPanel extends JPanel {
    private final List<IDrawFigure> shapes;

    public DrawingPanel(List<IDrawFigure> shapes) {
        this.shapes = shapes;
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        synchronized (shapes) {
            for (IDrawFigure shape : shapes) {
                shape.draw(g);
            }
        }
    }
}

public class UserInterface extends JPanel {
    private final DrawingPanel drawingPanel;
    private final List<IDrawFigure> shapes;
    private String selectedShapeType;

    public UserInterface() {
        setLayout(new BorderLayout());
        shapes = Collections.synchronizedList(new ArrayList<>());
        selectedShapeType = null;

        drawingPanel = new DrawingPanel(shapes);
        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (selectedShapeType != null) {
                    Point clickPoint = e.getPoint();
                    createShape(clickPoint);
                    drawingPanel.repaint();
                }
            }
        });

        // Panel for buttons & buttons & buttons actions
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));

        JButton circleButton = new JButton("Circle");
        JButton rectangleButton = new JButton("Rectangle");
        JButton lineButton = new JButton("Line");
        JButton triangleButton = new JButton("Triangle");

        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedShapeType = "CIRCLE";
            }
        });

        rectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedShapeType = "RECTANGLE";
            }
        });

        lineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedShapeType = "LINE";
            }
        });

        triangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedShapeType = "TRIANGLE";
            }
        });

        buttonPanel.add(circleButton);
        buttonPanel.add(rectangleButton);
        buttonPanel.add(lineButton);
        buttonPanel.add(triangleButton);

        add(buttonPanel, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);
    }

    private void createShape(Point clickPoint) {
        switch (selectedShapeType) {
            case "CIRCLE":
                shapes.add(new Circle(
                    new double[]{clickPoint.getX(), clickPoint.getY()},
                    30,
                    Color.RED,
                    Color.PINK
                ));
                break;
            case "RECTANGLE":
                shapes.add(new Rectangle(
                    new double[]{clickPoint.getX(), clickPoint.getY()},
                    new double[]{clickPoint.getX() + 100, clickPoint.getY() + 200},
                    Color.BLUE,
                    Color.CYAN
                ));
                break;
            case "LINE":
                shapes.add(new Line(
                    new double[]{clickPoint.getX(), clickPoint.getY()},
                    new double[]{clickPoint.getX() + 100, clickPoint.getY() + 100},
                    Color.BLACK
                ));
                break;
            case "TRIANGLE":
                shapes.add(new Triangle(
                    new double[]{clickPoint.getX(), clickPoint.getY()},
                    new double[]{clickPoint.getX() + 90, clickPoint.getY() - 100},
                    new double[]{clickPoint.getX() + 90, clickPoint.getY()},
                    Color.MAGENTA,
                    Color.ORANGE
                ));
                break;
        }
    }
}
