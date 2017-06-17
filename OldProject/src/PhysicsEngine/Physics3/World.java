package PhysicsEngine.Physics3;

import PhysicsEngine.Objects.Parts.Ball;
import javafx.geometry.Point3D;

import java.util.ArrayList;

/**
 * Created by pmmde on 6/9/2016.
 */
public interface World {
    boolean DEBUG = true;

    int getAmountWorldObjects();

    WorldObject getWorldObject(int i);

    void updateTerain(Point3D center);

    WorldObject getNextNewObject();

    WorldObject getNextUpdateObject();

    Integer getNextRemoveObject();

    int getAmountBalls();

    Ball getBall(int i);

    void swapTerainPhysics();

    void load(ArrayList<String> data);

    void load(String[][] data, double gs, Point3D offset);

    ArrayList<String> save();
}
