package Editor.Panels;

import Map.Grid;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Tony on 17/06/2017.
 */
public class EditorPanel extends JPanel {
    private Grid grid;

    public EditorPanel() {
        setLayout(new BorderLayout());
        this.add(new GridPanel(), BorderLayout.CENTER);
        this.add(new SettingsPanel(), BorderLayout.EAST);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
    }
}
