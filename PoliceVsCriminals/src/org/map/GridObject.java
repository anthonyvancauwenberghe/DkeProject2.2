package org.map;

import org.map.objects.Criminal;
import org.map.objects.Floor;
import org.map.objects.Police;
import org.map.objects.Wall;

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

    public static GridObject getObjectFromString(String option) {
        if (option == null) {
            return null;
        }
        GridObject[] objects = new GridObject[]{new Criminal(), new Wall(), new Police(), new Floor()};
        for (GridObject obj : objects) {
            if (obj.toString().equals(option)) {
                return obj;
            }
        }
        return null;
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
        return this instanceof Criminal;
    }

    public boolean isPursuiter() {
        return this instanceof Police;
    }

    public boolean isEntity() {
        return this instanceof Police || this instanceof Criminal;
    }
}
