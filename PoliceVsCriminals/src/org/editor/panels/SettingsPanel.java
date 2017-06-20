package org.editor.panels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Tony on 17/06/2017.
 */
public class SettingsPanel extends JPanel {

    private SelectObjectPanel selectObjectPanel;
    private LoadSavePanel loadSavePanel;

    public SettingsPanel() {
        setLayout(new BorderLayout());
        this.add(selectObjectPanel = new SelectObjectPanel(), BorderLayout.NORTH);
        this.add(loadSavePanel = new LoadSavePanel(), BorderLayout.WEST);
        setFocusable(false);
    }

    public SelectObjectPanel getSelectObjectPanel() {
        return selectObjectPanel;
    }

    public LoadSavePanel getLoadSavePanel() {
        return loadSavePanel;
    }
}
