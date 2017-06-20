package org.Editor.Panels;

import org.Map.Grid;
import org.Map.GridObject;
import org.Map.Objects.Wall;
import org.panels.GridPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by Tony on 17/06/2017.
 */
public class GridEditorPanel extends GridPanel implements MouseListener, MouseMotionListener {
    private final int RECTANGLE_SIZE = 30;
    private MouseEvent mouse;
    private SelectObjectPanel selectObjectPanel;

    /**
     * Constructor used for editor
     *
     * @param editorPanel
     */
    public GridEditorPanel(SelectObjectPanel editorPanel) {
        super();
        this.selectObjectPanel = editorPanel;
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void initGrid(int width, int height) {
        this.grid = new Grid(width, height);
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
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
            GridObject selectedObject = selectObjectPanel != null ? selectObjectPanel.getSelectedOption() : new Wall();
            if (grid.getWidth() > x && grid.getHeight() > y) {
                grid.getGridArray()[x][y] = selectedObject;
                this.repaint();
            }
        }
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

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = Math.round(e.getX() / RECTANGLE_SIZE) - 1;
        int y = Math.round(e.getY() / RECTANGLE_SIZE) - 1;

        if ((x != -1 && y != -1)) {
            GridObject selectedObject = selectObjectPanel != null ? selectObjectPanel.getSelectedOption() : new Wall();
            if (grid.getWidth() > x && grid.getHeight() > y) {
                grid.getGridArray()[x][y] = selectedObject;
                this.repaint();
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
