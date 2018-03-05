package com.satranc.taslar;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author skardas
 */
public class Fil extends Tas {

    public Fil (boolean isWhite, int width, int height) {
        super(isWhite);

        setIcon(new ImageIcon(
                new ImageIcon("icons/" + (isWhite ? "WhiteBishop.png" : "BlackBishop.png"))
                        .getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
    }

}