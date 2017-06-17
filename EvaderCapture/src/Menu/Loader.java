package Menu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Tony on 17/06/2017.
 */
public class Loader {

    LoadScreen loadScreen;

    public Loader() {
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
        final Runnable bootMenu = new Runnable() {
            public void run() {
                loadScreen.setScreenVisible(false);
                new StartMenu();
            }
        };
        new Thread(() -> {
            try {
                //Add sleep to make it look like it's loading...
                Thread.sleep(4000);
                SwingUtilities.invokeAndWait(bootMenu);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "DestroyLoadingScreen").start();
    }


}
