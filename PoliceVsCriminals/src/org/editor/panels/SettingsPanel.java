package org.editor.panels;

import org.entities.Entity;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Tony on 17/06/2017.
 */
public class SettingsPanel extends JPanel {

    private SelectObjectPanel selectObjectPanel;
    private LoadSavePanel loadSavePanel;
    private SelectEntityPanel selectEntityPanel;

    public SettingsPanel() {
        setLayout(new BorderLayout());
        this.add(selectObjectPanel = new SelectObjectPanel(this), BorderLayout.NORTH);
        JPanel options = new JPanel();
        options.setLayout(new GridLayout(2, 0));
        options.add(loadSavePanel = new LoadSavePanel());
        options.add(selectEntityPanel = new SelectEntityPanel());
        this.add(options, BorderLayout.WEST);
        setFocusable(false);
    }

    public void showEvaders() {
        if (selectEntityPanel != null) {
            selectEntityPanel.showEvaders();
        }
    }

    public void showNothing() {
        if (selectEntityPanel != null) {
            selectEntityPanel.showNothing();
        }
    }

    public void showCapturers() {
        if (selectEntityPanel != null) {
            selectEntityPanel.showCapturers();
        }
    }

    public Entity getSelectedEntity() {
        if (selectEntityPanel != null) {
            return selectEntityPanel.getSelectedEntity();
        }
        return null;
    }


    public SelectObjectPanel getSelectObjectPanel() {
        return selectObjectPanel;
    }

    public LoadSavePanel getLoadSavePanel() {
        return loadSavePanel;
    }
}
