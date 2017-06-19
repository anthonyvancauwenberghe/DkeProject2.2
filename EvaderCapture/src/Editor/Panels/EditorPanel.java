package Editor.Panels;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Tony on 17/06/2017.
 */
public class EditorPanel extends JPanel {
    private SettingsPanel settingsPanel;

    public EditorPanel() {
        setLayout(new BorderLayout());
        this.add(settingsPanel = new SettingsPanel(), BorderLayout.EAST);
        this.add(new GridPanel(settingsPanel.getSelectObjectPanel()), BorderLayout.CENTER);
        settingsPanel.getLoadSavePanel().getLoadButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        settingsPanel.getLoadSavePanel().getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
    }
}
