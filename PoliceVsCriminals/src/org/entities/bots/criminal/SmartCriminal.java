package org.entities.bots.criminal;

import org.algorithms.pathfinding.Grid2d;
import org.entities.bots.Bot;
import org.map.Grid;

import java.awt.*;

/**
 * Created by Tony on 17/06/2017.
 */
public class SmartCriminal extends Bot {

    public SmartCriminal() {
        super("EVADER1");
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


        int closestPoliceIndex = 0;
        int closestPoliceDistance = 1000;
        int currentDistanceToPolice = 0;

        int index = 0;
        for (Point policeLocation : this.getGrid().getPoliceLocations()) {
            java.util.List<Grid2d.MapNode> pathfindingmoves = getGrid().findBestPathtoPolice(this.getLocation(), policeLocation);
            currentDistanceToPolice = pathfindingmoves.size();
            if (currentDistanceToPolice < closestPoliceDistance) {
                closestPoliceIndex = index;
                closestPoliceDistance = currentDistanceToPolice;
            }
            index++;
        }

        if (closestPoliceDistance < 8) {
            index = 0;
            int maxdistance = 0;
            int bestMoveIndex = 0;
            for (Point location : this.getAvailableMoves()) {
                int distance = getGrid().findBestPathtoCriminal(location, this.getGrid().getPoliceLocations().get(closestPoliceIndex)).size();
                if (distance > maxdistance) {
                    maxdistance = distance;
                    bestMoveIndex = index;
                }
                index++;
            }
            return bestMoveIndex;
        } else {
            index = 0;
            int maxTotalDistance = 0;
            int bestMoveIndex = 0;
            int totalDistance = 0;
            for (Point location : this.getAvailableMoves()) {
                for (Point policeLocation : this.getGrid().getPoliceLocations()) {
                    totalDistance += getGrid().findBestPathtoCriminal(location, policeLocation).size();
                }
                if (totalDistance >= maxTotalDistance) {
                    maxTotalDistance = totalDistance;
                    bestMoveIndex = index;
                }
                index++;
                totalDistance = 0;
            }
            return bestMoveIndex;
        }

    }
}
