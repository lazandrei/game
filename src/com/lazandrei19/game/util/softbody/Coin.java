package com.lazandrei19.game.util.softbody;

import com.lazandrei19.game.helper.CollectibleHelper;
import com.lazandrei19.game.helper.CollisionHelper;
import com.lazandrei19.game.helper.DisplayHelper;
import com.lazandrei19.game.player.Player2D;
import org.newdawn.slick.opengl.Texture;

public class Coin extends CollectibleBody {
    public Coin(double x, double y, Texture t) {
        super(15, 15, x, y, t);
    }

    @Override
    public boolean checkCollision(Player2D p) {
        boolean s = super.checkCollision(p);

        if (s) {
            CollectibleHelper.addCoins(1);
            CollisionHelper.remove(this);
            DisplayHelper.removeDrawables(this);
        }

        return s;
    }
}
