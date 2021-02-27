package org.linecode;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Root resource (exposed at "unit" path)
 */
@Path("unit")
public class RestUnit {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Position> createProductInJSON(UnitInfo update) {
        List<Position> path = new ArrayList<Position>();

        for (Position p : update.getObstacle()) {
            Main.map.getCell(p).setObstacle(true);
            System.out.println("Rilevato ostacolo: " + p);
        }

        Main.map.setUnitGrid(update.getX(), update.getY());

        if(update.isPath()) {
            int distanza = getPath(Main.map, new Position(update.getX(), update.getY()), Main.map.getPoi(), path);
            System.out.println("La distanza dal POI è: " + distanza);
        }

        Main.map.setUnitGrid(update.getX(), update.getY());
        return path;
    }

    static int getPath(Grid map, Position start, Position end, List<Position> path) {
        int[][] distances = new int[map.getLength()][map.getHeight()];
        for (int i = 0; i < map.getLength(); ++i) {
            for (int j = 0; j < map.getHeight(); ++j){
                distances[i][j] = Integer.MAX_VALUE;
            }
        }

        int distance = 0;
        List<Position> currentCells = Arrays.asList(start);

        while (distances[end.getX()][end.getY()] == Integer.MAX_VALUE
                && !currentCells.isEmpty()) {
            List<Position> nextCells = new ArrayList<>();

            for (Position cell : currentCells) {
                if (distances[cell.getX()][cell.getY()] == Integer.MAX_VALUE
                        && !map.getCell(cell).isObstacle()
                        && (!map.getCell(cell).isUnit() || cell.equals(start))
                        && !map.getCell(cell).isLocked()) {
                    distances[cell.getX()][cell.getY()] = distance;
                    addNeighbors(cell, nextCells);
                }
            }

            currentCells = nextCells;
            ++distance;
        }

        if (distances[end.getX()][end.getY()] < Integer.MAX_VALUE) {
            Position cell = end;
            path.add(0,end);
            for (int d = distances[end.getX()][end.getY()]-1; d >= 0; d--) {
                cell = getNeighbor(cell, d, distances);
                path.add(0,cell);
            }
        }

        return distances[end.getX()][end.getY()];
    }

    static boolean isValid(int x, int y) {
        return (x >= 0) && (x < Main.map.getLength()) &&
                (y >= 0) && (y < Main.map.getHeight());
    }

    private static void addNeighbors(Position pos, List<Position> list) {
        int[][] ds = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d : ds) {
            int row = pos.getX() + d[0];
            int col = pos.getY() + d[1];
            if (isValid(row, col))
                list.add(new Position(row, col));
        }
    }

    private static Position getNeighbor(Position cell, int distance, int[][] distances) {
        int[][] ds = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] d : ds) {
            int row = cell.getX()+ d[0];
            int col = cell.getY() + d[1];
            if (isValid(row, col)
                    && distances[row][col] == distance)
                return new Position(row, col);
        }

        return null;
    }
}