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
    public boolean paused = true;
    private Grid grid;
    private LinkedList<Criminal> criminal;
    private LinkedList<Police> police;

    private MainFrame mainFrame;

    public Game() {
        new Loader(this);
        this.criminal = new LinkedList<>();
        this.police = new LinkedList<>();
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void startMainFrame() {
        this.mainFrame = new MainFrame(this);
    }

    public void initGame() {
        for (int i = 0; i < getGrid().getGridArray().length; i++) {
            for (int j = 0; j < getGrid().getGridArray()[i].length; j++) {
                GridObject obj = getGrid().getGridArray()[i][j];

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
            this.gameLoop();
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

    public LinkedList<Police> getPolice() {
        return police;
    }

    public void addPolice(Police pursuiter) {
        police.add(pursuiter);
    }

    public LinkedList<Criminal> getCriminal() {
        return criminal;
    }

    public void addCriminal(Criminal entity) {
        criminal.add(entity);
    }

    public boolean isPaused() {
        if (getMainFrame() != null) {
            PauseMenu pauseMenu = getMainFrame().getPauseMenu();
            GamePanel gamePanel = getMainFrame().getGamePanel();

            return (pauseMenu != null && pauseMenu.isVisible()) || (gamePanel != null && gamePanel.isPaused());
        }
        return false;
    }

    public void gameLoop() throws InterruptedException {
        while (true) {

            Thread.sleep(1000);
            if (!paused) {

                for (Police police : getPolice()) {
                    Bot bot = (Bot) police.getEntity();
                    bot.move(getGrid());
                    mainFrame.getGamePanel().repaint();
                    Thread.sleep(2000);
                }

                for (Criminal criminal : getCriminal()) {
                    Bot bot = (Bot) criminal.getEntity();
                    bot.move(getGrid());
                    mainFrame.getGamePanel().repaint();
                    Thread.sleep(2000);
                }
            }
        }
    }


}
