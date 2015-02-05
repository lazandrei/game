package com.lazandrei19.game.util.softbody;

import com.lazandrei19.game.player.Player2D;

public interface SoftBody {
    double getX();

    void setX(double x);

    double getY();

    void setY(double y);

    boolean checkCollision(Player2D p);
}
