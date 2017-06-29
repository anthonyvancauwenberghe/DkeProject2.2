package org.entities;

import org.Game;
import org.map.EntityObject;
import org.map.Grid;
import org.map.GridObject;
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
    private Point currentLocation;

    public Entity(String name) {
        this(name, null);
    }

    public Entity(String name, Game game) {
        this.name = name;
        this.game = game;
    }

    public Point getLocation() {
        return currentLocation;
    }

    public void setLocation(Point nextLocation) {
        Grid grid = getGrid();
        if (grid != null && this.currentLocation != null) {
            GridObject movingEntity = grid.getGridArray()[this.currentLocation.x][this.currentLocation.y];
            GridObject moveToObject = grid.getGridArray()[nextLocation.x][nextLocation.y];

            if (moveToObject.hasEntity()) {

                if (moveToObject.isCriminal() && movingEntity.isPolice()) {

                    Criminal criminal = (Criminal) moveToObject;
                    criminal.setCaught();
                    grid.getGridArray()[nextLocation.x][nextLocation.y] = movingEntity;

                } else if (moveToObject.isPolice() && movingEntity.isCriminal()) {
                    Criminal criminal = (Criminal) movingEntity;
                    criminal.setCaught();
                } else {
                    grid.getGridArray()[nextLocation.x][nextLocation.y] = movingEntity;
                }
            } else {
                grid.getGridArray()[nextLocation.x][nextLocation.y] = movingEntity;
            }
            grid.getGridArray()[this.currentLocation.x][this.currentLocation.y] = new Floor();
            System.out.println("Setting: " + toString() + " from[" + this.currentLocation.x + "][" + this.currentLocation.y + "], to[" + nextLocation.x + "][" + nextLocation.y + "]");
        }
        this.currentLocation = nextLocation;

    }

    public EntityObject getEntityObject() {
        return (EntityObject) getGrid().getGridArray()[this.currentLocation.x][this.currentLocation.y];
    }

    public GridObject getGridObject() {
        return getGrid().getGridArray()[this.currentLocation.x][this.currentLocation.y];
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
        if (getGridObject().isPolice())
            return point.x >= 0 && point.y >= 0 && point.x < grid.getGridArray().length && point.y < grid.getGridArray().length && (grid.getGridArray()[point.x][point.y].isFloor() || grid.getGridArray()[point.x][point.y].isCriminal());
        else if (getGridObject().isCriminal())
            return point.x >= 0 && point.y >= 0 && point.x < grid.getGridArray().length && point.y < grid.getGridArray().length && (grid.getGridArray()[point.x][point.y].isFloor() || grid.getGridArray()[point.x][point.y].isPolice());
        else
            return point.x >= 0 && point.y >= 0 && point.x < grid.getGridArray().length && point.y < grid.getGridArray().length && (grid.getGridArray()[point.x][point.y].isFloor());
    }

    public Grid getGrid() {
        return game != null && game.getGrid() != null ? game.getGrid() : null;
    }


}
