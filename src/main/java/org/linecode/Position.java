package org.linecode;

public class Position {

    private int x, y;

    public Position() {}

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString(){
        return "(" + x + "," + y + ")";
    }

    @Override
    public boolean equals(Object x){
        if(x == null)
            return false;
        if(x.getClass() != this.getClass())
            return false;

        final Position cmp = (Position) x;
        return this.x == cmp.getX() && this.y == cmp.getY();
    }
}
