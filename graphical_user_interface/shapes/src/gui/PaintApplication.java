package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PaintApplication extends JFrame {
    private PaintPanel paintPanel;
    private JLabel statusLabel;

    public PaintApplication() {
        setTitle("Graphic Editor (LW4)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Creating components
        paintPanel = new PaintPanel();
        statusLabel = new JLabel("Selected shape: " + paintPanel.getCurrentShapeType(), JLabel.CENTER);

        // Buttons for selecting shapes
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        ArrayList<JButton> buttons = new ArrayList<>();

        JButton circleButton = new JButton("Circle");
        JButton rectangleButton = new JButton("Rectangle");
        JButton triangleButton = new JButton("Triangle");
        JButton lineButton = new JButton("Line");

        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintPanel.setShapeType(PaintPanel.CIRCLE);
                statusLabel.setText("Selected shape: " + PaintPanel.CIRCLE);
            }
        });

        rectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintPanel.setShapeType(PaintPanel.RECTANGLE);
                statusLabel.setText("Selected shape: " + PaintPanel.RECTANGLE);
            }
        });

        triangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintPanel.setShapeType(PaintPanel.TRIANGLE);
                statusLabel.setText("Selected shape: " + PaintPanel.TRIANGLE);
            }
        });

        lineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintPanel.setShapeType(PaintPanel.LINE);
                statusLabel.setText("Selected shape: " + PaintPanel.LINE);
            }
        });

        buttons.add(circleButton);
        buttons.add(rectangleButton);
        buttons.add(triangleButton);
        buttons.add(lineButton);

        // Clear button
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintPanel.clear();
            }
        });
        buttons.add(clearButton);

        // Choose color buttons
        JButton lineColorButton = new JButton("Choose line color");
        lineColorButton.addActionListener(new ActionListener() {
                                          @Override
                                          public void actionPerformed(ActionEvent e) {
                                              Color newLineColor = JColorChooser.showDialog(
                                                      PaintApplication.this,
                                                      "Choose line color",
                                                      paintPanel.getCurrentLineColor()
                                              );
                                              if (newLineColor != null) {
                                                  paintPanel.setLineColor(newLineColor);
                                              }
                                          }
                                      });
        buttons.add(lineColorButton);

        JButton fillColorButton = new JButton("Choose fill color");
        fillColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newFillColor = JColorChooser.showDialog(
                        PaintApplication.this,
                        "Choose fill color",
                        paintPanel.getCurrentFillColor()
                );
                if (newFillColor != null) {
                    paintPanel.setFillColor(newFillColor);
                }
            }
        });
        buttons.add(fillColorButton);

        for (JButton button : buttons) {
            buttonPanel.add(button);
        }

        // Adding components to the frame using BorderLayout
        add(buttonPanel, BorderLayout.NORTH);
        add(statusLabel, BorderLayout.SOUTH);
        add(paintPanel, BorderLayout.CENTER);
        setVisible(true);
    }
}