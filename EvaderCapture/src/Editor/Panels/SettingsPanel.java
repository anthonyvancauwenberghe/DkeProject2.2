package Editor.Panels;

import Map.GridObject;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Tony on 17/06/2017.
 */
public class SettingsPanel extends JPanel {

    private SelectObjectPanel selectObjectPanel;

    public SettingsPanel() {
        setLayout(new BorderLayout());
        this.add(selectObjectPanel = new SelectObjectPanel(), BorderLayout.NORTH);
        this.add(new LoadSavePanel(), BorderLayout.WEST);
    }

    public GridObject getSelectedObject() {
        return selectObjectPanel.getSelectedOption();
    }
}
