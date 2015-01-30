package com.lazandrei19.game.helper;

import org.lwjgl.util.Color;

public class ColorHelper {
    public static Color hexToColor(String hex) {
        hex = hex.replace("#", "");
        String red, green, blue;
        int r, g, b;

        red = hex.substring(0, 2);
        green = hex.substring(2, 4);
        blue = hex.substring(4, 6);

        r = Integer.parseInt(red, 16);
        g = Integer.parseInt(green, 16);
        b = Integer.parseInt(blue, 16);

        return new Color(r, g, b);
    }

    public static void addRed(Color c, byte b) {
        c.setRed(c.getRedByte() + b);
    }

    public static void addGreen(Color c, byte b) {
        c.setGreen(c.getGreenByte() + b);
    }

    public static void addBlue(Color c, byte b) {
        c.setBlue(c.getBlueByte() + b);
    }
}
