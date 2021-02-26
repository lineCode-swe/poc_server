package org.linecode;

import java.util.List;
import java.util.ArrayList;

public class UnitInfo {

    private  int x , y ;
    private boolean path;
    List<Position> obstacle = new ArrayList<Position>(8);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isPath() {
        return path;
    }

    public List<Position> getObstacle() {
        return obstacle;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ") ;" + " path = " + path + " " +  obstacle.toString();
    }


}
