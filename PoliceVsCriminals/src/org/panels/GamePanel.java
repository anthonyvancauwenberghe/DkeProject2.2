package org.panels;

import org.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Krulvis on 23-Jun-17.
 */
public class GamePanel extends JPanel {

    private Game game;
    private GridPanel gridPanel;
    private OptionsPanel optionsPanel;

    public GamePanel(Game game) {
        this.game = game;
        setLayout(new BorderLayout());
        gridPanel = new GridPanel(game.getGrid());
        gridPanel.setOpaque(false);
        add(gridPanel, BorderLayout.CENTER);
        add(optionsPanel = new OptionsPanel(game), BorderLayout.EAST);

        optionsPanel.getPauseButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
