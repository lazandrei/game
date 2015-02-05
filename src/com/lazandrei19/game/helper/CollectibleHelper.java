package com.lazandrei19.game.helper;

public class CollectibleHelper {
    static int coinsCollected = 0;

    public void addCoins(int c) {
        coinsCollected += c;
    }

    public void remCoins(int c) {
        coinsCollected -= c;
    }

    public int getCoins() {
        return coinsCollected;
    }
}
