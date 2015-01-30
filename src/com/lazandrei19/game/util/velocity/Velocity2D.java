package com.lazandrei19.game.util.velocity;

import com.lazandrei19.game.util.position.Position2D;

public class Velocity2D extends Position2D implements Velocity {
    final double MAXX = 2d, MAXY = 2d;
    byte vxd = 0, vyd = 0;
    double vx = 0, vy = 0;
    boolean onGround = false;

    @Override
    public void onGround(boolean b) {
        onGround = b;
    }

    @Override
    public byte getVXD() {
        return vxd;
    }

    @Override
    public void setVXD(byte vxd) {
        this.vxd = vxd;
    }

    @Override
    public byte getVYD() {
        return vyd;
    }

    @Override
    public void setVYD(byte vyd) {
        this.vyd = vyd;
    }

    @Override
    public void setVelocity(byte vxd, double vx, byte vyd, double vy) {
        this.vx = vx;
        this.vxd = vxd;
        this.vy = vy;
        this.vyd = vyd;
    }

    @Override
    public void addVelocity(byte vxd, double vx, byte vyd, double vy) {
        if (this.vxd + vxd == 0) {
            this.vx -= vx;
            if (this.vx < 0) {
                this.vx *= -1;
                this.vxd *= -1;
            }
        } else {
            this.vx += vx;
            this.vxd += vxd;
        }
        if (this.vyd + vyd == 0) {
            this.vy -= vy;
            if (this.vy < 0) {
                this.vy *= -1;
                this.vyd *= -1;
            }
        } else {
            this.vy += vy;
            this.vyd += vyd;
        }
        if (this.vxd > 1) vxd = 1;
        else if (this.vxd < -1) vxd = -1;
        if (this.vyd > 1) vyd = 1;
        else if (this.vyd < -1) vyd = -1;
    }

    @Override
    public double getVX() {
        return vx;
    }

    @Override
    public void setVX(double vx) {
        this.vx = vx;
    }

    @Override
    public double getVY() {
        return vy;
    }

    @Override
    public void setVY(double vy) {
        this.vy = vy;
    }

    @Override
    public void updateVelocity(float density) {
        if (vx > MAXX) vx = MAXX;
        if (vy > MAXY) vy = MAXY;
        this.vx -= density / 10f;
        this.vy -= density / 10f;
        if (vx < 0) {
            vx = 0;
            vxd = 0;
        }
        if (vy < 0) {
            vy = 0;
            vyd = 0;
        }
    }

    @Override
    public void updatePosition(float density) {
        updateVelocity(density);
        setX((int) (getX() + (vx / 4) * vxd));
        setY((int) (getY() + (vy / 4) * vyd));
        if (!onGround) {
            setY(getY() + 4);
        }
    }

}
