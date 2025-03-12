package management;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

    public void inputMainChoice(ArrayList<Shape> shapes) {
        clearConsole();
        System.out.println("Choose an action: ");
        System.out.println(" 1) Create Shape");
        System.out.println(" 2) Delete Shape");
        System.out.println(" 3) Display information about all shapes");
        System.out.println(" 4) Restore an example of a list consisting of 20 shapes");
        System.out.println(" 5) Clear the list of shapes");
        System.out.println(" 6) Exit");
        System.out.println();

        System.out.print("Your choice: ");

        int choice = scanner.nextInt();
        if (choice == 1) {
            try {
                Shape newShape = inputChoiceCreateShape();
                try {
                    addIfUnique(shapes, newShape);
                    waitForKeyPress();
                }
                catch (Exception e) {
                    System.err.println("Error during adding a shape to the list: " + e.getMessage());
                    waitForKeyPress();
                }
            }
            catch (Exception e) {
                System.err.println("Error during shape creation: " + e.getMessage());
                waitForKeyPress();
            }
        }
        else if (choice == 2) {
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
            try {
                showAllShapes(shapes);
                waitForKeyPress();
            }
            catch (Exception e) {
                System.err.println("Error during showing all shapes: " + e.getMessage());
                waitForKeyPress();
            }
        }
        else if (choice == 4) {
            try {
                restoreExampleList(shapes);
                System.out.println("Example of list of shapes has been successfully restored.");
                waitForKeyPress();
            }
            catch (Exception e) {
                System.err.println("Error during restoring of example list: " + e.getMessage());
                waitForKeyPress();
            }
        }
        else if (choice == 5) {
            try {
                shapes.clear();
                System.out.println("List of shapes was cleared successfully.");
                waitForKeyPress();
            }
            catch (Exception e) {
                System.err.println("Error while clearing the list: " + e.getMessage());
            }
        }
        else if (choice == 6) {
            System.exit(0);
            System.out.println("You have chosen to exit the app.");
            waitForKeyPress();
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

    private Shape inputChoiceCreateShape() {
        clearConsole();
        System.out.println("Choose s shape to create: ");
        System.out.println(" 1) Circle");
        System.out.println(" 2) Rectangle");
        System.out.println(" 3) Line");
        System.out.println(" 4) Triangle");
        System.out.println(" 5) Go back to menu");
        System.out.println();

        System.out.print("Your choice: ");

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

    private void inputChoiceDeleteShape(ArrayList<Shape> shapes) {
        showAllShapes(shapes);

        if (!shapes.isEmpty()) {
            System.out.println();
            System.out.print("Input number of shape: ");

            int number = scanner.nextInt();

            if (number < 1) {
                throw new IndexOutOfBoundsException("Number cannot be less than one.");
            }
            if (number > shapes.size()) {
                throw new IndexOutOfBoundsException("The list element with the requested number does not exist.");
            }

            shapes.remove(number - 1);
        }
    }

    private void showAllShapes(ArrayList<Shape> shapes) {
        System.out.println("--- List of shapes ---");
        if (shapes.isEmpty()) {
            System.out.println("List of shapes is empty");
        }
        else {
            for (int index = 0; index < shapes.size(); index++) {
                System.out.println("Shape № " + (index + 1));
                System.out.println(shapes.get(index));
                System.out.println("------------------------");
            }
        }
    }

    private void restoreExampleList(ArrayList<Shape> shapes) {
        shapes.clear();

        Color redLine = new Color(255, 0, 0);
        Color blueLine = new Color(0, 0, 255);
        Color greenLine = new Color(0, 128, 0);
        Color magentaLine = new Color(255, 0, 255);
        Color yellowLine = new Color(255, 255, 0);
        Color orangeLine = new Color(255, 165, 0);
        Color cyanLine = new Color(0, 255, 255);

        Color redFill = new Color(255, 0, 0, 128);
        Color blueFill = new Color(0, 0, 255, 128);
        Color greenFill = new Color(0, 128, 0, 128);
        Color yellowFill = new Color(255, 255, 0, 128);
        Color pearlAquaFill = new Color(136, 216, 192, 128);
        Color pinkFill = new Color(255, 192, 203, 128);
        Color orangeFill = new Color(255, 165, 0, 128);

        Rectangle simpleRect = new Rectangle(new double[]{10, 10}, new double[]{110, 60});
        Rectangle redRect = new Rectangle(new double[]{50, 50}, new double[]{150, 150}, redLine);
        Rectangle blueRedRect = new Rectangle(new double[]{200, 100}, new double[]{250, 200}, blueLine, redFill);
        Rectangle greenBlueRect = new Rectangle(new double[]{300, 50}, new double[]{400, 100}, greenLine, blueFill);
        Rectangle magentaGreenRect = new Rectangle(new double[]{100, 300}, new double[]{300, 350}, magentaLine, greenFill);

        Triangle simpleTri = new Triangle(new double[]{50, 200}, new double[]{100, 300}, new double[]{0, 300});
        Triangle redTri = new Triangle(new double[]{150, 200}, new double[]{200, 100}, new double[]{250, 200}, redLine);
        Triangle blueYellowTri = new Triangle(new double[]{300, 200}, new double[]{350, 100}, new double[]{400, 200}, blueLine, yellowFill);
        Triangle greenPearlAquaTri = new Triangle(new double[]{450, 300}, new double[]{400, 200}, new double[]{500, 200}, greenLine, pearlAquaFill);
        Triangle yellowBlueTri = new Triangle(new double[]{100, 400}, new double[]{150, 350}, new double[]{200, 400}, yellowLine, blueFill);

        Circle simpleCircle = new Circle(new double[]{50, 450}, 30);
        Circle redCircle = new Circle(new double[]{150, 450}, 40, redLine);
        Circle blueYellowCircle = new Circle(new double[]{250, 450}, 50, blueLine, yellowFill);
        Circle greenRedCircle = new Circle(new double[]{350, 450}, 60, greenLine, redFill);
        Circle magentaPearlAquaCircle = new Circle(new double[]{450, 450}, 70, magentaLine, yellowFill);

        Line horizontalLine = new Line(new double[]{50, 550}, new double[]{250, 550});
        Line verticalLine = new Line(new double[]{300, 500}, new double[]{300, 700}, redLine);
        Line diagonalLine = new Line(new double[]{350, 500}, new double[]{450, 600}, blueLine);
        Line zigzagLine = new Line(new double[]{150, 600}, new double[]{250, 700}, greenLine);
        Line curvedLine = new Line(new double[]{400, 650}, new double[]{500, 750}, cyanLine);

        shapes.addAll(Arrays.asList(
                simpleRect, redRect, blueRedRect, greenBlueRect, magentaGreenRect,
                simpleTri, redTri, blueYellowTri, greenPearlAquaTri, yellowBlueTri,
                simpleCircle, redCircle, blueYellowCircle, greenRedCircle, magentaPearlAquaCircle,
                horizontalLine, verticalLine, diagonalLine, zigzagLine, curvedLine
        ));
    }

    private void addIfUnique(ArrayList<Shape> shapes, Shape shapeToAdd) {
        if (!shapes.contains(shapeToAdd)) {
            shapes.add(shapeToAdd);
            System.out.println("New shape has been added.");
        } else {
            System.out.println("Shape already exists in list.");
        }
    }

    private Circle createCircle() {
        while (true) {
            try {
                System.out.println("--- Creating circle ---");
                double[] initialPoint = inputPoint("initial point");
                Color lineColor = inputColor();
                double radius = inputRadius();

                return new Circle(initialPoint, radius, lineColor);
            }
            catch (IllegalArgumentException e) {
                System.err.println("Error while creating circle: " + e.getMessage());
                System.out.println(" 1) Try again");
                System.out.println(" 2) Go back to menu");
                System.out.println();
                System.out.print("Your choice: ");

                int choice = scanner.nextInt();
                if (choice == 2) {
                    return null;
                }
            }
        }
    }

    private Rectangle createRectangle() {
        while (true) {
            try {
                System.out.println("--- Creating rectangle ---");
                double[] initialPoint = inputPoint("initial point");
                double[] sidePoint = inputPoint("side point");
                Color lineColor = inputColor();

                return new Rectangle(initialPoint, sidePoint, lineColor);
            }
            catch (IllegalArgumentException e) {
                System.err.println("Error while creating rectangle: " + e.getMessage());
                System.out.println(" 1) Try again");
                System.out.println(" 2) Go back to menu");
                System.out.println();
                System.out.print("Your choice: ");

                int choice = scanner.nextInt();
                if (choice == 2) {
                    return null;
                }
            }
        }
    }

    private Line createLine() {
        while (true) {
            try {
                System.out.println("--- Creating line ---");
                double[] initialPoint = inputPoint("initial point");
                double[] sidePoint = inputPoint("side point");
                Color lineColor = inputColor();

                return new Line(initialPoint, sidePoint, lineColor);
            }
            catch (IllegalArgumentException e) {
                System.err.println("Error while creating line: " + e.getMessage());
                System.out.println(" 1) Try again");
                System.out.println(" 2) Go back to menu");
                System.out.println();
                System.out.print("Your choice: ");

                int choice = scanner.nextInt();
                if (choice == 2) {
                    return null;
                }
            }
        }
    }

    private Triangle createTriangle() {
        while (true) {
            try {
                System.out.println("--- Creating triangle ---");
                double[] initialPoint = inputPoint("initial point");
                double[] vertexPoint = inputPoint("vertex point");
                double[] sidePoint = inputPoint("side point");
                Color lineColor = inputColor();

                return new Triangle(initialPoint, vertexPoint, sidePoint, lineColor);
            }
            catch (IllegalArgumentException e) {
                System.err.println("Error while creating triangle: " + e.getMessage());
                System.out.println(" 1) Try again");
                System.out.println(" 2) Go back to menu");
                System.out.println();
                System.out.print("Your choice: ");

                int choice = scanner.nextInt();
                if (choice == 2) {
                    return null;
                }
            }
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
