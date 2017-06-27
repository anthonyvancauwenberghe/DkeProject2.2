package org.entities;

import org.Game;
import org.map.EntityObject;
import org.map.Grid;
import org.map.objects.Criminal;
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

    public void setLocation(Point nextLocation) {
        Grid grid = getGrid();
        if (grid != null && this.location != null) {
            if (grid.getGridArray()[nextLocation.x][nextLocation.y].hasEntity()) {
                EntityObject entityObject = (EntityObject) grid.getGridArray()[this.location.x][this.location.y];
                if (grid.getGridArray()[nextLocation.x][nextLocation.y].isCriminal()) {
                    Criminal criminal = (Criminal) grid.getGridArray()[nextLocation.x][nextLocation.y];
                    criminal.setCaught();
                    grid.getGridArray()[nextLocation.x][nextLocation.y] = entityObject;
                    grid.getGridArray()[this.location.x][this.location.y] = new Floor();
                } else if (grid.getGridArray()[nextLocation.x][nextLocation.y].isPolice()) {
                    grid.getGridArray()[this.location.x][this.location.y] = new Floor();
                }
            }


            System.out.println("Setting: " + toString() + " from [" + this.location.x + "][" + this.location.y + "], to [" + nextLocation.x + "][" + nextLocation.y + "]");
        }
        this.location = nextLocation;
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

        if (isPossibleMove(new Point(location.x - 1, location.y), grid))
            availableLocations.add(new Point(location.x - 1, location.y));

        if (isPossibleMove(new Point(location.x, location.y + 1), grid))
            availableLocations.add(new Point(location.x, location.y + 1));

        if (isPossibleMove(new Point(location.x, location.y - 1), grid))
            availableLocations.add(new Point(location.x, location.y - 1));

        return availableLocations;
    }

    public boolean isPossibleMove(Point point, Grid grid) {
        return point.x >= 0 && point.y >= 0 && point.x < grid.getGridArray().length && point.y < grid.getGridArray().length && grid.getGridArray()[point.x][point.y].isFloor();
    }

    public Grid getGrid() {
        return game != null && game.getGrid() != null ? game.getGrid() : null;
    }

}
