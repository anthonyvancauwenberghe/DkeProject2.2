package org.game.turn;

import org.map.objects.Criminal;

/**
 * Created by Tony on 20-Jun-17.
 */
public class PoliceTurn extends Turn<Criminal> {

    public PoliceTurn(Criminal entity, boolean isBot) {
        super(entity, isBot);
    }

    @Override
    public boolean perform() {
        return false;
    }
}
