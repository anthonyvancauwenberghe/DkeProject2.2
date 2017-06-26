package org.entities;

import org.Game;
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
    private Game game;
    /*
    Point on the grid that the entity is currently on
     */
    private Point location;

    public Entity(String name) {
        this(name, null);
    }

    public Entity(String name, Game game) {
        this.name = name;
        this.game = game;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        Grid grid = getGrid();
        if (grid != null && this.location != null) {
            EntityObject entityObject = (EntityObject) grid.getGridArray()[this.location.x][this.location.y];
            grid.getGridArray()[this.location.x][this.location.y] = new Floor();
            grid.getGridArray()[location.x][location.y] = entityObject;
            System.out.println("Setting: " + toString() + " from[" + this.location.x + "][" + this.location.y + "], to[" + location.x + "][" + location.y + "]");
        }
        this.location = location;
    }

    public void setGame(Game game) {
        this.game = game;
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

    public Grid getGrid() {
        return game != null && game.getGrid() != null ? game.getGrid() : null;
    }

}
