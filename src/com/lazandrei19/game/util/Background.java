package com.lazandrei19.game.util;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;

public class Background implements Drawable {
    int x, y, w = Display.getWidth(), h = Display.getHeight();
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
