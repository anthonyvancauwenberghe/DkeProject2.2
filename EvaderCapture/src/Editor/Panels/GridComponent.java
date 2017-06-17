package Editor.Panels;

import Map.Grid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Tony on 17/06/2017.
 */
public class GridComponent extends JComponent implements MouseListener {
    private Grid grid;

    public GridComponent(Grid grid) {
        this.grid = grid;
        addMouseListener(this);
    }

    public void paint(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(100, 100, 100, 100);
        g.setColor(Color.blue);
        g.drawRect(100, 100, 100, 100);
        /*
        for (int x = 0; x < grid.getGridArray().length; x++) {
            for (int y = 0; y < grid.getGridArray()[x].length; y++) {
                g.drawRect(x * 10, y * 10, 10, 10);
            }
        }
*/
    }

    @Override
    public void mouseClicked(MouseEvent e) {
/*
        //iterate through all JPanels to determine clicked one
        for (int x = 0; x < myPanels.length; x++) {
            for (int y = 0; y < myPanels[x].length; y++) {
                if (e.getX() > myPanels[x][x].getX() && e.getX() < (myPanels[x][x].getX() + myPanels[x][x].getWidth()))

                {

                    if (e.getY() > myPanels[x][x].getY() && e.getY() < (myPanels[x][x].getY() + myPanels[x][x].getHeight())) {
                        //Toggle colours
                        if (myPanels[x][x].getBackground() == Color.blue)
                            myPanels[x][x].setBackground(Color.red);

                        else {
                            myPanels[x][x].setBackground(Color.blue);
                        }
                    }
                }
            }
        }
*/
    }

    @Override
    public void mousePressed(MouseEvent e) {

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
