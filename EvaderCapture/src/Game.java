import Entities.Entity;
import Map.Grid;

import java.util.LinkedList;

/**
 * Created by s120619 on 18-6-2017.
 */
public class Game {

    private Grid grid;
    private LinkedList<Entity> entities;

    public Game() {
        entities = new LinkedList<>();
    }

    public LinkedList<Entity> getEntities() {
        return entities;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }
}
