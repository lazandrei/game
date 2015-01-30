package com.lazandrei19.game.util.position;


public class Position2D implements Position {
    double x = 0, y = 0;

    @Override
    public String toString() {
        return "(" + x +
                ", " + y +
                ')';

    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }
}
