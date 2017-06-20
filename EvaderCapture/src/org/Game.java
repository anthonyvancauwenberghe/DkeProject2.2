package org;

import org.Map.Grid;
import org.Map.Objects.Evader;
import org.Map.Objects.Pursuiter;
import org.Menu.Loader;
import org.Menu.MainFrame;

import java.util.LinkedList;

/**
 * Created by s120619 on 18-6-2017.
 */
public class Game {

    public static final int FRAME_WIDTH = 1200;
    public static final int FRAME_HEIGHT = 900;

    private Grid grid;
    private LinkedList<Evader> evaders;
    private LinkedList<Pursuiter> pursuiters;

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

    public void startGameWithGrid(Grid grid) {

    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public LinkedList<Pursuiter> getPursuiters() {
        return pursuiters;
    }

    public void addPursuiter(Pursuiter pursuiter) {
        pursuiters.add(pursuiter);
    }

    public LinkedList<Evader> getEvaders() {
        return evaders;
    }

    public void addEvader(Evader entity) {
        evaders.add(entity);
    }
}
