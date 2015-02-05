package com.lazandrei19.game.helper;

public class CollectibleHelper {
    static int coinsCollected = 0;

    public static void addCoins(int c) {
        coinsCollected += c;
    }

    public static void remCoins(int c) {
        coinsCollected -= c;
    }

    public static int getCoins() {
        return coinsCollected;
    }
}
