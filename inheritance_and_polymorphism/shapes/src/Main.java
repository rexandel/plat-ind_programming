import management.UserInteraction;

import shapes.Shape;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        UserInteraction ui = new UserInteraction();
        ArrayList<Shape> shapes = new ArrayList<Shape>();

        while (true) ui.inputMainChoice(shapes);
    }
}
