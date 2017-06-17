package OldProject.Editor;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Carla on 15/03/2016.
 */
public class FrameEd {

    public static void main(String[] args) {

        JFrame frame = new JFrame();


        frame.setLayout(new BorderLayout());

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);


        frame.setTitle("EDITOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        EditorPanel editor = new EditorPanel();
        editor.setBackground(Color.WHITE);
        frame.add(editor);

        frame.setVisible(true);

    }
}
