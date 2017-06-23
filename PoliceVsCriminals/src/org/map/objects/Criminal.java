package org.map.objects;

import org.map.EntityObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Tony on 17/06/2017.
 */
public class Criminal extends EntityObject {

    public Criminal() {
        super(2, "CRIMINAL", Color.yellow, "images/criminal.png");
    }

}
