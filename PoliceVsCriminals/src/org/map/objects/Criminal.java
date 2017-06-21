package org.map.objects;

import org.entities.Entity;
import org.map.GridObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Tony on 17/06/2017.
 */
public class Criminal extends GridObject implements Controllable {
    private static BufferedImage image;
    private Entity entity;

    public Criminal() {
        super(2, "CRIMINAL", Color.yellow);
    }

    public static BufferedImage getImage() {
        if (Criminal.image == null) {
            BufferedImage image = null;
            try {
                image = ImageIO.read(new File("images/criminal.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            Criminal.image = image;
        }

        return Criminal.image;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }

    @Override
    public void setEntity(Entity entity) {
        this.entity = entity;
    }
}
