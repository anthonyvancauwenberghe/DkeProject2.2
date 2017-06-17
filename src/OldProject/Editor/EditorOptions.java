package OldProject.Editor;

import java.awt.*;

/**
 * Created by Tony on 6/8/2017.
 */
public enum EditorOptions {
    WALL("WALL", Color.darkGray),
    EVADER("EVADER", Color.blue),
    PURSUITER("PURSUITER", Color.yellow),
    FLOOR("FLOOR", Color.lightGray);

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
