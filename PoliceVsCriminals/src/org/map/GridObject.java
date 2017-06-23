package org.map;

import org.entities.Entity;
import org.entities.bots.RandomBotAlgorithm;
import org.entities.bots.criminal.EvadeBotAlgorithm1;
import org.entities.bots.police.CaptureBotAlgorithm1;
import org.entities.players.Player;
import org.map.objects.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Tony on 17/06/2017.
 */
abstract public class GridObject {

    private String option;
    private Color color;
    private int id;
    private String imageLocation;
    private BufferedImage image;

    public GridObject(int id, String option, Color color) {
        this(id, option, color, null);
    }

    public GridObject(int id, String option, Color color, String imageLocation) {
        this.id = id;
        this.option = option;
        this.color = color;
        this.imageLocation = imageLocation;
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
                if (obj instanceof EntityObject && option.contains(",")) {
                    String eString = option.substring(option.indexOf(",") + 1);
                    if (eString.length() > 0) {
                        for (Entity e : entities) {
                            if (eString.toUpperCase().equals(e.toString())) {
                                ((EntityObject) obj).setEntity(e);
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
        StringBuilder sb = new StringBuilder(option);
        if (this instanceof EntityObject) {
            Entity e = ((EntityObject) this).getEntity();
            if (e != null) {
                sb.append(",");
                sb.append(e.toString());
            }
        }
        return sb.toString().toUpperCase();
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
        return this instanceof EntityObject;
    }

    public BufferedImage getImage() {
        if (image == null && this.imageLocation != null) {
            BufferedImage im = null;
            try {
                im = ImageIO.read(new File(this.imageLocation));
            } catch (Exception e) {
                e.printStackTrace();
            }
            image = im;
        }
        return image;
    }
}
