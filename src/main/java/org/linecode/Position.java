package org.linecode;

public class Position {

    private int xo , yo;


    public Position(int xo, int yo) {
        this.xo = xo;
        this.yo = yo;
    }

    public Position() {

    }

    public int getXo() {
        return xo;
    }

    public int getYo() {
        return yo;
    }

    @Override
    public String toString(){
        return "(" + xo + "," + yo + ")";
    }
}
