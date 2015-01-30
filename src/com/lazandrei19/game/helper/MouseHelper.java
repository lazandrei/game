package com.lazandrei19.game.helper;


import com.lazandrei19.game.Main;
import com.lazandrei19.game.player.Player2D;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class MouseHelper {
    static int mlcbtp = 0;

    public static int getY() {
        return Display.getHeight() - Mouse.getY() - 1;
    }

    public static int getX() {
        return Mouse.getX() + ((int) Main.cdx);
    }

    public static void update(Player2D p) {
        if (Mouse.isButtonDown(0) && mlcbtp == 0) {
            mlcbtp = 1;
            p.moveTo(MouseHelper.getX(), MouseHelper.getY());
            p.onGround(false);
        } else mlcbtp = 0;
    }
}
