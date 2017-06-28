package org.game.turn;

import org.map.objects.Criminal;

/**
 * Created by Tony on 20-Jun-17.
 */
public class CriminalTurn extends Turn<Criminal> {

    public CriminalTurn(Criminal entity, boolean isBot) {
        super(entity, isBot);
    }

    @Override
    public boolean perform() {
        return false;
    }
}
