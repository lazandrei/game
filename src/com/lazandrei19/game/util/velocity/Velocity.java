package com.lazandrei19.game.util.velocity;

public interface Velocity {
    double getVX();

    void setVX(double vx);

    double getVY();

    void setVY(double vy);

    void onGround(boolean b);

    byte getVXD();

    void setVXD(byte vxd);

    byte getVYD();

    void setVYD(byte vyd);

    void setVelocity(byte vxd, double vx, byte vyd, double vy);

    void addVelocity(byte vxd, double vx, byte vyd, double vy);

    void updateVelocity(float density);

    void updatePosition(float density);
}
