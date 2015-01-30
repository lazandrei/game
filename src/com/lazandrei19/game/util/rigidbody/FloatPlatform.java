package com.lazandrei19.game.util.rigidbody;

import com.lazandrei19.game.player.Player2D;

public class FloatPlatform extends PlatformBody {
    public FloatPlatform(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    @Override
    public boolean checkColision(Player2D p) {
        int px = (int) p.getX(), py = (int) p.getY(), pw = p.getW(), ph = p.getH();
        pw += px;
        ph += py;
        if ((((px > x) && (px < (x + w))) || ((pw > x) && (pw < (w + x)))) && (((py > y) && (py < (y + h))) || ((ph > y) && (ph < (y + h))))) {
            p.setVelocity(p.getVXD(), p.getVX(), (byte) 0, 0d);
            p.onGround(true);
            p.moveTo(p.getX(), y - p.getH());

            return true;
        } else if ((y == ph) && (((x + w) < px) || ((px + p.getW()) < x))) p.onGround(false);
        return false;
    }
}
