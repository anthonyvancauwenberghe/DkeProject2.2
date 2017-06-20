package org;

import org.Map.Grid;
import org.Map.Objects.Criminal;
import org.Map.Objects.Police;
import org.panels.Loader;
import org.panels.MainFrame;
import org.panels.menu.PauseMenu;

import java.util.LinkedList;


/**
 * Created by s120619 on 18-6-2017.
 */
public class Game {

    public static final int FRAME_WIDTH = 1200;
    public static final int FRAME_HEIGHT = 900;
    private Grid grid;
    private LinkedList<Criminal> evaders;
    private LinkedList<Police> pursuiters;

    private MainFrame mainFrame;

    public Game() {
        new Loader(this);
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void startMainFrame() {
        this.mainFrame = new MainFrame(this);
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public LinkedList<Police> getPursuiters() {
        return pursuiters;
    }

    public void addPursuiter(Police pursuiter) {
        pursuiters.add(pursuiter);
    }

    public LinkedList<Criminal> getEvaders() {
        return evaders;
    }

    public void addEvader(Criminal entity) {
        evaders.add(entity);
    }

    public boolean isPaused() {
        if (getMainFrame() != null) {
            PauseMenu pauseMenu = getMainFrame().getPauseMenu();
            return pauseMenu != null && pauseMenu.isVisible();
        }
        return false;
    }


}
