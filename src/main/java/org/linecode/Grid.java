package org.linecode;

public class Grid {

    Cell[][] g = null;

    Grid(int height, int length) {
        g = new Cell[height][length];

        for (int x : g)
            for (int y : g[x])
                g[x][y] = new Cell(x, y);
    }
}
