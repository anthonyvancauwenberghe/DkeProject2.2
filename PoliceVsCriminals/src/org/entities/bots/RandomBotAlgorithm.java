package org.entities.bots;

import org.Game;
import org.map.Grid;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Tony on 17/06/2017.
 */
public class RandomBotAlgorithm extends Bot {

    public RandomBotAlgorithm() {
        super("RANDOM");
    }

    @Override
    public void move() {
        Grid grid = getGrid();
        if (grid != null) {
            int listLength = this.getAvailableNextLocations(grid).size();

            if (listLength == 0) {
                System.out.println("no moves available you are trapped");
            } else {
                int moveIndex = ThreadLocalRandom.current().nextInt(0, listLength);
                System.out.println("executing move x:" + this.getAvailableNextLocations(grid).get(moveIndex).x + " y: " + this.getAvailableNextLocations(grid).get(moveIndex).y);
                this.setLocation(this.getAvailableNextLocations(grid).get(moveIndex));
            }
        }
    }

}
