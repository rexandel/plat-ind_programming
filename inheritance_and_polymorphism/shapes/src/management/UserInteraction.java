package management;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import color.ColorParser;
import color.RGBA;
import shapes.Shape;
import shapes.Circle;
import shapes.Rectangle;
import shapes.Line;
import shapes.Triangle;

public class UserInteraction {
    private Scanner scanner;

    public UserInteraction() {
        scanner = new Scanner(System.in);
    }

    public void outputMainMenu() {
        clearConsole();
        System.out.println("Choose an action: ");
        System.out.println(" 1) Create Shape");
        System.out.println(" 2) Delete Shape");
        System.out.println(" 3) Display information about all shapes");
        System.out.println(" 4) Fill array with 10 random shapes");
        System.out.println(" 5) Exit");
        System.out.println();

        System.out.print("Your choice: ");
    }

    public void inputMainChoice(ArrayList<Shape> shapes) {
        int choice = scanner.nextInt();
        if (choice == 1) {
            outputMenuCreateShape();

            try {
                Shape newShape = inputChoiceCreateShape();
                if (newShape != null) {
                    shapes.add(newShape);
                    waitForKeyPress();
                }
                else {
                    outputMainMenu();
                }
            }
            catch (Exception e) {
                System.err.println("Error during shape creation: " + e.getMessage());
                waitForKeyPress();
            }
        }
        else if (choice == 2) {
            outputMenuDeleteShape(shapes);

            try {
                if (shapes.isEmpty()) {
                    waitForKeyPress();
                }
                else {
                    inputChoiceDeleteShape(shapes);
                    System.out.println("Shape was successfully deleted.");
                    waitForKeyPress();
                }
            }
            catch (Exception e) {
                System.err.println("Error during shape deletion: " + e.getMessage());
                waitForKeyPress();
            }
        }
        else if (choice == 3) {
            outputAllShapes(shapes);
            waitForKeyPress();
        }
        else if (choice == 4) {
            // To be added later
        }
        else if (choice == 5) {
            System.exit(0);
        }
        else {
            System.out.println("Incorrect choice.");
            waitForKeyPress();
        }
    }

    private double[] inputPoint(String pointName) {
        System.out.println("Enter the coordinates of the " + pointName + ": ");

        System.out.print(" Enter the x-axis coordinate (use a comma for the real value): ");
        double x = scanner.nextDouble();
        System.out.print(" Enter the y-axis coordinate (use a comma for the real value): ");
        double y = scanner.nextDouble();
        return new double[]{x, y};
    }

    private double inputRadius() {
        System.out.print("Enter the radius of the circle: ");

        double radius = scanner.nextDouble();
        return radius;
    }

    private RGBA inputRGBA() {
        System.out.print("Enter the color in RGBA format (red, green, blue, alpha): ");

        int red = scanner.nextInt();
        int green = scanner.nextInt();
        int blue = scanner.nextInt();
        int alpha = scanner.nextInt();
        return new RGBA(red, green, blue, alpha);
    }

    private RGBA chooseRGBA() {
        System.out.println("Choose a color from the suggested ones:");
        System.out.println(" 1) White");
        System.out.println(" 2) Black");
        System.out.println(" 3) Gray");
        System.out.println(" 4) Red");
        System.out.println(" 5) Blue");
        System.out.println(" 6) Green");
        System.out.println(" 7) Yellow");
        System.out.println(" 8) Magenta");
        System.out.println(" 9) Pearl Aqua");
        System.out.println(" 10) Beige");
        System.out.print("Your choice: ");

        int choice = scanner.nextInt();
        switch (choice) {
            case (1):
                return new RGBA(255, 255, 255);
            case (2):
                return new RGBA(0, 0, 0);
            case (3):
                return new RGBA(128, 128, 128);
            case (4):
                return new RGBA(255, 0, 0);
            case (5):
                return new RGBA(0, 0, 255);
            case (6):
                return new RGBA(0, 255, 0);
            case (7):
                return new RGBA(255, 255, 0);
            case (8):
                return new RGBA(255, 0, 255);
            case (9):
                return new RGBA(136, 216, 192, 255);
            default:
                return new RGBA(0, 0, 0);
        }
    }

    private Color inputColor() {
        System.out.println("Choose a color input method:");
        System.out.println(" 1) Ready-made color");
        System.out.println(" 2) Enter color in RGBA format");
        System.out.println(" 3) Default color (Black)");
        System.out.print("Your choice: ");

        int choose = scanner.nextInt();
        if (choose == 1) {
            RGBA rgba = chooseRGBA();
            return ColorParser.getColorFromRGBA(rgba);
        }
        else if (choose == 2) {
            RGBA rgba =  inputRGBA();
            return ColorParser.getColorFromRGBA(rgba);
        }
        else {
            return Color.black;
        }
    }

    private void outputMenuCreateShape() {
        clearConsole();
        System.out.println("Choose s shape to create: ");
        System.out.println(" 1) Circle");
        System.out.println(" 2) Rectangle");
        System.out.println(" 3) Line");
        System.out.println(" 4) Triangle");
        System.out.println(" 5) Go back to menu");
        System.out.println();

        System.out.print("Your choice: ");
    }

    private Shape inputChoiceCreateShape() {
        int choice = scanner.nextInt();

        switch (choice) {
            case (1):
                return createCircle();
            case (2):
                return createRectangle();
            case (3):
                return createLine();
            case (4):
                return createTriangle();
            default:
                return null;
        }
    }

    private void outputMenuDeleteShape(ArrayList<Shape> shapes) {
        outputAllShapes(shapes);

        if (!shapes.isEmpty()) {
            System.out.println();
            System.out.print("Input number of shape: ");
        }
    }

    private void inputChoiceDeleteShape(ArrayList<Shape> shapes) {
        int number = scanner.nextInt();

        if (number < 1) {
            throw new IndexOutOfBoundsException("Number cannot be less than one.");
        }
        if (number > shapes.size()) {
            throw new IndexOutOfBoundsException("The array element with the requested number does not exist.");
        }

        shapes.remove(number - 1);
    }

    private void outputAllShapes(ArrayList<Shape> shapes) {
        System.out.println("--- List of shapes ---");
        if (shapes.isEmpty()) {
            System.out.println("List of shapes is empty");
        }

        for (int index = 0; index < shapes.size(); index++) {
            System.out.println("Shape №" + (index + 1));
            System.out.println(shapes.get(index));
        }
    }

    private Circle createCircle() {
        System.out.println("--- Creating circle ---");
        double[] initialPoint = inputPoint("initial point");
        Color lineColor = inputColor();
        double radius = inputRadius();

        try {
            return new Circle(initialPoint, radius, lineColor);
        }
        catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    private Rectangle createRectangle() {
        System.out.println("--- Creating rectangle ---");
        double[] initialPoint = inputPoint("initial point");
        double[] sidePoint = inputPoint("side point");
        Color lineColor = inputColor();

        try {
            return new Rectangle(initialPoint, sidePoint, lineColor);
        }
        catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    private Line createLine() {
        System.out.println("--- Creating line ---");
        double[] initialPoint = inputPoint("initial point");
        double[] sidePoint = inputPoint("side point");
        Color lineColor = inputColor();

        try {
            return new Line(initialPoint, sidePoint, lineColor);
        }
        catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    private Triangle createTriangle() {
        System.out.println("--- Creating triangle ---");
        double[] initialPoint = inputPoint("initial point");
        double[] vertexPoint = inputPoint("vertex point");
        double[] sidePoint = inputPoint("side point");
        Color lineColor = inputColor();

        try {
            return new Triangle(initialPoint, vertexPoint, sidePoint, lineColor);
        }
        catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    private static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch (IOException | InterruptedException e) {
            System.out.println("Failed to clear console: " + e.getMessage());
        }
    }

    private void waitForKeyPress() {
        System.out.print("Press any key to continue...");
        scanner.nextLine();
        scanner.nextLine();
    }
}
