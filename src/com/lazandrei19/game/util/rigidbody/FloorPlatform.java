package com.lazandrei19.game.util.rigidbody;

import com.lazandrei19.game.player.Player2D;

public class FloorPlatform extends PlatformBody {
    public FloorPlatform(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void translatef(float x, float y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public boolean checkColision(Player2D p) {
        int px = (int) p.getX(), py = (int) p.getY(), pw = p.getBboxx(), ph = p.getBboxy();
        pw += px;
        ph += py;

        if (((px > x && px < (x + w)) ||
                (pw > x && pw < (w + x))) &&
                ((py > y && py < (y + h)) ||
                        (ph > y && ph < (y + h)))) {
            if (px < x + 10) {
                p.moveTo(((int) (x - p.getW())), ((int) p.getY()));
                p.setVelocity((byte) 0, 0d, p.getVYD(), p.getVY());
            } else if (px > (x + w - 10)) {
                p.moveTo(((int) (x + w)), ((int) p.getY()));
                p.setVelocity((byte) 0, 0d, p.getVYD(), p.getVY());
            } else {
                p.moveTo(((int) p.getX()), (((int) (y - p.getH()))));
                p.setVelocity(p.getVXD(), p.getVX(), (byte) 0, 0d);
                p.onGround(true);
            }

            return true;
        } else if ((y == ph) && (((x + w) < px) || ((px + p.getW()) < x))) p.onGround(false);
        return false;
    }
}
