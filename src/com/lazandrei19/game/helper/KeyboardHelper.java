package com.lazandrei19.game.helper;

import com.lazandrei19.game.player.Player2D;
import org.lwjgl.input.Keyboard;

public class KeyboardHelper {

    public static final byte NULL = 0, UP = -1, DOWN = 1, LEFT = -1, RIGHT = 1;
    public static final double MOVEMENT = 1.15;
    public static boolean wkp = false, akp = false, skp = false, dkp = false;

    public static void update(Player2D p) {
        while (Keyboard.next()) {
            switch (Keyboard.getEventKey()) {
                case Keyboard.KEY_D:
                    if (Keyboard.getEventKeyState()) dkp = true;
                    else dkp = false;
                    break;
                case Keyboard.KEY_A:
                    if (Keyboard.getEventKeyState()) akp = true;
                    else akp = false;
                    break;
                case Keyboard.KEY_S:
                    if (Keyboard.getEventKeyState()) skp = true;
                    else skp = false;
                    break;
                case Keyboard.KEY_W:
                    if (Keyboard.getEventKeyState()) wkp = true;
                    else wkp = false;
                    break;
                case Keyboard.KEY_SPACE:
                    if (Keyboard.getEventKeyState()) wkp = true;
                    else wkp = false;
                    break;
            }

        }
        if (dkp) p.addVelocity(RIGHT, MOVEMENT, NULL, 0d);
        if (akp) p.addVelocity(LEFT, MOVEMENT, NULL, 0d);
        if (skp) p.addVelocity(NULL, 0d, DOWN, MOVEMENT);
        if (wkp) {
            p.setY(((int) p.getY() - 1));
            p.addVelocity(NULL, 0d, UP, MOVEMENT);
            p.onGround(false);
        }
        if (!Keyboard.getEventKeyState()) p.setVelocity(NULL, 0, NULL, 0);
    }
}
