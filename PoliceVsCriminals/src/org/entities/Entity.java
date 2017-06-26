package org.entities;

import org.map.EntityObject;
import org.map.Grid;
import org.map.objects.Floor;

import java.awt.*;
import java.util.ArrayList;

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

    public void setLocation(Point location, Grid grid) {
        EntityObject entityObject = (EntityObject) grid.getGridArray()[this.location.x][this.location.y];
        grid.getGridArray()[this.location.x][this.location.y] = new Floor();
        grid.getGridArray()[location.x][location.y] = entityObject;
        this.location = location;
    }

    @Override
    public String toString() {
        return this.name.toUpperCase();
    }

    public ArrayList<Point> getAvailableNextLocations(Grid grid) {
        Point location = this.getLocation();
        ArrayList<Point> availableLocations = new ArrayList<Point>();


        if (isPossibleMove(new Point(location.x + 1, location.y), grid))
            availableLocations.add(new Point(location.x + 1, location.y));
        else if (isPossibleMove(new Point(location.x - 1, location.y), grid))
            availableLocations.add(new Point(location.x - 1, location.y));
        else if (isPossibleMove(new Point(location.x, location.y + 1), grid))
            availableLocations.add(new Point(location.x, location.y + 1));
        else if (isPossibleMove(new Point(location.x, location.y - 1), grid))
            availableLocations.add(new Point(location.x, location.y - 1));

        return availableLocations;
    }

    public boolean isPossibleMove(Point point, Grid grid) {
        if (point.x >= 0 && point.y >= 0 && point.x < grid.getGridArray().length && point.y < grid.getGridArray().length)
            return grid.getGridArray()[point.x][point.y].isFloor();
        else
            return false;
    }

}
