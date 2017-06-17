package OldProject.Editor;

import java.awt.*;

/**
 * Created by Carla on 11/04/2016.
 */


public class GridElement {

    private EditorOptions elementType;
    private Rectangle rectangle;

    public GridElement(EditorOptions elementType, Position position) {
        this.elementType = elementType;
        this.rectangle = new Rectangle(20 * position.getX(), 20 * position.getY(), 20, 20);
    }
}