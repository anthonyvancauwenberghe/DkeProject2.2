package org.panels;

import org.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Krulvis on 23-Jun-17.
 */
public class GameFrame extends JPanel {

    private Game game;
    private GridPanel gridPanel;
    private OptionsPanel optionsPanel;
    private boolean isPaused = false;
    private int counter = 0;

    public GameFrame(Game game) {
        this.game = game;
        setLayout(new BorderLayout());
        add(optionsPanel = new OptionsPanel(game), BorderLayout.EAST);
        /*
        Add action listener to pause menu, for presentation's sake
         */
        optionsPanel.getPauseButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isPaused = !isPaused;
            }
        });

        optionsPanel.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (counter == 0) {
                    game.initGame();
                    counter++;
                } else {
                    try {
                        game.startGameLoop();
                    } catch (InterruptedException a) {
                        System.out.println("GAME INTERUPTED!");
                        a.printStackTrace();
                    }
                }


            }
        });
        this.addGridPanel();
    }

    public void addGridPanel() {
        gridPanel = new GridPanel(game.getGrid());
        gridPanel.setOpaque(false);
        add(gridPanel, BorderLayout.CENTER);
        repaint();
        game.getMainFrame().repaint();
    }

    public GridPanel getGridPanel() {
        return this.gridPanel;
    }

    public boolean isPaused() {
        return isPaused;
    }
}
