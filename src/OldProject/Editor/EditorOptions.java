package OldProject.Editor;

import java.awt.*;

/**
 * Created by Tony on 6/8/2017.
 */
public enum EditorOptions {
    FLOOR("FLOOR", Color.lightGray),
    WALL("WALL", Color.darkGray),
    EVADER("EVADER", Color.blue),
    PURSUITER("PURSUITER", Color.yellow);


    private String option;
    private Color color;

    EditorOptions(String option, Color color) {
        this.option = option;
        this.color = color;
    }

    public String toString() {
        return option;
    }

    public Color getColor() {
        return color;
    }
};
