package org.panels;

import org.Game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Krulvis on 23-Jun-17.
 */
public class OptionsPanel extends JPanel {

    private Game game;
    private JButton pauseButton;

    public OptionsPanel(Game game) {
        this.game = game;
        setOpaque(false);
        setLayout(new GridLayout(5, 0));
        pauseButton = createButton("PAUSE");
        add(pauseButton);
    }

    public JButton createButton(String text) {
        JButton button = new JButton(text);

        button.setBackground(Color.lightGray);
        button.setForeground(Color.darkGray);
        button.setBorderPainted(false);
        button.setFont(new Font("Century Gothic", Font.BOLD, 30));
        button.setFocusable(false);
        return button;
    }
}
