package org.map;

import org.entities.Entity;
import org.map.objects.Controllable;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Tony on 23/06/2017.
 */
public class EntityObject extends GridObject implements Controllable {

    protected Entity entity;

    public EntityObject(int id, String option, Color color) {
        super(id, option, color);
    }

    public EntityObject(int id, String option, Color color, BufferedImage image) {
        super(id, option, color, image);
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
}
