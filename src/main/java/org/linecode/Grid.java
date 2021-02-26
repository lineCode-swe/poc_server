package org.linecode;


public class Grid {

    private final Cell[][] g ;
    private final int lenght, height;

    public Grid(int lenght, int height) {
        g = new Cell[lenght][height];
        this.lenght = lenght;
        this.height = height;
        for (int x = 0; x < lenght; ++x )
            for (int y = 0; y < height; ++y)
                g[x][y] = new Cell(x, y);
    }

    public int getLenght() {
        return lenght;
    }

    public int getHeight() {
        return height;
    }

    public Cell getCell(int x, int y) {
        return g[x][y];
    }

    /*
    public static void main(String[] args) {
        Grid prova = new Grid(3,20);
        for (int x = 0; x < prova.lenght; ++x ) {
            for (int y = 0; y < prova.height; ++y) {
                System.out.print("(" + prova.g[x][y].getX() +";"+ prova.g[x][y].getY() + ")" + " ");
            }
            System.out.println();
        }

    }*/
}
