package org.entities.bots;

import org.Game;
import org.entities.Algorithm;
import org.entities.Entity;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Tony on 17/06/2017.
 */
abstract public class Bot extends Entity implements Algorithm {

    public boolean groupMoveAlgorithm = false;
    public ArrayList<Point> availableMoves;

    public Bot(String name) {
        super(name);
    }

    public Bot(String name, Game game) {
        super(name, game);
    }

    public ArrayList<Point> getAvailableMoves() {
        return this.getAvailableNextLocations(getGrid());
    }
}
