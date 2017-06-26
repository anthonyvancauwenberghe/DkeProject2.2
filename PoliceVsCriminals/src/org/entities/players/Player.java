package org.entities.players;

import org.Game;
import org.entities.Entity;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Tony on 17/06/2017.
 */
public class Player extends Entity implements KeyListener {

    public Player() {
        super("PLAYER");
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {

        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {

        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {

        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {

        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {

        }
    }
}
