package gui;

import shapes.*;
import shapes.Rectangle;
import shapes.Shape;

import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class PaintPanel extends JPanel {
    public static final String CIRCLE = "Circle";
    public static final String RECTANGLE = "Rectangle";
    public static final String TRIANGLE = "Triangle";
    public static final String LINE = "Line";

    private LinkedList<Shape> shapes = new LinkedList<>();
    private Shape currentShape;
    private String currentShapeType = CIRCLE;
    private Color currentLineColor = Color.BLACK;
    private Color currentFillColor = null;

    private Random random = new Random();

    public PaintPanel() {
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                createShapeAt(e.getX(), e.getY());
                repaint();
            }
        });
    }

    private void createShapeAt(int x, int y) {
        double[] point = {x, y};

        switch (currentShapeType) {
            case CIRCLE:
                currentShape = createCircle(point);
                break;
            case RECTANGLE:
                currentShape = createRectangle(point);
                break;
            case TRIANGLE:
                currentShape = createTriangle(point);
                break;
            case LINE:
                currentShape = createLine(point);
                break;
        }

        if (currentShape != null) {
            shapes.add(currentShape);
        }
    }

    private Shape createCircle(double[] center) {
        int radius = 30 + random.nextInt(50);

        if (currentFillColor == null) {
            return new Circle(center, radius, currentLineColor);
        } else {
            return new Circle(center, radius, currentLineColor, currentFillColor);
        }
    }

    private Shape createRectangle(double[] startPoint) {
        double[] endPoint = {
                startPoint[0] + 50 + random.nextInt(100),
                startPoint[1] + 30 + random.nextInt(70)
        };

        if (currentFillColor == null) {
            return new Rectangle(startPoint, endPoint, currentLineColor);
        } else {
            return new Rectangle(startPoint, endPoint, currentLineColor, currentFillColor);
        }
    }

    private Shape createTriangle(double[] basePoint) {
        int baseWidth = 60 + random.nextInt(80);
        int height = 50 + random.nextInt(70);

        double[] vertexPoint = {
                basePoint[0] + (random.nextBoolean() ? 1 : -1) * (30 + random.nextInt(20)),
                basePoint[1] - height
        };

        double[] sidePoint = {
                basePoint[0] + (random.nextBoolean() ? baseWidth : -random.nextInt(baseWidth)),
                basePoint[1] + (random.nextBoolean() ? 0 : random.nextInt(20))
        };

        if (currentFillColor == null) {
            return new Triangle(basePoint, vertexPoint, sidePoint, currentLineColor);
        } else {
            return new Triangle(basePoint, vertexPoint, sidePoint, currentLineColor, currentFillColor);
        }
    }

    private Shape createLine(double[] startPoint) {
        double[] endPoint = {
                startPoint[0] + 50 + random.nextInt(100),
                startPoint[1] + random.nextInt(100) - 50
        };
        return new Line(startPoint, endPoint, currentLineColor);
    }

    public void setShapeType(String type) {
        this.currentShapeType = type;
    }

    public String getCurrentShapeType() {
        return currentShapeType;
    }

    public void setLineColor(Color color) {
        this.currentLineColor = color;
    }

    public Color getCurrentLineColor() {
        return currentLineColor;
    }

    public void setFillColor(Color color) {
        this.currentFillColor = color;
    }

    public Color getCurrentFillColor() {
        return currentFillColor;
    }

    public void clear() {
        shapes.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics obj) {
        super.paintComponent(obj);

        for (Shape shape : shapes) {
            shape.draw(obj);
        }
    }
}