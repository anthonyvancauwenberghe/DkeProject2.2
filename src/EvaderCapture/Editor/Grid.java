package EvaderCapture.Editor;

import javax.swing.*;

/**
 * Created by Carla on 11/04/2016.
 */


public class Grid extends JComponent {
    private GridElement[][] grid;

    public Grid(){
        grid = new GridElement[82][50];
        for(int i = 0; i< grid.length; i++) {
            for (int j = 0; j< grid[i].length; j++) {
                grid[i][j] = new GridElement(EditorOptions.FLOOR, new Position(i,j));
            }
        }
    }

    public GridElement[][] getGrid() {
        return grid;
    }
}