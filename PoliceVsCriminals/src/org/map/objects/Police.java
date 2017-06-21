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
public class Police extends GridObject implements Controllable {

    private static BufferedImage image;
    private Entity entity;
    public Police() {
        super(3, "POLICE", Color.blue);
    }

    public static BufferedImage getImage() {
        if (Police.image == null) {
            BufferedImage image = null;
            try {
                image = ImageIO.read(new File("images/police.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            Police.image = image;
        }

        return Police.image;
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
