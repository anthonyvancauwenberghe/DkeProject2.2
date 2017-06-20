package org.game;

import org.map.GridObject;

/**
 * Created by Krulvis on 20-Jun-17.
 */
public abstract class Turn<E extends GridObject> {

    private boolean isBot;
    private E object;

    public Turn(E object, boolean isBot) {
        this.isBot = isBot;
        this.object = object;
    }

    public boolean isBot() {
        return isBot;
    }

    public void setBot(boolean bot) {
        isBot = bot;
    }

    public abstract boolean perform();

    public E getObject() {
        return object;
    }

}
