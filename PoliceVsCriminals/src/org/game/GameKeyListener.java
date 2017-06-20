package org.game;

import org.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Krulvis on 20-Jun-17.
 */
public class GameKeyListener implements KeyListener {

    private Game game;

    public GameKeyListener(Game game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
            game.getMainFrame().startPauseMenu();
        }
    }
}
