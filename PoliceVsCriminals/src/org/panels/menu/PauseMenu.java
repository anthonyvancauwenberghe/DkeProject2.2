package org.panels.menu;

import org.Game;
import org.map.Grid;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Krulvis on 20-Jun-17.
 */
public class PauseMenu extends Menu {

    private Game game;
    private JButton continueButton;
    private JButton exitButton;
    private JButton saveButton;

    public PauseMenu(Game game) {
        this.game = game;
        addButton(continueButton = new JButton("CONTINUE"));
        addButton(saveButton = new JButton("SAVE GAME"));
        addButton(exitButton = new JButton("EXIT GAME"));

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Grid grid = game.getGrid();
                JFileChooser jfc = new JFileChooser(".");
                int returnVal = jfc.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    Properties p = Grid.storeGrid(grid);
                    try {
                        p.store(new FileWriter(jfc.getSelectedFile()), null);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.getMainFrame().startMainMenu();
                setVisible(false);
            }
        });
    }

}
