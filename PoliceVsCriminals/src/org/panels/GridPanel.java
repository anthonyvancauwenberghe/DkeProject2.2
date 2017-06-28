package org.panels;

import org.map.Grid;
import org.map.GridObject;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Tony on 20-Jun-17.
 */
public class GridPanel extends JPanel {
    private final int RECTANGLE_SIZE = 30;
    /**
     * Reset this Grid only for redrawing, don't edit it directly
     */
    private Grid grid;

    public GridPanel() {
        this(new Grid(20, 20));
    }

    public GridPanel(Grid grid) {
        setGrid(grid);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int x = 0; x < grid.getGridArray().length; x++) {
            for (int y = 0; y < grid.getGridArray()[x].length; y++) {
                int cellX = RECTANGLE_SIZE + (x * RECTANGLE_SIZE);
                int cellY = RECTANGLE_SIZE + (y * RECTANGLE_SIZE);

                GridObject go = grid.getGridArray()[x][y];

                g.setColor(Color.lightGray);
                g.fillRect(cellX, cellY, RECTANGLE_SIZE, RECTANGLE_SIZE);
                g.setColor(Color.black);
                g.drawRect(cellX, cellY, RECTANGLE_SIZE, RECTANGLE_SIZE);

                BufferedImage image = go.getImage();
                if (image != null) {
                    g.drawImage(image, cellX + 3, cellY + 3, RECTANGLE_SIZE - 6, RECTANGLE_SIZE - 6, null);
                } else {
                    g.setColor(go.getColor());
                    g.fillRect(cellX, cellY, RECTANGLE_SIZE, RECTANGLE_SIZE);
                }

                g.setColor(Color.black);
                g.drawRect(cellX, cellY, RECTANGLE_SIZE, RECTANGLE_SIZE);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 9));
                g.drawString("[" + x + "," + y + "]", cellX + 2, cellY + 18);
            }

        }
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
        repaint();
    }

}
