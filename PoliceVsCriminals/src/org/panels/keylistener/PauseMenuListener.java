package org.panels.keylistener;

import org.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Tony on 20-Jun-17.
 */
public class PauseMenuListener implements KeyListener {

    private Game game;

    public PauseMenuListener(Game game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e);
        if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
            if (game.getMainFrame().editorPanelVisible() || game.getMainFrame().gridPanelVisible()) {
                System.out.println("editorVisible: " + game.getMainFrame().editorPanelVisible());
                System.out.println("gridVisible: " + game.getMainFrame().gridPanelVisible());
                game.getMainFrame().startPauseMenu();
            } else {
                game.getMainFrame().startMainMenu();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
