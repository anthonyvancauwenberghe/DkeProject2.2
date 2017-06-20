package org.Menu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by s120619 on 17-6-2017.
 */
public class LoadScreen extends JWindow {

    public LoadScreen(ImageIcon imageIcon) {
        try {
            JLabel imageLabel = new JLabel();
            imageLabel.setIcon(imageIcon);
            JPanel southPanel = new JPanel();

            getContentPane().setLayout(new BorderLayout());
            southPanel.setLayout(new FlowLayout());
            southPanel.setBackground(Color.WHITE);
            getContentPane().add(imageLabel, BorderLayout.CENTER);
            getContentPane().add(southPanel, BorderLayout.SOUTH);
            pack();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setScreenVisible(boolean b) {
        final boolean boo = b;
        SwingUtilities.invokeLater(() -> setVisible(boo));
    }

    @Override
    public void dispose(){
        setVisible(false);
        super.dispose();
    }

}
