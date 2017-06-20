package org.game;

import org.map.objects.Criminal;

/**
 * Created by Krulvis on 20-Jun-17.
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
