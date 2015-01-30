package com.lazandrei19.game.player;

import org.lwjgl.util.Color;
import org.newdawn.slick.opengl.Texture;


public interface Player {
    void moveTo(double x, double y);

    int getBboxx();

    int getBboxy();

    Color getColor();

    void setColor(Color c);

    Texture getTexture();

    void setTexture(Texture t);

}
