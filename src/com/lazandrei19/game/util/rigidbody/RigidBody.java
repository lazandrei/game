package com.lazandrei19.game.util.rigidbody;

import com.lazandrei19.game.player.Player2D;

public interface RigidBody {
    void setPosition(int x, int y);

    void setDimensions(int w, int h);

    boolean checkColision(Player2D p);
}
