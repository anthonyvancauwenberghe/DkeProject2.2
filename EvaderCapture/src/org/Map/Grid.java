package org.Map;

import org.Map.Objects.Floor;

import java.util.Properties;

/**
 * Created by Tony on 17/06/2017.
 */
public class Grid {


    private int width;
    private int height;
    private GridObject[][] grid;

    public Grid() {
        this.width = 20;
        this.height = 20;
        this.initGrid();
    }

    public Grid(int width, int length) {
        this.width = width;
        this.height = length;
        this.initGrid();
    }

    public Grid(int squareSize) {
        this.width = squareSize;
        this.height = squareSize;
        this.initGrid();
    }

    private void initGrid() {
        this.grid = new GridObject[this.width][this.height];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Floor();
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public GridObject[][] getGridArray() {
        return grid;
    }

    public static Grid loadGrid(Properties p) {
        if (p == null) {
            return null;
        }
        int width = Integer.parseInt(p.getProperty("grid_width", "20"));
        int height = Integer.parseInt(p.getProperty("grid_height", "20"));
        Grid grid = new Grid(width, height);
        for (Object key : p.keySet()) {
            String k = key.toString();
            if (k.contains("[") && k.contains("]")) {
                int x = Integer.parseInt(k.substring(k.indexOf("[") + 1, k.indexOf("]")));
                int y = Integer.parseInt(k.substring(k.lastIndexOf("[") + 1, k.lastIndexOf("]")));
                GridObject obj = GridObject.getObjectFromString(p.getProperty(k, "FLOOR"));
                grid.getGridArray()[x][y] = obj;
            }
        }
        return grid;
    }

    public static Properties storeGrid(Grid grid) {
        Properties p = new Properties();
        GridObject[][] objects = grid.getGridArray();
        p.setProperty("grid_width", String.valueOf(grid.getWidth()));
        p.setProperty("grid_height", String.valueOf(grid.getHeight()));
        for (int x = 0; x < grid.getWidth(); x++) {
            for (int y = 0; y < grid.getHeight(); y++) {
                p.setProperty("[" + x + "][" + y + "]", objects[x][y].toString());
            }
        }
        return p;
    }
}
