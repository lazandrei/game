package com.lazandrei19.game.util;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;

public class Background implements Drawable {
    double x = 0, y = 0;
    int w = Display.getWidth(), h = Display.getHeight();
    Color c = new Color(33, 55, 77);
    Texture t;

    public Background() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void init() throws IOException {
        t = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/tex/pht1024.png"));
    }

    @Override
    public double getX() {
        return 3;
    }

    @Override
    public double getY() {
        return 2;
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
        return c;
    }

    @Override
    public Texture getTexture() {
        return t;
    }
}
