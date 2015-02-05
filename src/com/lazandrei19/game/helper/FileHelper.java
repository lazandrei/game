package com.lazandrei19.game.helper;

import com.lazandrei19.game.player.Player2D;
import com.lazandrei19.game.util.rigidbody.FloatPlatform;
import com.lazandrei19.game.util.softbody.Coin;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileHelper {
    double x, y;
    int w, h;
    String level;
    File f;

    public FileHelper(String level) {
        this.level = level;
        f = new File("res/levels/" + level + "/Platforms");
    }

    public void movePlayer(Player2D p) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String pos = br.readLine();
            String[] poss = pos.split(" ");
            System.out.println(poss[0] + "/" + poss[1]);
            x = Double.parseDouble(poss[0]);
            y = Double.parseDouble(poss[1]);
            p.moveTo(x, y);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void initPlatforms() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            br.readLine();
            String pos;
            while ((pos = br.readLine()) != null) {
                String[] poss = pos.split(" ");
                x = Double.parseDouble(poss[0]);
                y = Double.parseDouble(poss[1]);
                w = Integer.parseInt(poss[2]);
                h = Integer.parseInt(poss[3]);
                String type = poss[4];
                switch (type) {
                    case "FloatPlatform":
                        FloatPlatform p = new FloatPlatform(x, y, w, h);
                        DisplayHelper.appendDrawables(p);
                        CollisionHelper.append(p);
                        break;
                    case "Coin":
                        Coin c = new Coin(x, y, TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/tex/pht32x.png")));
                        DisplayHelper.appendDrawables(c);
                        CollisionHelper.append(c);
                        break;
                    default:
                        break;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
