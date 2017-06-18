package Entities;

import java.awt.*;

/**
 * Created by Tony on 17/06/2017.
 */
public abstract class Entity {

    /*
    Point on the grid that the entity is currently on
     */
    private Point location;

    public Entity() {

    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
