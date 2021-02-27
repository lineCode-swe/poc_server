package org.linecode;


public class Grid {

    private final Cell[][] g;
    private final int length, height;

    private int unitx = 0, unity = 0;
    private int poix = 0, poiy = 0;

    public Grid(int lenght, int height) {
        g = new Cell[lenght][height];
        this.length = lenght;
        this.height = height;
        for (int x = 0; x < lenght; ++x )
            for (int y = 0; y < height; ++y)
                g[x][y] = new Cell(x, y);
        g[unitx][unity].setUnit(true);
        g[poix][poiy].setPoi(true);
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public Cell getCell(int x, int y) {
        return g[x][y];
    }

    public Cell getCell(Position p) {
        return g[p.getX()][p.getY()];
    }

    public void setUnitGrid(int unitx, int unity) {
        g[this.unitx][this.unity].setUnit(false);
        this.unitx = unitx;
        this.unity = unity;
        g[this.unitx][this.unity].setUnit(true);
    }

    public Position getPoi() {
        return new Position(poix, poiy);
    }

    public void setPoiGrid(int poix, int poiy) {
        g[this.poix][this.poiy].setPoi(false);
        this.poix = poix;
        this.poiy = poiy;
        g[this.poix][this.poiy].setPoi(true);
    }
}
