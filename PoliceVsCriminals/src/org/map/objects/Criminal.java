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

    private boolean isCaught = false;

    public Criminal() {
        super(2, "CRIMINAL", Color.yellow, "images/criminal.png");
    }

    public boolean isCaught() {
        return isCaught;
    }

    public void setCaught() {
        isCaught = true;
    }

}
