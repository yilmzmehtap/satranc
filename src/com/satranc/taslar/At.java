package com.satranc.taslar;
import com.satranc.tahta.TasPanel;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Point;
import java.awt.Container;

public class At extends Tas {

    private boolean isMoved;
   

    public At (boolean isWhite, int width, int height) {
        super(isWhite);

        setIcon(new ImageIcon(
                new ImageIcon("icons/" + (isWhite ? "WhiteKnight.png" : "BlackKnight.png"))
                        .getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
    }
}
