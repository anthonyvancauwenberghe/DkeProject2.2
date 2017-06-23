package org.map.objects;

import org.map.EntityObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Tony on 17/06/2017.
 */
public class Police extends EntityObject {

    private static BufferedImage image;
    public Police() {
        super(3, "POLICE", Color.blue);
    }


    public static BufferedImage getImage() {
        if (Police.image == null) {
            BufferedImage image = null;
            try {
                image = ImageIO.read(new File("images/police.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            Police.image = image;
        }

        return Police.image;
    }
}
