package Map;

import Map.Objects.Floor;

/**
 * Created by Tony on 17/06/2017.
 */
public class Grid {


    private final int width = 20;
    private final int length = 20;
    private GridObject[][] grid;

    public Grid() {
        this.initGrid();
    }

    private void initGrid() {
        this.grid = new GridObject[this.width][this.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Floor();
            }
        }
    }
}
