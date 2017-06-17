package EvaderCapture.Bot;

import EvaderCapture.PhysicsEngine.Physics3.Physics;

import java.util.ArrayList;

/**
 * Created by pmmde on 4/11/2016.
 */
public interface BotInterface {
    void init(Physics p);

    void calcNextShot(int playerNumber);

    void makeDatabase();

    ArrayList<String> ouputDatabase();

    void loadDatabase(ArrayList<String> input);
}
