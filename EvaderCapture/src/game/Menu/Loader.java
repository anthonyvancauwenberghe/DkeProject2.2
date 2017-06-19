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

    private void bootMenu() {
        final Runnable bootMenu = () -> {
            loadScreen.dispose();
            game.startMainFrame();

            /*
            Start main frame with main menu, can be changed if you want to directly go somewhere and skip menu.
             */
            game.getMainFrame().startMainMenu();
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


}
