package org.panels;

import org.Game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Krulvis on 23-Jun-17.
 */
public class GamePanel extends JPanel {

    private Game game;

    public GamePanel(Game game) {
        this.game = game;
        setLayout(new BorderLayout());
        add(new GridPanel(game.getGrid()), BorderLayout.NORTH);
        add(new OptionsPanel(game), BorderLayout.EAST);
    }
}
