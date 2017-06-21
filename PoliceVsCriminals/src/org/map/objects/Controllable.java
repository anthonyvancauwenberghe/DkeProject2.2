package org.map.objects;

import org.entities.Entity;

/**
 * Created by Krulvis on 21-Jun-17.
 * This class is used to determine what entity controlls the GridObject
 */
public interface Controllable {

    public Entity getEntity();

    public void setEntity(Entity entity);
}
