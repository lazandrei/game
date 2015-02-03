package com.lazandrei19.game.helper;

import com.lazandrei19.game.player.Player2D;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by lazandrei19 on 2/3/2015.
 */
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
            String poss = br.readLine();
            System.out.println(poss);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void initPlatforms() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            br.readLine();
            String poss;
            while ((poss = br.readLine()) != null)
                System.out.println(poss);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
