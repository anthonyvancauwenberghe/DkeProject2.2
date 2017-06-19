package game.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by s120619 on 19-6-2017.
 */
public class MainMenu extends Menu {

    private JButton playButton;
    private JButton createButton;
    private JButton exitButton;
    private MainFrame mainFrame;

    public MainMenu(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        //PLAY button
        playButton = new JButton("PLAY");
        addButton(playButton);
        //Create YOur map button
        createButton = new JButton("CREATE YOUR MAP");
        addButton(createButton);
        //EXIT button
        exitButton = new JButton("EXIT");
        addButton(exitButton);

        /**
         * Add action listener to Create button to start Editor Panel.
         */
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.startEditorPanel();
                /**
                 * Dispose of MainMenu
                 */
                setVisible(false);
            }
        });
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
