package org.map.objects;

import org.map.GridObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Tony on 17/06/2017.
 */
public class Wall extends GridObject {

    public Wall() {
        super(1, "WALL", Color.black, "images/wall.png");
    }

}
