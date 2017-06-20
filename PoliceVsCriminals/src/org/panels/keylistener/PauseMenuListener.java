package org.panels.keylistener;

import org.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Krulvis on 20-Jun-17.
 */
public class PauseMenuListener implements KeyListener {

    private Game game;

    public PauseMenuListener(Game game){
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e);
        if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
            game.getMainFrame().startPauseMenu();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
