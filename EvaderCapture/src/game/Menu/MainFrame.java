package game.Menu;

import javax.swing.*;

/**
 * Created by s120619 on 19-6-2017.
 */
public class MainFrame extends JFrame {

    private BackgroundPanel bgp;
    private MainMenu mainMenu;

    public MainFrame(BackgroundPanel backgroundPanel) {
        addBackgroundPanel(backgroundPanel);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addBackgroundPanel(BackgroundPanel backgroundPanel) {
        this.bgp = backgroundPanel;
        add(this.bgp);
    }

    public void addMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
        this.bgp.add(mainMenu);
    }

    public BackgroundPanel getBackgroundPanel() {
        return bgp;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }
}
