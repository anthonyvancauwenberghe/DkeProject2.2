package org.entities;

import java.awt.*;

/**
 * Created by Tony on 17/06/2017.
 */
public abstract class Entity {

    private String name;

    /*
    Point on the grid that the entity is currently on
     */
    private Point location;

    public Entity(String name) {
        this.name = name;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return this.name.toUpperCase();
    }
}
