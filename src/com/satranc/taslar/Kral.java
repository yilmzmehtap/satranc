package com.satranc.taslar;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author skardas
 */
public class Kral extends Tas {

    public Kral (boolean isWhite, int width, int height) {
        super(isWhite);

        setIcon(new ImageIcon(
                new ImageIcon("icons/" + (isWhite ? "WhiteKing.png" : "BlackKing.png"))
                        .getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
    }

}