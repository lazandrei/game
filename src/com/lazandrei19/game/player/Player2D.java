package com.lazandrei19.game.player;

import com.lazandrei19.game.helper.ColorHelper;
import com.lazandrei19.game.util.Drawable;
import com.lazandrei19.game.util.velocity.Velocity2D;
import org.lwjgl.util.Color;
import org.newdawn.slick.opengl.Texture;

public class Player2D extends Velocity2D implements Player, Drawable {
    int bboxx, bboxy;
    Color c = new Color(0, 0, 0);
    Texture t = null;

    public Player2D(int bboxx, int bboxy, Color c) {
        this.bboxx = bboxx;
        this.bboxy = bboxy;
        this.c = c;
    }

    public Player2D(int bboxx, int bboxy, String color) {
        this.bboxx = bboxx;
        this.bboxy = bboxy;
        this.c = ColorHelper.hexToColor(color);
    }

    public Player2D(int bboxx, int bboxy, Texture t) {
        this.bboxx = bboxx;
        this.bboxy = bboxy;
        this.t = t;
    }

    @Override
    public int getW() {
        return bboxx;
    }

    @Override
    public int getH() {
        return bboxy;
    }

    public Texture getTexture() {
        return t;
    }

    @Override
    public void setTexture(Texture t) {
        this.t = t;
    }

    public Color getColor() {
        return c;
    }

    public void setColor(Color c) {
        this.c = c;
    }

    public int getBboxx() {
        return bboxx;
    }

    public void setBboxx(int bboxx) {
        this.bboxx = bboxx;
    }

    public int getBboxy() {
        return bboxy;
    }

    public void setBboxy(int bboxy) {
        this.bboxy = bboxy;
    }

    @Override
    public void moveTo(double x, double y) {
        setX(x);
        setY(y);
    }
}
