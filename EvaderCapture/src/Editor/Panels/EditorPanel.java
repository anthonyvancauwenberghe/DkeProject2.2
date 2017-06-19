package Editor.Panels;

import Map.GridObject;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Tony on 17/06/2017.
 */
public class EditorPanel extends JPanel {
    private SettingsPanel settingsPanel;

    public EditorPanel() {
        setLayout(new BorderLayout());
        this.add(new GridPanel(this), BorderLayout.CENTER);
        this.add(settingsPanel = new SettingsPanel(), BorderLayout.EAST);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
    }

    public GridObject getSelectedObject() {
        return settingsPanel.getSelectedObject();
    }
}
