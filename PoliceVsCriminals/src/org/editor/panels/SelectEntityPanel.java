package org.editor.panels;

import org.entities.Entity;
import org.entities.bots.RandomBotAlgorithm;
import org.entities.bots.criminal.EvadeBotAlgorithm1;
import org.entities.bots.police.CaptureBotAlgorithm1;
import org.entities.bots.police.MCTSBotAlgorithm;
import org.entities.bots.police.ShortestPathBotAlgorithm;
import org.entities.players.Player;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by Tony on 21-Jun-17.
 */
public class SelectEntityPanel extends JPanel {

    private JComboBox<Entity> crimiComboBox;
    private JComboBox<Entity> policeComboBox;

    public SelectEntityPanel() {

        setCriminalEntitiesPanel();
        setPoliceEntitiesPanel();
        add(crimiComboBox);
        add(policeComboBox);
        showNothing();
        setBorder(new LineBorder(Color.BLACK));
        setVisible(true);
        setFocusable(false);
    }

    private void setCriminalEntitiesPanel() {
        Entity[] evaders = new Entity[]{new EvadeBotAlgorithm1(), new Player(), new RandomBotAlgorithm()};
        crimiComboBox = new JComboBox<>(evaders);
        crimiComboBox.setBackground(Color.lightGray);
        crimiComboBox.setForeground(Color.darkGray);
        crimiComboBox.setFont(new Font("Century Gothic", Font.BOLD, 30));
        crimiComboBox.setFocusable(false);


    }

    private void setPoliceEntitiesPanel() {
        Entity[] captures = new Entity[]{new CaptureBotAlgorithm1(), new Player(), new RandomBotAlgorithm(), new MCTSBotAlgorithm(), new ShortestPathBotAlgorithm()};
        policeComboBox = new JComboBox<>(captures);
        policeComboBox.setBackground(Color.lightGray);
        policeComboBox.setForeground(Color.darkGray);
        policeComboBox.setFont(new Font("Century Gothic", Font.BOLD, 30));
        policeComboBox.setFocusable(false);

    }

    public void showNothing() {
        policeComboBox.setVisible(false);
        crimiComboBox.setVisible(false);
    }

    public void showCapturers() {
        policeComboBox.setSelectedItem(0);
        crimiComboBox.setVisible(false);
        policeComboBox.setVisible(true);
    }

    public void showEvaders() {
        crimiComboBox.setSelectedIndex(0);
        crimiComboBox.setVisible(true);
        policeComboBox.setVisible(false);
    }


    public Entity getSelectedEntity() {
        if (crimiComboBox.isVisible()) {
            return (Entity) crimiComboBox.getSelectedItem();
        } else if (policeComboBox.isVisible()) {
            return (Entity) policeComboBox.getSelectedItem();
        }
        return null;
    }

}
