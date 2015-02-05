package com.lazandrei19.game.util.softbody;

import com.lazandrei19.game.player.Player2D;

public interface SoftBody {
    double getX();

    void setX(double x);

    double getY();

    void setY(double y);

    int getW();

    void setW(int w);

    int getH();

    void setH(int h);

    boolean checkCollision(Player2D p);
}
