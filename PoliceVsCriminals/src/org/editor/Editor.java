package org.editor;

import org.editor.panels.EditorPanel;

import javax.swing.*;

/**
 * Created by Tony on 17/06/2017.
 */
public class Editor {

    public Editor() {
        JPanel panel = new EditorPanel(null);
        panel.setVisible(true);

        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(1024, 768);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Editor editor = new Editor();
    }
}
