package Editor.Panels;


import javax.swing.*;
import java.awt.*;

/**
 * Created by Tony on 17/06/2017.
 */
public class SettingsPanel extends JPanel {

    public SelectObjectPanel selectObjectPanel;

    public SettingsPanel() {
        setLayout(new BorderLayout());
        this.add(selectObjectPanel = new SelectObjectPanel(), BorderLayout.NORTH);
        this.add(new LoadSavePanel(), BorderLayout.WEST);
    }
}
