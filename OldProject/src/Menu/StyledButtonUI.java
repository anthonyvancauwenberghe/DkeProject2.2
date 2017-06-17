package Menu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class StyledButtonUI extends BasicButtonUI {


    public void installUI(JComponent c) {
        super.installUI(c);
        AbstractButton button = (AbstractButton) c;
        button.setOpaque(false);
//        button.setPreferredSize(new Dimension(200,3));
        button.setBorder(new EmptyBorder(1, 100, 1, 100));
    }

    public void paint(Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        paintBackground(g, b, b.getModel().isRollover());
        super.paint(g, c);


    }

    private void paintBackground(Graphics g, JComponent c, boolean roll) {
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (roll) {
            c.setBackground(new Color(210, 210, 210, 200));
            c.setForeground(Color.BLACK);
        }
        if (!roll) {
            c.setBackground(new Color(0, 0, 0, 200));
            c.setForeground(Color.WHITE);
        }
        g.setColor(c.getBackground());
        g.fillRect(0, 0, size.width, size.height);
    }
}