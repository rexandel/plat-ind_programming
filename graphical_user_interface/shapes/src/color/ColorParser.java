package color;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class ColorParser {
    private static final Map<RGBA, String> COLOR_NAMES = new HashMap<>();

    static {
        COLOR_NAMES.put(new RGBA(255, 255, 255), "White");
        COLOR_NAMES.put(new RGBA(0, 0, 0), "Black");
        COLOR_NAMES.put(new RGBA(128, 128, 128), "Gray");
        COLOR_NAMES.put(new RGBA(255, 0, 0), "Red");
        COLOR_NAMES.put(new RGBA(0, 0, 255), "Blue");
        COLOR_NAMES.put(new RGBA(0, 255, 0), "Green");
        COLOR_NAMES.put(new RGBA(255, 255, 0), "Yellow");
        COLOR_NAMES.put(new RGBA(255, 0, 255), "Magenta");
        COLOR_NAMES.put(new RGBA(238, 213, 183), "Beige");
        COLOR_NAMES.put(new RGBA(136, 216, 192), "Pearl Aqua");
    }

    public static Color getColorFromRGBA(RGBA rgba) {
        if (rgba == null) {
            throw new IllegalArgumentException("RGBA cannot be null.");
        }

        return new Color(rgba.getRed(), rgba.getGreen(), rgba.getBlue(), rgba.getAlpha());
    }

    public static RGBA getRGBAFromColor(Color color) {
        if (color == null) {
            throw new IllegalArgumentException("Color cannot be null.");
        }

        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
        int alpha = color.getAlpha();

        return new RGBA(red, green, blue, alpha);
    }

    public static String getStringFromRGBA(RGBA rgba) {
        if (rgba == null) {
            throw new IllegalArgumentException("RGBA cannot be null.");
        }

        String colorName = COLOR_NAMES.get(new RGBA(rgba.getRed(), rgba.getGreen(), rgba.getBlue()));

        if (colorName != null) {
            if (rgba.getAlpha() == 0) {
                return "Transparent " + colorName;
            }
            else if (rgba.getAlpha() < 255) {
                return String.format("%s (~%.0f%% opacity)", colorName, (rgba.getAlpha() / 255.0) * 100);
            }
            else {
                return colorName;
            }
        }
        else {
            return rgba.toString();
        }
    }
}
