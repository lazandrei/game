package com.lazandrei19.game.helper;

import org.newdawn.slick.TrueTypeFont;

import java.awt.*;

/**
 * Created by lazandrei19 on 2/5/2015.
 */
public class TextHelper {

    public static void writeToConsole(String s) {
        System.out.println(s);
    }

    public static void showTime(long stime, float x, float y) {
        TrueTypeFont timeFont = new TrueTypeFont(new Font("Times New Roman", Font.PLAIN, 24), true);
        timeFont.drawString(x, y, String.valueOf((System.currentTimeMillis() - stime) / 1000f));
    }
}
