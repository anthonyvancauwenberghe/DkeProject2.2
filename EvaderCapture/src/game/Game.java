package game;

import game.Entities.Entity;
import game.Map.Grid;
import game.Menu.BackgroundPanel;
import game.Menu.Loader;
import game.Menu.MainFrame;
import game.Menu.MainMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * Created by s120619 on 18-6-2017.
 */
public class Game {

    public static final int FRAME_WIDTH = 1200;
    public static final int FRAME_HEIGHT = 900;

    private Grid grid;
    private LinkedList<Entity> entities;

    private MainFrame mainFrame;

    public Game() {
        new Loader(this);
    }

    public LinkedList<Entity> getEntities() {
        return entities;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void startMainFrame() {
        this.mainFrame = new MainFrame();
    }
}
