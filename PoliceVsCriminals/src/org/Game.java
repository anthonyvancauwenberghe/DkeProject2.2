package org;

import org.entities.bots.Bot;
import org.map.Grid;
import org.map.GridObject;
import org.map.objects.Criminal;
import org.map.objects.Police;
import org.panels.GamePanel;
import org.panels.Loader;
import org.panels.MainFrame;
import org.panels.menu.PauseMenu;

import java.awt.*;
import java.util.LinkedList;


/**
 * Created by s120619 on 18-6-2017.
 */
public class Game {

    public static final int FRAME_WIDTH = 1200;
    public static final int FRAME_HEIGHT = 900;
    private Grid grid;
    private LinkedList<Criminal> criminals;
    private LinkedList<Police> polices;

    private MainFrame mainFrame;

    public Game() {
        new Loader(this);
        this.criminals = new LinkedList<>();
        this.polices = new LinkedList<>();
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void startMainFrame() {
        this.mainFrame = new MainFrame(this);
    }

    public void initGame() {
        for (int i = 0; i < grid.getGridArray().length; i++) {
            for (int j = 0; j < grid.getGridArray()[i].length; j++) {
                GridObject obj = grid.getGridArray()[i][j];

                if (obj.isCriminal()) {
                    addCriminal((Criminal) obj);
                    ((Criminal) obj).getEntity().setLocation(new Point(i, j));
                } else if (obj.isPolice()) {
                    addPolice((Police) obj);
                    ((Police) obj).getEntity().setLocation(new Point(i, j));
                }
            }
        }
        try {
            this.startGameLoop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public LinkedList<Police> getPolices() {
        return polices;
    }

    public void addPolice(Police pursuiter) {
        polices.add(pursuiter);
    }

    public LinkedList<Criminal> getCriminals() {
        return criminals;
    }

    public void addCriminal(Criminal entity) {
        criminals.add(entity);
    }

    public boolean isPaused() {
        if (getMainFrame() != null) {
            PauseMenu pauseMenu = getMainFrame().getPauseMenu();
            GamePanel gamePanel = getMainFrame().getGamePanel();

            return (pauseMenu != null && pauseMenu.isVisible()) || (gamePanel != null && gamePanel.isPaused());
        }
        return false;
    }

    public void startGameLoop() throws InterruptedException {
        while (!isGameFinished()) {

            Thread.sleep(1000);
            if (!isPaused()) {

                for (Police police : getPolices()) {
                    Bot bot = (Bot) police.getEntity();
                    bot.move(getGrid());
                    mainFrame.getGamePanel().repaint();
                    Thread.sleep(2000);
                }

                for (Criminal criminal : getCriminals()) {
                    Bot bot = (Bot) criminal.getEntity();
                    bot.move(getGrid());
                    mainFrame.getGamePanel().repaint();
                    Thread.sleep(2000);
                }
            }
        }
    }

    public boolean isGameFinished() {
        for (Criminal criminal : criminals) {
            if (!criminal.isCaught()) {
                return false;
            }
        }
        return true;
    }


}
