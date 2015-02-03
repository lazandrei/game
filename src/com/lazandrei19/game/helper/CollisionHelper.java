package com.lazandrei19.game.helper;

import com.lazandrei19.game.player.Player2D;
import com.lazandrei19.game.util.rigidbody.RigidBody;

import java.util.ArrayList;
import java.util.List;

public class CollisionHelper {
    static List<RigidBody> rigidBodies = new ArrayList<RigidBody>();

    public static void append(RigidBody r) {
        rigidBodies.add(r);
    }

    public static void checkCollisions(Player2D p) {
        for (RigidBody r : rigidBodies)
            r.checkColision(p);
    }
}
