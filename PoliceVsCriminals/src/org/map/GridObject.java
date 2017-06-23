package org.map;

import org.entities.Entity;
import org.entities.bots.RandomBotAlgorithm;
import org.entities.bots.criminal.EvadeBotAlgorithm1;
import org.entities.bots.police.CaptureBotAlgorithm1;
import org.entities.players.Player;
import org.map.objects.*;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Tony on 17/06/2017.
 */
abstract public class GridObject {

    private String option;
    private Color color;
    private int id;

    public GridObject(int id, String option, Color color) {
        this.id = id;
        this.option = option;
        this.color = color;
    }

    public GridObject(int id, String option, Color color, BufferedImage image) {
        this.id = id;
        this.option = option;
        this.color = color;
    }

    /**
     * Loads GridObject with it's corresponding Entity from a string.
     *
     * @param option
     * @return
     */
    public static GridObject getObjectFromString(String option) {
        if (option == null) {
            return null;
        }
        /*
        Make vars just for checking the names
         */
        GridObject[] objects = new GridObject[]{new Criminal(), new Wall(), new Police(), new Floor()};
        Entity[] entities = new Entity[]{new EvadeBotAlgorithm1(), new CaptureBotAlgorithm1(), new Player(), new RandomBotAlgorithm()};

        for (GridObject obj : objects) {
            if (option.toUpperCase().contains(obj.toString())) {
                if (obj instanceof Controllable && option.contains(",")) {
                    String eString = option.substring(option.indexOf(",") + 1);
                    if (eString.length() > 0) {
                        for (Entity e : entities) {
                            if (eString.toUpperCase().equals(e.toString())) {
                                ((Controllable) obj).setEntity(e);
                                break;
                            }
                        }
                    }
                }
                return obj;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public String getOption() {
        return option;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(option);
        if (this instanceof Controllable) {
            Entity e = ((Controllable) this).getEntity();
            if (e != null) {
                System.out.println("Entity of: " + option + " = " + e.toString());
                str.append(",");
                str.append(e.toString());
            } else {
                System.out.println("Entity of: " + option + " = null");
            }
        }
        return str.toString().toUpperCase();
    }

    public Color getColor() {
        return color;
    }

    public boolean isFloor() {
        return this instanceof Floor;
    }

    public boolean isWall() {
        return this instanceof Wall;
    }

    public boolean isCriminal() {
        return this instanceof Criminal;
    }

    public boolean isPolice() {
        return this instanceof Police;
    }

    public boolean hasEntity() {
        return this instanceof Controllable;
    }

}
