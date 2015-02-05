package com.lazandrei19.game.util.softbody;

import com.lazandrei19.game.player.Player2D;
import com.lazandrei19.game.util.Drawable;
import org.lwjgl.util.Color;
import org.newdawn.slick.opengl.Texture;

public abstract class CollectibleBody implements SoftBody, Drawable {
    int w, h;
    double x, y;
    Texture t;

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

    @Override
    public double getX() {
        return x;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean checkCollision(Player2D p) {
        int px = (int) p.getX(), py = (int) p.getY(), pw = p.getW(), ph = p.getH();
        pw += px;
        ph += py;
        if ((((px > x) && (px < (x + w))) || ((pw > x) && (pw < (w + x)))) &&
                (((py > y) && (py < (y + h))) || ((ph > y) && (ph < (y + h))))) {
            return true;
        }
        return false;
    }
}
