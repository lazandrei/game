package com.lazandrei19.game.helper;

import com.lazandrei19.game.player.Player2D;
import com.lazandrei19.game.util.rigidbody.RigidBody;
import com.lazandrei19.game.util.softbody.SoftBody;

import java.util.ArrayList;
import java.util.List;

public class CollisionHelper {
    static List<RigidBody> rigidBodies = new ArrayList<RigidBody>();
    static List<RigidBody> tbrmr = new ArrayList<RigidBody>();
    static List<SoftBody> softBodies = new ArrayList<SoftBody>();
    static List<SoftBody> tbrms = new ArrayList<SoftBody>();

    public static void append(RigidBody r) {
        rigidBodies.add(r);
    }

    public static void remove(RigidBody r) {
        tbrmr.add(r);
    }

    public static void append(SoftBody s) {
        softBodies.add(s);
    }

    public static void remove(SoftBody s) {
        tbrms.add(s);
    }

    public static void checkCollisions(Player2D p) {
        for (RigidBody r : rigidBodies)
            r.checkColision(p);
        for (RigidBody r : tbrmr)
            rigidBodies.remove(r);
        for (SoftBody s : softBodies)
            s.checkCollision(p);
        for (SoftBody s : tbrms)
            softBodies.remove(s);
    }
}
