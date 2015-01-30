package com.lazandrei19.game.util.rigidbody;

import com.lazandrei19.game.player.Player2D;
import com.lazandrei19.game.util.Drawable;
import org.lwjgl.util.Color;
import org.newdawn.slick.opengl.Texture;

public abstract class PlatformBody implements RigidBody, Drawable {
    double x, y, w, h;

    public PlatformBody(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void setDimensions(int w, int h) {
        this.w = w;
        this.h = h;
    }

    @Override
    public Texture getTexture() {
        return null;
    }

    @Override
    public boolean checkColision(Player2D p) {
        int px = (int) p.getX(), py = (int) p.getY(), pw = p.getW(), ph = p.getH();
        pw += px;
        ph += py;
        if ((((px > x) && (px < (x + w))) ||
                ((pw > x) && (pw < (w + x)))) &&
                (((py > y) && (py < (y + h))) ||
                        ((ph > y) && (ph < (y + h))))) {
            int hy = (int) (y + h / 2);
            if (px < x + 10) {
                p.moveTo(((int) (x - p.getW())), ((int) p.getY()));
                p.setVelocity((byte) 0, 0d, p.getVYD(), p.getVY());
            } else if (px > (x + w - 10)) {
                p.moveTo(((int) (x + w)), ((int) p.getY()));
                p.setVelocity((byte) 0, 0d, p.getVYD(), p.getVY());
            } else if (py < hy) {
                p.moveTo(((int) p.getX()), (((int) (y - p.getH()))));
                p.setVelocity(p.getVXD(), p.getVX(), (byte) 0, 0d);
                p.onGround(true);
            } else {
                p.moveTo(((int) p.getX()), ((int) (y + h)));
                p.setVelocity(p.getVXD(), p.getVX(), (byte) 0, 0d);
            }
            return true;
        } else if ((y == ph) && (((x + w) < px) || ((px + p.getW()) < x))) p.onGround(false);
        return false;
    }

    @Override
    public Color getColor() {
        return new Color(0, 127, 255);
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public int getW() {
        return (int) w;
    }

    @Override
    public int getH() {
        return (int) h;
    }
}
