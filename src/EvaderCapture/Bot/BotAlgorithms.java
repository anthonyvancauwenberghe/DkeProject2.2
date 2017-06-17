package EvaderCapture.Bot;

/**
 * Created by Tony on 6/8/2017.
 */
public enum BotAlgorithms {

    RANDOM("Random Algorithm");

    private String algorithm;

    BotAlgorithms(String algorithm) {
        this.algorithm = algorithm;
    }

    public String toString() {
        return algorithm;
    }

};