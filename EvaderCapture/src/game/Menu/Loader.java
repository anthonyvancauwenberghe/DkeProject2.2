package game.Menu;

import game.Game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Tony on 17/06/2017.
 */
public class Loader {

    private LoadScreen loadScreen;
    private Game game;

    public Loader(Game game) {
        this.game = game;
        startLoadingScreen();
        bootMenu();
    }

    private void startLoadingScreen() {
        ImageIcon myImage = new ImageIcon("logo.gif");
        loadScreen = new LoadScreen(myImage);
        loadScreen.setPreferredSize(new Dimension(600, 600));
        loadScreen.setLocationRelativeTo(null);
        loadScreen.setScreenVisible(true);
    }

    private void startMainFrame() {
        ImageIcon background = new ImageIcon("game.jpg");
        BackgroundPanel bgp = new BackgroundPanel(background.getImage(), BackgroundPanel.SCALED, 0.0f, 0.0f);
        bgp.setLayout(new BorderLayout());
        bgp.setFocusable(true);
        game.setMainFrame(new MainFrame(bgp));
    }

    private void startMainMenu() {
        MainMenu mainMenu = new MainMenu();
        game.getMainFrame().addMainMenu(mainMenu);
    }

    private void bootMenu() {
        final Runnable bootMenu = () -> {
            loadScreen.dispose();
            startMainFrame();
            startMainMenu();
        };
        new Thread(() -> {
            try {
                //Add sleep to make it look like it's loading...
                Thread.sleep(1000);
                SwingUtilities.invokeAndWait(bootMenu);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Boot Actual game.Menu").start();
    }

    public LoadScreen getLoadScreen() {
        return loadScreen;
    }


}
