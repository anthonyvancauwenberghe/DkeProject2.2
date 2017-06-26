package org.map;

import org.entities.Entity;

import java.awt.*;

/**
 * Created by Tony on 23/06/2017.
 */
public abstract class EntityObject extends GridObject {

    protected Entity entity;

    public EntityObject(int id, String option, Color color) {
        super(id, option, color);
    }

    public EntityObject(int id, String option, Color color, String imageLocation) {
        super(id, option, color, imageLocation);
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

}
