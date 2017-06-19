package game.Menu;

import game.Editor.Panels.EditorPanel;

import javax.swing.*;

/**
 * Created by s120619 on 19-6-2017.
 */
public class MainFrame extends JFrame {

    private BackgroundPanel bgp;
    private MainMenu mainMenu;
    private EditorPanel editorPanel;

    /**
     * Start a mainframe, automatically loads the backgroundpanel ontop of it.
     */
    public MainFrame() {
        startBackgroundPanel();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * gets called automatically since the main frame needs a background.
     */
    public void startBackgroundPanel() {
        ImageIcon background = new ImageIcon("game.jpg");
        bgp = new BackgroundPanel(background.getImage(), BackgroundPanel.SCALED, 0.0f, 0.0f);
        add(bgp);
    }

    /**
     * Start and add a Main Menu.
     */
    public void startMainMenu() {
        this.mainMenu = new MainMenu(this);
        this.bgp.add(mainMenu);
    }

    /**
     * Start and add a Editor Panel
     */
    public void startEditorPanel() {
        this.editorPanel = this.editorPanel == null ? new EditorPanel() : this.editorPanel;
        this.editorPanel.setVisible(true);
        bgp.add(this.editorPanel);
    }

    public BackgroundPanel getBackgroundPanel() {
        return bgp;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public EditorPanel getEditorPanel() {
        return editorPanel;
    }
}
