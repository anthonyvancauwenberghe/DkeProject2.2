package org.editor.panels;

import org.map.GridObject;
import org.map.objects.Criminal;
import org.map.objects.Floor;
import org.map.objects.Police;
import org.map.objects.Wall;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Tony on 17/06/2017.
 */
public class SelectObjectPanel extends JPanel {

    private final int BI_WIDTH = 50;
    private final int FONTSIZE = 25;
    public ArrayList<JRadioButton> buttons;
    private GridObject selectedObject = new Wall();
    private Icon selectedIcon;

    public SelectObjectPanel() {
        setLayout(new BorderLayout());
        createControlPanel();
    }

    public Icon getEmptyIcon() {
        BufferedImage img = new BufferedImage(BI_WIDTH, BI_WIDTH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setStroke(new BasicStroke(4f));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = 4;
        int y = x;
        int width = BI_WIDTH - 2 * x;
        int height = width;
        g2.setColor(Color.lightGray);
        g2.drawOval(x, y, width, height);
        g2.dispose();

        return new ImageIcon(img);
    }


    public Icon getSelectedIcon(GridObject option) {
        BufferedImage img = new BufferedImage(BI_WIDTH, BI_WIDTH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setStroke(new BasicStroke(4f));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int x = 4;
        int y = x;
        int width = BI_WIDTH - 2 * x;
        int height = width;

        g2.setColor(option.getColor());
        g2.fillOval(x, y, width, height);
        g2.drawOval(x, y, width, height);
        g2.dispose();

        selectedIcon = new ImageIcon(img);
        return selectedIcon;
    }

    public void createControlPanel() {
        JPanel choicePanel = createButtons();
        choicePanel.setLayout(new GridLayout(this.buttons.size(), 1));
        add(choicePanel, BorderLayout.CENTER);
    }

    public JPanel createButtons() {

        this.buttons = new ArrayList<>();

        ArrayList<GridObject> objects = new ArrayList<>();
        objects.add(new Floor());
        objects.add(new Wall());
        objects.add(new Police());
        objects.add(new Criminal());
        for (GridObject object : objects) {
            JRadioButton button = new JRadioButton(object.getOption(), getEmptyIcon());
            button.setSelectedIcon(getSelectedIcon(object));
            button.setBackground(Color.white);
            button.setForeground(Color.darkGray);
            button.setFont(new Font("Century Gothic", Font.BOLD, FONTSIZE));
            button.addActionListener(e -> selectedObject = object);
            button.setFocusable(false);
            buttons.add(button);
        }

        ButtonGroup group = new ButtonGroup();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(11, 1));
        for (JRadioButton button : this.buttons) {
            group.add(button);
            panel.add(button);
        }

        buttons.get(0).setSelected(true);
        buttons.get(0).doClick();
        return panel;
    }

    public GridObject getSelectedOption() {
        return selectedObject;
    }
}
