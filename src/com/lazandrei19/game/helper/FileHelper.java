package com.lazandrei19.game.helper;

import java.io.File;

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

}
