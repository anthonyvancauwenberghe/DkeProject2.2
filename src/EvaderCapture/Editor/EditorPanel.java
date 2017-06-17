package EvaderCapture.Editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class EditorPanel extends JPanel {

    private JButton saveButton;
    private JButton loadButton;

    public int pixelSIZE = 20;

    private RadioButtons buttons;

    public JComboBox[] agentList;

    private Grid grid;

    public EditorPanel() {
        this.grid = new Grid();
        setLayout(new BorderLayout());

        JPanel settingPanel = new JPanel();
        settingPanel.setLayout(new BorderLayout());

        JPanel loadSave = new JPanel();
        loadSave.setLayout(new GridLayout(2, 1));

        JPanel settings = new JPanel();
        settings.setLayout(new GridLayout(6, 1));

        buttons = new RadioButtons();
        initLoadSavePanel();

    }

    public void initLoadSavePanel() {
        JPanel settingPanel = new JPanel();
        settingPanel.setLayout(new BorderLayout());

        JPanel loadSave = new JPanel();
        loadSave.setLayout(new GridLayout(2, 1));

        JPanel settings = new JPanel();
        settings.setLayout(new GridLayout(6, 1));

        this.saveButton = new JButton("SAVE");
        this.saveButton.setBackground(Color.lightGray);
        this.saveButton.setForeground(Color.darkGray);
        this.saveButton.setBorderPainted(false);
        this.saveButton.setFont(new Font("Century Gothic", Font.BOLD, 30));
        this.saveButton.setSize(new Dimension(20, 20));

        this.loadButton = new JButton("LOAD");
        this.loadButton.setBackground(Color.lightGray);
        this.loadButton.setForeground(Color.darkGray);
        this.loadButton.setBorderPainted(false);
        this.loadButton.setFont(new Font("Century Gothic", Font.BOLD, 30));


        settingPanel.add(settings, BorderLayout.NORTH);
        loadSave.add(this.loadButton);
        loadSave.add(this.saveButton);

        settingPanel.add(loadSave, BorderLayout.WEST);
        settingPanel.add(buttons, BorderLayout.EAST);
        add(settingPanel, BorderLayout.EAST);
    }

    public EditorOptions getSelectionEditorOption() {
        return this.buttons.getSelectedOption();
    }


    public JLayeredPane drawGrid() {

        class ChoiceListener implements MouseListener {
            private Point startDrag;

            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

            }

            public void mousePressed(MouseEvent e) {
                startDrag = new Point(e.getX(), e.getY());
            }


            public void mouseReleased(MouseEvent e) {
                startDrag = null;
                repaint();
            }


            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

        }
        return new JLayeredPane();
    }

    public void writeItDown(LinkedList<String> list, int i) {
        File field = new File("Slot" + i + ".txt");
        FileWriter writeFile = null;

        // allows us to write the file

        PrintWriter writer = null;
        Scanner inWriteDown = null;
        try {
            writeFile = new FileWriter(field);
            writer = new PrintWriter(writeFile);
            inWriteDown = new Scanner(field);

            for (String str : list) {
                writer.write(str + "\r\n");
            }
        } catch (Exception e) {
            // errors
        } finally // closes the writer
        {
            try {
                if (writer != null)
                    writer.close();
                if (inWriteDown != null)
                    inWriteDown.close();
            } catch (Exception e) {
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        /*
        if (layerList.getSelectedIndex()==-1) {
            g2.setFont(new Font("Century Gothic", Font.BOLD, 21));
            g2.drawString("Please select a layer, thank you!", 150, 200);
        }
        else {

            for (int i = 0; i < rectangleGrid.length; i++) {
                for (int j = 0; j < rectangleGrid[0].length; j++) {

                    if (stringGrid[i][j].equals("W")) {
                        g2.setPaint(Color.RED);
                        g2.fill(rectangleGrid[i][j]);
                    }
                    if (stringGrid[i][j].equals("Q")) {
                        g2.setPaint(new Color(0xFFBEC6));
                        g2.fill(rectangleGrid[i][j]);
                    }
                    if (stringGrid[i][j].equals("S")) {
                        g2.setPaint(Color.orange);
                        g2.fill(rectangleGrid[i][j]);
                    }
                    if (stringGrid[i][j].equals("F")) {
                        g2.setPaint(green);
                        g2.fill(rectangleGrid[i][j]);
                    }
                    if (stringGrid[i][j].equals("B")) {
                        g2.setPaint(gray);
                        g2.fill(rectangleGrid[i][j]);
                    }
                    if (stringGrid[i][j].equals("H")) {
                        g2.setPaint(black);
                        g2.fill(rectangleGrid[i][j]);
                    }
                    if (stringGrid[i][j].equals("L")) {
                        g2.setPaint(yellow);
                        g2.fill(rectangleGrid[i][j]);
                    }
                    if (stringGrid[i][j].equals("C")) {
                        g2.setPaint(pink);
                        g2.fill(rectangleGrid[i][j]);
                    }
                    if (stringGrid[i][j].equals("R")) {
                        g2.setPaint(new Color(0xC6774A));
                        g2.fill(rectangleGrid[i][j]);
                    }
                    if (stringGrid[i][j].equals("P")) {
                        g2.setPaint(Color.BLUE);
                        g2.fill(rectangleGrid[i][j]);
                    }
                    if (stringGrid[i][j].equals("K")) {
                        g2.setPaint(Color.cyan);
                    }
                    if (stringGrid[i][j].equals("M") || stringGrid[i][j].equals("MM")) {
                        g2.setPaint(new Color(0xB7FF56));
                        g2.fill(rectangleGrid[i][j]);
                    }
                    if (startEndStringGrid[i][j].equals("LS") || startEndStringGrid[i][j].equals("LSS") || startEndStringGrid[i][j].equals("LE") || startEndStringGrid[i][j].equals("LEE")) {
                        g2.setPaint(new Color(0xFFD109));
                        g2.fill(rectangleGrid[i][j]);
                    }
                    g2.setPaint(Color.lightGray);
                    g2.draw(rectangleGrid[i][j]);
                }
            }

        }
        */
    }

    public Grid getGrid() {
        return grid;
    }

}