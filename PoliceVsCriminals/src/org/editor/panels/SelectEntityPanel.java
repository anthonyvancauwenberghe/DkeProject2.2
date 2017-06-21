package org.editor.panels;

import org.entities.Entity;
import org.entities.bots.criminal.EvadeBotAlgorithm1;
import org.entities.bots.police.CaptureBotAlgorithm1;
import org.entities.players.Player;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Krulvis on 21-Jun-17.
 */
public class SelectEntityPanel extends JPanel {

    private JPanel criminalEntitiesPanel;
    private JPanel policeEntitiesPanel;

    private Entity selectedEntity;

    public SelectEntityPanel() {

        setCriminalEntitiesPanel();
        setPoliceEntitiesPanel();
        add(criminalEntitiesPanel);
        add(policeEntitiesPanel);
        showNothing();
        setBorder(new LineBorder(Color.BLACK));
        setVisible(true);
    }

    private void setCriminalEntitiesPanel() {
        criminalEntitiesPanel = new JPanel();
        Entity[] evaders = new Entity[]{new EvadeBotAlgorithm1(), new Player()};
        JComboBox<Entity> entityComboBox = new JComboBox<>(evaders);
        entityComboBox.setBackground(Color.lightGray);
        entityComboBox.setForeground(Color.darkGray);
        entityComboBox.setFont(new Font("Century Gothic", Font.BOLD, 30));
        entityComboBox.setFocusable(false);
        entityComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedEntity = (Entity)entityComboBox.getSelectedItem();
            }
        });
        criminalEntitiesPanel.add(entityComboBox);

    }

    private void setPoliceEntitiesPanel() {
        policeEntitiesPanel = new JPanel();
        Entity[] captures = new Entity[]{new CaptureBotAlgorithm1(), new Player()};
        JComboBox<Entity> entityComboBox = new JComboBox<>(captures);
        entityComboBox.setBackground(Color.lightGray);
        entityComboBox.setForeground(Color.darkGray);
        entityComboBox.setFont(new Font("Century Gothic", Font.BOLD, 30));
        entityComboBox.setFocusable(false);
        entityComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedEntity = (Entity)entityComboBox.getSelectedItem();
            }
        });
        policeEntitiesPanel.add(entityComboBox);
    }

    public void showNothing() {
        selectedEntity = null;
        criminalEntitiesPanel.setVisible(false);
        policeEntitiesPanel.setVisible(false);
    }

    public void showCapturers() {
        selectedEntity = null;
        criminalEntitiesPanel.setVisible(false);
        policeEntitiesPanel.setVisible(true);
    }

    public void showEvaders() {
        selectedEntity = null;
        criminalEntitiesPanel.setVisible(true);
        policeEntitiesPanel.setVisible(false);
    }


    public Entity getSelectedEntity() {
        return selectedEntity;
    }

}
