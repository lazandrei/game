package com.lazandrei19.game;

import com.lazandrei19.game.helper.DisplayHelper;
import com.lazandrei19.game.helper.FileHelper;
import com.lazandrei19.game.helper.KeyboardHelper;
import com.lazandrei19.game.helper.MouseHelper;
import com.lazandrei19.game.player.Player2D;
import com.lazandrei19.game.util.Background;
import com.lazandrei19.game.util.rigidbody.FloatPlatform;
import com.lazandrei19.game.util.rigidbody.FloorPlatform;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;

public class Main {
    public static float cdx = 0;
    final float CAMERA_MOVEMENT = 0.75f;
    long time = System.currentTimeMillis();
    Player2D p;
    FloorPlatform pb;
    FloatPlatform p1;
    Background bg;

    Texture texture;

    public static void main(String[] args) {
        Main m = new Main();
        m.start();

    }

    public void init() throws IOException {

        //SET DISPLAY
        try {
            Display.setDisplayMode(new DisplayMode(800, 600));
            Display.create();
            Display.setVSyncEnabled(true);
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }

        //MISC DISPLAY STUFF
        GL11.glEnable(GL11.GL_TEXTURE_2D);

        GL11.glClearColor(0f, 0f, 0f, 1f);
        GL11.glOrtho(0, 800, 600, 0, 1, -1);

        //LOAD TEXTURE
        texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/tex/tex.png"));

        //INIT FILE HELPER
        FileHelper fh = new FileHelper("0-0");

        //INIT DRAWABLES
        pb = new FloorPlatform(0, Display.getHeight() - 5, Display.getWidth() + 10, 10);
        p = new Player2D(25, 25, texture);
        bg = new Background();

        //MOVE PLAYER
        fh.movePlayer(p);
        fh.initPlatforms();

        //APPEND DRAWABLES
        DisplayHelper.appendDrawables(pb);
    }

    public void start() {

        //Running Init
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //GAME LOOP
        while (!Display.isCloseRequested()) {

            //START SCROLLING
            if (System.currentTimeMillis() - time > 2500) {
                GL11.glTranslatef(-CAMERA_MOVEMENT, 0, 0);
                pb.translatef(CAMERA_MOVEMENT, 0f);
                cdx += CAMERA_MOVEMENT;
            }

            //START DRAWING FRAME
            DisplayHelper.clear();

            //UPDATE STUFF
            MouseHelper.update(p);
            KeyboardHelper.update(p);
            p.updatePosition(CAMERA_MOVEMENT);

            //CHECK COLLISIONS
            pb.checkColision(p);
//            p1.checkColision(p);

            //DRAW
            DisplayHelper.drawBackground(bg);
            DisplayHelper.drawTriangle();
            DisplayHelper.drawQuads(p);
            DisplayHelper.display();

            //UPDATE
            Display.update();
        }

        //CLOSE
        Display.destroy();
    }
}
