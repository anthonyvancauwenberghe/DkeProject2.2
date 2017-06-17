package Editor;

import Editor.Panels.EditorPanel;

import javax.swing.*;

/**
 * Created by Tony on 17/06/2017.
 */
public class Editor {

    public Editor() {
        JPanel panel = new EditorPanel();
        panel.setVisible(true);

        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(1024, 768);
    }

    public static void main(String[] args) {
        Editor editor = new Editor();
    }
}
