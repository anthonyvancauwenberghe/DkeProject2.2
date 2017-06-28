package org.panels.menu;

import org.Game;
import org.map.Grid;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Tony on 19-Jun-17.
 */
public class StartMenu extends Menu {

    private JButton loadGridButton;
    private JButton startGameButton;
    private JButton backButton;
    private Game game;

    public StartMenu(Game game) {
        this.game = game;
        loadGridButton = new JButton("LOAD MAP");
        addButton(loadGridButton);

        startGameButton = new JButton("START GAME");
        addButton(startGameButton);
        startGameButton.setEnabled(false);

        backButton = new JButton("BACK");
        addButton(backButton);

        loadGridButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser(".");
                int returnVal = jfc.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    Properties p = new Properties();
                    try {
                        p.load(new FileReader(jfc.getSelectedFile()));
                        Grid grid = Grid.loadGrid(p);
                        if (grid != null) {
                            game.setGrid(grid);
                            game.initGame();
                            startGameButton.setEnabled(true);
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.getMainFrame().startGame();
                setVisible(false);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.getMainFrame().startMainMenu();
                setVisible(false);
            }
        });


    }

    public JButton getLoadGridButton() {
        return loadGridButton;
    }

    public JButton getStartGameButton() {
        return startGameButton;
    }
}
