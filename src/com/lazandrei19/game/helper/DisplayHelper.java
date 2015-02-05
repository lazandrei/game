package com.lazandrei19.game.helper;

import com.lazandrei19.game.util.Background;
import com.lazandrei19.game.util.Drawable;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Color;
import org.newdawn.slick.opengl.Texture;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class DisplayHelper {

    public static final int NUMBEROFBG = 5;
    static List<Drawable> drawables = new ArrayList<Drawable>();
    static List<Drawable> tbrm = new ArrayList<Drawable>();

    public static void appendDrawables(Drawable d) {
        drawables.add(d);
    }

    public static void removeDrawables(Drawable d) {
        tbrm.add(d);
    }

    public static void clear() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }

    public static void drawQuads(int x, int y, int w, int h, Color c) {
        GL11.glColor3ub(c.getRedByte(), c.getGreenByte(), c.getBlueByte());
        glBegin(GL_QUADS);
        glVertex2f(x, y);
        glVertex2f(x + w, y);
        glVertex2f(x + w, y + h);
        glVertex2f(x, y + h);
        glEnd();
    }

    public static void write(String s) {
        System.out.println(s);
    }

    public static void drawQuads(Drawable d) {
        double x = d.getX();
        double y = d.getY();
        int w = d.getW();
        int h = d.getH();
        Color c = d.getColor();
        Texture t = d.getTexture();

        if (t != null) {
            GL11.glColor3ub((byte) 255, (byte) 255, (byte) 255);
            GL11.glBindTexture(GL_TEXTURE_2D, t.getTextureID());
            GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0, 0);
            GL11.glVertex2d(x, y);
            GL11.glTexCoord2f(1, 0);
            GL11.glVertex2d(x + w, y);
            GL11.glTexCoord2f(1, 1);
            GL11.glVertex2d(x + w, y + h);
            GL11.glTexCoord2f(0, 1);
            GL11.glVertex2d(x, y + h);
            GL11.glEnd();

            glBindTexture(GL_TEXTURE_2D, 0);
        } else {
            GL11.glColor3ub(c.getRedByte(), c.getGreenByte(), c.getBlueByte());
            glBegin(GL_QUADS);
            glVertex2d(x, y);
            glVertex2d(x + w, y);
            glVertex2d(x + w, y + h);
            glVertex2d(x, y + h);
            glEnd();
        }
    }

    public static void drawBackground(Background d) {
        double x = d.getX();
        double y = d.getY();
        int w = d.getW();
        int h = d.getH();
        Color c = d.getColor();
        Texture t = d.getTexture();

        GL11.glColor3ub((byte) 255, (byte) 255, (byte) 255);
        GL11.glBindTexture(GL_TEXTURE_2D, t.getTextureID());

        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);

        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex2d(x, y);
        GL11.glTexCoord2f(NUMBEROFBG, 0);
        GL11.glVertex2d(x + w * NUMBEROFBG, y);
        GL11.glTexCoord2f(NUMBEROFBG, 1f);
        GL11.glVertex2d(x + w * NUMBEROFBG, y + h);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex2d(x, y + h);
        GL11.glEnd();

        glBindTexture(GL_TEXTURE_2D, 0);
    }

    public static void drawTriangle() {
        glBegin(GL_TRIANGLES);
        glColor3f(1f, 0f, 0f);
        glVertex2f(100, 25);
        glColor3f(0f, 1f, 0f);
        glVertex2f(70, 75);
        glColor3f(0f, 0f, 1f);
        glVertex2f(130, 75);
        glEnd();
    }

    public static void display() {
        for (Drawable d : drawables)
            drawQuads(d);
        for (Drawable d : tbrm)
            drawables.remove(d);
    }
}
