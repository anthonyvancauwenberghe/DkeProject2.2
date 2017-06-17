package Editor.Panels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Tony on 17/06/2017.
 */
public class SettingsPanel extends JPanel {

    public SettingsPanel() {
        setLayout(new BorderLayout());
        this.add(new SelectObjectPanel(), BorderLayout.NORTH);
        this.add(new LoadSavePanel(), BorderLayout.WEST);
    }
}
