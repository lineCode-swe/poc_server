package org.linecode;

public class Cell {

    private final int x;
    private final int y;
    private boolean locked = false;
    private boolean obstacle = false;
    private boolean unit = false;
    private boolean poi = false;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isObstacle() {
        return obstacle;
    }

    public void setObstacle(boolean obstacle) {
        this.obstacle = obstacle;
    }

    public boolean isUnit() {
        return unit;
    }

    public void setUnit(boolean unit) {
        this.unit = unit;
    }

    public boolean isPoi() {
        return poi;
    }

    public void setPoi(boolean poi) {
        this.poi = poi;
    }

    @Override
    public String toString() {
        return "{(" + x + "," + y + ") , Locked: " + locked + " , Obstacle : " + obstacle + " , Unit : " + unit + " , Poi " + poi + "}";
    }
}
