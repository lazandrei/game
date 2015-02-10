package com.lazandrei19.game.helper;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

import java.awt.*;

public class TextHelper {

    static UnicodeFont font = new UnicodeFont(new Font("Times New Roman", Font.PLAIN, 24));



    public static void writeToConsole(String s) {
        System.out.println(s);
    }

    public static void showCenteredText(String text, float x, float y, int pos, int end) {
        font.getEffects().add(new ColorEffect(java.awt.Color.white));
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        font.addAsciiGlyphs();
        try {
            font.loadGlyphs();
        } catch (Exception e) {
            e.printStackTrace();
        }
        font.drawString(x, y, text);
    }
    public static void showTime(long stime, float x, float y) {
        font.getEffects().add(new ColorEffect(java.awt.Color.white));
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        font.addAsciiGlyphs();
        try {
            font.loadGlyphs();
        } catch (Exception e) {
            e.printStackTrace();
        }
        font.drawString(x, y, String.valueOf((System.currentTimeMillis() - stime) / 1000f));
    }
}
