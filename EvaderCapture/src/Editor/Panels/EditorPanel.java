package Editor.Panels;


import Map.Grid;
import Map.GridObject;

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
    private GridPanel gridPanel;

    public EditorPanel() {
        setLayout(new BorderLayout());
        this.add(settingsPanel = new SettingsPanel(), BorderLayout.EAST);
        this.add(gridPanel = new GridPanel(settingsPanel.getSelectObjectPanel()), BorderLayout.CENTER);
        settingsPanel.getLoadSavePanel().getLoadButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser(".");
                int returnVal = jfc.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    Properties p = new Properties();
                    try {
                        p.load(new FileReader(jfc.getSelectedFile()));
                        int width = Integer.parseInt(p.getProperty("grid_width", "20"));
                        int height = Integer.parseInt(p.getProperty("grid_height", "20"));
                        Grid grid = new Grid(width, height);
                        for (Object key : p.keySet()) {
                            String k = key.toString();
                            if (k.contains("[") && k.contains("]")) {
                                int x = Integer.parseInt(k.substring(k.indexOf("[") + 1, k.indexOf("]")));
                                int y = Integer.parseInt(k.substring(k.lastIndexOf("[") + 1, k.lastIndexOf("]")));
                                GridObject obj = GridObject.getObjectFromString(p.getProperty(k, "FLOOR"));
                                grid.getGridArray()[x][y] = obj;
                            }
                        }
                        gridPanel.setGrid(grid);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        settingsPanel.getLoadSavePanel().getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Grid grid = gridPanel.getGrid();
                GridObject[][] objects = grid.getGridArray();
                JFileChooser jfc = new JFileChooser(".");
                int returnVal = jfc.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    Properties p = new Properties();
                    p.setProperty("grid_width", String.valueOf(grid.getWidth()));
                    p.setProperty("grid_height", String.valueOf(grid.getHeight()));
                    for (int x = 0; x < grid.getWidth(); x++) {
                        for (int y = 0; y < grid.getHeight(); y++) {
                            p.setProperty("[" + x + "][" + y + "]", objects[x][y].toString());
                        }
                    }
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
