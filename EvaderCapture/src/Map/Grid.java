package Map;

import Map.Objects.Floor;

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
}
