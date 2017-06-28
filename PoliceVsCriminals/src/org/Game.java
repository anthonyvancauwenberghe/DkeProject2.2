package org;

import org.entities.bots.Bot;
import org.entities.bots.police.MCTSBotAlgorithm;
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
    public Grid grid;
    public int criminalIndex;
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
                    Criminal crim = (Criminal) obj;
                    crim.getEntity().setGame(this);
                    crim.getEntity().setLocation(new Point(i, j));
                    addCriminal(crim);
                    System.out.println("Added: " + crim.toString() + ", At: " + crim.getEntity().getLocation());
                } else if (obj.isPolice()) {
                    Police pol = (Police) obj;
                    pol.getEntity().setGame(this);
                    pol.getEntity().setLocation(new Point(i, j));
                    addPolice(pol);
                    System.out.println("Added: " + pol.toString() + ", At: " + pol.getEntity().getLocation());
                }
            }
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

    public void startGameLoop() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!isGameFinished()) {
                        Thread.sleep(100);
                        if (!isPaused()) {
                            /*for (Police police : getPolices()) {
                                Bot bot = (Bot) police.getEntity();
                                bot.move();
                                mainFrame.getGamePanel().getGridPanel().setGrid(grid);
                                Thread.sleep(200);
                            }*/
                            LinkedList<Bot> polices= new LinkedList<>();
                            for (Police police : getPolices()) {
                                Bot bot = (Bot) police.getEntity();
                                polices.add(bot);
                            }
                            MCTSBotAlgorithm.moveShared(polices);
                            mainFrame.getGamePanel().getGridPanel().setGrid(grid);
                            Thread.sleep(200);

                            for (Criminal criminal : getCriminals()) {
                                Bot bot = (Bot) criminal.getEntity();
                                bot.move();
                                mainFrame.getGamePanel().getGridPanel().setGrid(grid);
                                removeCaughtCriminals();
                                Thread.sleep(200);
                            }
                        }
                    }
                    System.out.println("Game FINISHED!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public boolean isGameFinished() {
        return getCriminals().isEmpty();
    }

    public void removeCaughtCriminals() {
        int index = 0;
        for (Criminal criminal : getCriminals()) {
            if (criminal.isCaught()) {
                getCriminals().remove(index);
            }
            index++;
        }
    }


}
