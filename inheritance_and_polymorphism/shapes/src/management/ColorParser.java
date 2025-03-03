package management;

import java.awt.*;
import java.util.Arrays;

public class ColorParser {
    public static String getStringFromColor(Color color) {
        int[] colorArray = getArrayFromColor(color);
        int[] rgbArray = Arrays.copyOfRange(colorArray, 0, 3);
        String colorName = getColorName(rgbArray);

        switch (colorArray[3]) {
            case (0):
                return "Transparent " + colorName;
            case (255):
                return colorName;
            default:
                return String.format("red = %d, green = %d, blue = %d, alpha = %d", colorArray[0], colorArray[1], colorArray[2], colorArray[3]);
        }
    }

    private static String getColorName(int[] colorArray) {
        if (Arrays.equals(colorArray, new int[] {255, 255, 255})) {
            return "White";
        } else if (Arrays.equals(colorArray, new int[] {0, 0, 0})) {
            return "Black";
        } else if (Arrays.equals(colorArray, new int[] {128, 128, 128})) {
            return "Gray";
        } else if (Arrays.equals(colorArray, new int[] {255, 0, 0})) {
            return "Red";
        } else if (Arrays.equals(colorArray, new int[] {0, 0, 255})) {
            return "Blue";
        } else if (Arrays.equals(colorArray, new int[] {0, 255, 0})) {
            return "Green";
        } else if (Arrays.equals(colorArray, new int[] {255, 255, 0})) {
            return "Yellow";
        } else if (Arrays.equals(colorArray, new int[] {255, 0, 255})) {
            return "Magenta";
        } else if (Arrays.equals(colorArray, new int[] {136, 216, 192})) {
            return "Pearl Aqua";
        } else {
            return "Unknown";
        }
    }

    private static int[] getArrayFromColor(Color color) {
        int[] colorArray = new int[4];

        colorArray[0] = color.getRed();
        colorArray[1] = color.getGreen();
        colorArray[2] = color.getBlue();
        colorArray[3] = color.getAlpha();

        return colorArray;
    }
}
