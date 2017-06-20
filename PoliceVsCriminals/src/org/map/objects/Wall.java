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

    private static BufferedImage image;

    public Wall() {
        super(1, "WALL", Color.black);
    }

    public static BufferedImage getImage() {
        if (Wall.image == null) {
            BufferedImage image = null;
            try {
                image = ImageIO.read(new File("images/wall.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            Wall.image = image;
        }

        return Wall.image;
    }

}
