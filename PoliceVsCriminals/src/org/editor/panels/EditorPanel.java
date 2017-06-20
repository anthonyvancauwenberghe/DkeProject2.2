package org.editor.panels;


import org.Game;
import org.map.Grid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Tony on 17/06/2017.
 */
public class EditorPanel extends JPanel {
    private SettingsPanel settingsPanel;
    private GridEditorPanel gridEditorPanel;
    private Game game;

    public EditorPanel(Game game) {
        setLayout(new BorderLayout());
        this.add(settingsPanel = new SettingsPanel(), BorderLayout.EAST);
        this.add(gridEditorPanel = new GridEditorPanel(settingsPanel.getSelectObjectPanel()), BorderLayout.CENTER);
        settingsPanel.getLoadSavePanel().getLoadButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser(".");
                int returnVal = jfc.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    Properties p = new Properties();
                    try {
                        p.load(new FileReader(jfc.getSelectedFile()));
                        Grid grid = Grid.loadGrid(p);
                        gridEditorPanel.setGrid(grid);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        settingsPanel.getLoadSavePanel().getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Grid grid = gridEditorPanel.getGrid();
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

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
    }
}
