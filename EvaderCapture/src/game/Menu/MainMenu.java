package game.Menu;

import javax.swing.*;


/**
 * Created by s120619 on 19-6-2017.
 */
public class MainMenu extends Menu {

    private JButton playButton;
    private JButton createButton;
    private JButton exitButton;

    public MainMenu() {
        //PLAY button
        playButton = new JButton("PLAY");
        addButton(playButton);
        //Create YOur map button
        createButton = new JButton("CREATE YOUR MAP");
        addButton(createButton);
        //EXIT button
        exitButton = new JButton("EXIT");
        addButton(exitButton);
    }

    public JButton getPlayButton() {
        return playButton;
    }

    public JButton getCreateButton() {
        return createButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
