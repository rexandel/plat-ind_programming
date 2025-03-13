import management.UserInteraction;

import shapes.Shape;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        UserInteraction ui = new UserInteraction(shapes);

        while (true) ui.inputMainChoice();
    }
}
