package org.entities.bots.police;

import org.algorithms.pathfinding.Grid2d;
import org.entities.bots.Bot;
import org.map.Grid;

import java.awt.*;

/**
 * Created by Tony on 17/06/2017.
 */
public class Call911Algorithm extends Bot {

    public Call911Algorithm() {
        super("PATH");
    }

    @Override
    public void move() {
        Grid grid = getGrid();
        if (grid != null) {
            if (this.getAvailableMoves().size() == 0) {
                System.out.println("no moves available you are trapped");
            } else {

                this.setLocation(this.getAvailableNextLocations(grid).get(getMove()));
            }
        }
    }

    private int getMove() {

        int closestCriminalIndex = 0;
        int previousDistanceToCriminal = 1000;
        int currentDistanceToCriminal = 0;

        if (getGrid().getCriminalLocations().size() == 0) {
            return 0;
        }

        int index = 0;
        for (Point criminalLocation : this.getGrid().getCriminalLocations()) {
            java.util.List<Grid2d.MapNode> pathfindingmoves = getGrid().findBestPathtoCriminal(this.getLocation(), criminalLocation);
            currentDistanceToCriminal = pathfindingmoves.size();
            if (currentDistanceToCriminal < previousDistanceToCriminal)
                closestCriminalIndex = index;
            index++;
        }

        Point move = getGrid().findBestPathtoCriminal(this.getLocation(), this.getGrid().getCriminalLocations().get(closestCriminalIndex)).get(1).toPoint();


        index = 0;
        int bestMoveIndex = 0;
        for (Point availableMove : this.getAvailableMoves()) {
            if (availableMove.equals(move)) {
                bestMoveIndex = index;
            }
            index++;

        }
        return bestMoveIndex;
    }

}
