package Menu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by s120619 on 17-6-2017.
 */
public class LoadScreen extends JWindow {

    private JLabel imageLabel = new JLabel();
    private JPanel southPanel = new JPanel();

    public LoadScreen(ImageIcon imageIcon) {
        try {
            imageLabel.setIcon(imageIcon);
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

}
