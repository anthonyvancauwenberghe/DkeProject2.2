package org.game;

import org.Map.Objects.Evader;

/**
 * Created by Krulvis on 20-Jun-17.
 */
public class PursuiterTurn extends Turn<Evader> {

    public PursuiterTurn(Evader entity, boolean isBot) {
        super(entity, isBot);
    }

    @Override
    public boolean perform() {
        return false;
    }
}
