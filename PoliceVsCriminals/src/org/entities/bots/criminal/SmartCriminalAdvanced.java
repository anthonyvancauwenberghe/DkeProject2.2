package org.entities.bots.criminal;

import org.entities.bots.Bot;
import org.map.Grid;

import java.awt.*;

/**
 * Created by Tony on 17/06/2017.
 */
public class SmartCriminalAdvanced extends Bot {

    public SmartCriminalAdvanced() {
        super("SMARTCRIMINAL");
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

        if (getGrid().getCriminalLocations().size() == 0) {
            return 0;
        }

        int index = 0;

        java.util.List path = getGrid().findBestWeightedPathAwayFromPolice(getLocation());

        if (path != null && path.size() > 1) {
            Point move = getGrid().findBestWeightedPathAwayFromPolice(getLocation()).get(1).toPoint();

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
        return 0;
    }

}

