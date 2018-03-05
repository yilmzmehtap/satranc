package com.satranc.taslar;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author skardas
 */
public class Kale extends Tas {

    public Kale (boolean isWhite, int width, int height) {
        super(isWhite);

        setIcon(new ImageIcon(
                new ImageIcon("icons/" + (isWhite ? "WhiteRook.png" : "BlackRook.png"))
                        .getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
    }

}
