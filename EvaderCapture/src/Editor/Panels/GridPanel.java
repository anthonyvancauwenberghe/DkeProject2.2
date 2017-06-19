package Editor.Panels;

import Map.Grid;
import Map.GridObject;
import Map.Objects.Wall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Tony on 17/06/2017.
 */
public class GridPanel extends JPanel implements MouseListener {
    private final int RECTANGLE_SIZE = 30;
    private Grid grid;
    private MouseEvent mouse;

    private EditorPanel editorPanel;

    /**
     * Constructor used for editor
     *
     * @param editorPanel
     */
    public GridPanel(EditorPanel editorPanel) {
        this();
        this.editorPanel = editorPanel;
    }

    public GridPanel() {
        initGrid(20, 20);
        addMouseListener(this);
    }

    public void initGrid(int width, int height) {
        this.grid = new Grid(width, height);
    }

    public Grid getGrid() {
        return grid;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int x = 0; x < grid.getGridArray().length; x++) {
            for (int y = 0; y < grid.getGridArray()[x].length; y++) {
                int cellX = RECTANGLE_SIZE + (x * RECTANGLE_SIZE);
                int cellY = RECTANGLE_SIZE + (y * RECTANGLE_SIZE);
                g.setColor(grid.getGridArray()[x][y].getColor());
                g.fillRect(cellX, cellY, RECTANGLE_SIZE, RECTANGLE_SIZE);
                g.setColor(Color.black);
                g.drawRect(cellX, cellY, RECTANGLE_SIZE, RECTANGLE_SIZE);
            }
        }
        if (this.mouse != null) {
            g.drawString("X Location: " + this.mouse.getX(), 540, 650);
            g.drawString("Y Location: " + this.mouse.getY(), 540, 665);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.mouse = e;
        int x = Math.round(e.getX() / RECTANGLE_SIZE) - 1;
        int y = Math.round(e.getY() / RECTANGLE_SIZE) - 1;

        if ((x != -1 && y != -1)) { //TODO ERROR CHECKING ON THE SIDES
            GridObject selectedObject = editorPanel.getSelectedObject();
            grid.getGridArray()[x][y] = selectedObject;
        }
        this.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
