package com.lazandrei19.game.util;

import org.lwjgl.util.Color;
import org.newdawn.slick.opengl.Texture;

public interface Drawable {
    double getX();

    double getY();

    int getW();

    int getH();

    Color getColor();

    Texture getTexture();
}
