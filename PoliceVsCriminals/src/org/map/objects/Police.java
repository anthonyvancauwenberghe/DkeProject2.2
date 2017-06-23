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

    public Police() {
        super(3, "POLICE", Color.blue, "images/police.png");
    }

}
