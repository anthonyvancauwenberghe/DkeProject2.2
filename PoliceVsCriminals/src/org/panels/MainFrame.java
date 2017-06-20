package org.panels;

import org.Editor.Panels.EditorPanel;
import org.Game;
import org.panels.keylistener.PauseMenuListener;
import org.panels.menu.MainMenu;
import org.panels.menu.PauseMenu;
import org.panels.menu.StartMenu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by s120619 on 19-6-2017.
 */
public class MainFrame extends JFrame {

    private BackgroundPanel bgp;
    private MainMenu mainMenu;
    private StartMenu startMenu;
    private PauseMenu pauseMenu;
    private PauseMenuListener pauseMenuListener;
    private EditorPanel editorPanel;
    private GridPanel gridPanel;
    private Game game;

    /**
     * Start a mainframe, automatically loads the backgroundpanel ontop of it.
     */
    public MainFrame(Game game) {
        this.game = game;
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
        setContentPane(bgp);
        pack();
    }

    /**
     * Start and add a Main Menu.
     */
    public void startMainMenu() {
        if (editorPanel != null) {
            editorPanel.setVisible(false);
            bgp.remove(editorPanel);
        }
        if (gridPanel != null) {
            gridPanel.setVisible(false);
            bgp.remove(gridPanel);
        }
        if (startMenu != null) {
            startMenu.setVisible(false);
            bgp.remove(startMenu);
        }
        if (mainMenu == null) {
            mainMenu = new MainMenu(this);
            bgp.add(mainMenu);
        }

        mainMenu.setVisible(true);
        pack();
    }

    /**
     * Start and add a Start Menu.
     */
    public void startStartMenu() {
        if (startMenu == null) {
            startMenu = new StartMenu(game);
            bgp.add(startMenu);
        }
        startMenu.setVisible(true);
        pack();
    }

    /**
     * Sets existing pauseMenu visible, or creates new pausemenu
     */
    public void startPauseMenu() {
        if (pauseMenu == null) {
            System.out.println("Start new pause menu");
            pauseMenu = new PauseMenu(game);
            bgp.add(pauseMenu);
        }
        bgp.setComponentZOrder(pauseMenu, 0);
        pauseMenu.setVisible(true);
        pack();
    }

    /**
     * Starts a GridPanel with the Game.grid loading
     */
    public void startGame() {
        gridPanel = new GridPanel(game.getGrid());
        gridPanel.setVisible(true);
        bgp.add(gridPanel);
        bgp.addKeyListener(pauseMenuListener = new PauseMenuListener(game));
    }

    /**
     * Start and add a Editor Panel
     */
    public void startEditorPanel() {
        editorPanel = editorPanel == null ? new EditorPanel(game) : editorPanel;
        editorPanel.setVisible(true);
        bgp.add(editorPanel);
        bgp.addKeyListener(pauseMenuListener = new PauseMenuListener(game));
        bgp.grabFocus();
    }

    public PauseMenuListener getPauseMenuListener() {
        return pauseMenuListener;
    }

    public boolean gridPanelVisible() {
        return gridPanel != null && gridPanel.isVisible();
    }

    public boolean editorPanelVisible() {
        return editorPanel != null && editorPanel.isVisible();
    }

    public PauseMenu getPauseMenu() {
        return pauseMenu;
    }

    public Game getGame() {
        return game;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Game.FRAME_WIDTH, Game.FRAME_HEIGHT);
    }

}
