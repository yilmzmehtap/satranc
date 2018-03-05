/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.satranc.taslar;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author skardas
 */
public class Vezir extends Tas {

    public Vezir(boolean isWhite, int width, int height) {
        super(isWhite);

        setIcon(new ImageIcon(
                new ImageIcon("icons/" + (isWhite ? "WhiteQueen.png" : "BlackQueen.png"))
                        .getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
    }

}
