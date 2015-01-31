package com.lazandrei19.game.util;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.Color;
import org.newdawn.slick.opengl.Texture;

public class Background implements Drawable {
    int x, y, w = Display.getWidth(), h = Display.getHeight();
    Texture t;

    @Override
    public double getX() {
        return 0;
    }

    @Override
    public double getY() {
        return 0;
    }

    @Override
    public int getW() {
        return w;
    }

    @Override
    public int getH() {
        return h;
    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public Texture getTexture() {
        return t;
    }
}
