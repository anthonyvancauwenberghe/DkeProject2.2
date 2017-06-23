package org.panels;

import org.Game;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by Krulvis on 23-Jun-17.
 */
public class OptionsPanel extends JPanel {

    private Game game;
    private JButton pauseButton;
    private JButton startButton;

    public OptionsPanel(Game game) {
        this.game = game;
        setOpaque(false);
        setBorder(new LineBorder(Color.BLACK, 1));
        setLayout(new GridLayout(2, 0));

        add(createButtonPanel());
    }

    /**
     * JPanel used to display Buttons neat and without having their size messed up
     *
     * @return
     */
    public JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        //buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(startButton = createButton("START"));
        buttonPanel.add(pauseButton = createButton("PAUSE"));
        return buttonPanel;
    }

    /**
     * Method for creating Buttons with general layout in ButtonPanel
     *
     * @param text
     * @return
     */
    public JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(Color.lightGray);
        button.setForeground(Color.darkGray);
        button.setBorderPainted(false);
        button.setFont(new Font("Century Gothic", Font.BOLD, 30));
        button.setFocusable(false);
        return button;
    }

    public JButton getPauseButton() {
        return pauseButton;
    }

    public JButton getStartButton() {
        return startButton;
    }
}
