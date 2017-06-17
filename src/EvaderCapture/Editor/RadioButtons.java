package EvaderCapture.Editor;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Carla on 15/03/2016.
 */
public class RadioButtons extends JPanel {

    public ArrayList<JRadioButton> buttons;
    private EditorOptions chosenOption;

    private static final int BI_WIDTH = 50;
    private Icon selectedIcon;
    private final int FONTSIZE = 25;

    public RadioButtons(){
        setLayout(new BorderLayout());
        createControlPanel();
    }

    public Icon getEmptyIcon(){
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


    public Icon getSelectedIcon(EditorOptions option){
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
        choicePanel.setLayout(new GridLayout(this.buttons.size(),1));
        add(choicePanel, BorderLayout.CENTER);
    }

    public JPanel createButtons(){

        this.buttons = new ArrayList<>();
        for (EditorOptions option : EditorOptions.values()) {
            JRadioButton button = new JRadioButton(option.toString(), getEmptyIcon());
            button.setSelectedIcon(getSelectedIcon(option));
            button.setBackground(Color.white);
            button.setForeground(Color.darkGray);
            button.setFont(new Font("Century Gothic",Font.BOLD,FONTSIZE));
            button.addActionListener(e -> chosenOption = option);
            buttons.add(button);
        }

        ButtonGroup group = new ButtonGroup();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(11,1));
        for(JRadioButton button : this.buttons){
            group.add(button);
            panel.add(button);
        }

        buttons.get(0).setSelected(true);
        buttons.get(0).doClick();

        return panel;
    }

    public EditorOptions getSelectedOption(){
        return chosenOption;
    }

}
