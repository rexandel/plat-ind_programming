package color;

import java.util.Objects;

public class RGBA {
    private int red;
    private int green;
    private int blue;
    private int alpha;

    public RGBA(int red, int green, int blue) {
        setRed(red);
        setGreen(green);
        setBlue(blue);
        setAlpha(255);
    }

    public RGBA(int red, int green, int blue, int alpha) {
        setRed(red);
        setGreen(green);
        setBlue(blue);
        setAlpha(alpha);
    }

    private void setRed(int red) {
        if (red > 255 || red < 0) {
            throw new IllegalArgumentException("The color range should be between 0 and 255.");
        }

        this.red = red;
    }

    private void setGreen(int green) {
        if (green > 255 || green < 0) {
            throw new IllegalArgumentException("The color range should be between 0 and 255.");
        }

        this.green = green;
    }

    private void setBlue(int blue) {
        if (blue > 255 || blue < 0) {
            throw new IllegalArgumentException("The color range should be between 0 and 255.");
        }

        this.blue = blue;
    }

    private void setAlpha(int alpha) {
        if (alpha > 255 || alpha < 0) {
            throw new IllegalArgumentException("The color range should be between 0 and 255.");
        }

        this.alpha = alpha;
    }

    @Override
    public String toString() {
        return "RGBA(" + getRed() + ", " + getGreen() + ", " + getBlue() + ", " + getAlpha() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RGBA rgba = (RGBA) o;
        return red == rgba.red && green == rgba.green && blue == rgba.blue && alpha == rgba.alpha;
    }

    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue, alpha);
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public int getAlpha() {
        return alpha;
    }
}
