package Map;

import Map.Objects.Evader;
import Map.Objects.Floor;
import Map.Objects.Pursuiter;
import Map.Objects.Wall;

import java.awt.*;

/**
 * Created by Tony on 17/06/2017.
 */
abstract public class GridObject {

    private String option;
    private Color color;
    private int id;

    public GridObject(int id, String option, Color color) {
        this.id = id;
        this.option = option;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return option;
    }

    public Color getColor() {
        return color;
    }

    public boolean isFloor() {
        return this instanceof Floor;
    }

    public boolean isWall() {
        return this instanceof Wall;
    }

    public boolean isEvader() {
        return this instanceof Evader;
    }

    public boolean isPursuiter() {
        return this instanceof Pursuiter;
    }

    public boolean isEntity() {
        return this instanceof Pursuiter || this instanceof Evader;
    }

    public static GridObject getObjectFromString(String option) {
        if (option == null) {
            return null;
        }
        GridObject[] objects = new GridObject[]{new Evader(), new Wall(), new Pursuiter(), new Floor()};
        for (GridObject obj : objects) {
            if (obj.toString().equals(option)) {
                return obj;
            }
        }
        return null;
    }
}
