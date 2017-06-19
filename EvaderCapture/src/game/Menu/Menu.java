package game.Menu;

import javax.swing.*;
import java.awt.*;

import static game.Game.FRAME_HEIGHT;
import static game.Game.FRAME_WIDTH;

/**
 * Created by s120619 on 19-6-2017.
 */
public class Menu extends JPanel {

    private int buttonHeight = 25;
    private JPanel menuPanel;

    public Menu(int buttonHeight) {
        this();
        this.buttonHeight = buttonHeight;
    }

    public Menu() {
        setPreferredSize(new Dimension((int) (FRAME_WIDTH * 0.30), 400));
        setOpaque(true);
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(7, 10, 0, buttonHeight));
        menuPanel.setOpaque(false);
        //Tmp Panel
        add(Box.createRigidArea(new Dimension(0, FRAME_HEIGHT)));
        add(menuPanel);
    }

    public void addButton(JButton button) {
        button.setBackground(new Color(0, 0, 0, 210));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Calibri", Font.PLAIN, 23));
        button.setUI(new StyledButtonUI());
        //button.setPreferredSize(new Dimension(130, 50));
        menuPanel.add(button);
        //add(button);
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }
}
