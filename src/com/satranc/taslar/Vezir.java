/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.satranc.taslar;

import com.satranc.tahta.TasPanel;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.ImageIcon;
import java.awt.Point;
import java.awt.Container;
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

    @Override
    public boolean move(TasPanel[][] cells, TasPanel hedef) {
        Tas tas = hedef.getTas();
        if (tas == null) {
            if (hedef.doCanMove()) {
                setFree(cells);
                this.getParent().remove(this);
                hedef.add(this);
                boolean isMoved = true;
                return true;
            }
        } else if (tas == this || isWhite == tas.isWhite) {
            return false;
        } else if (isWhite != tas.isWhite) {
            if (hedef.doCanMove()) {
                //eat enemy
                //move
                setFree(cells);
                this.getParent().remove(this);
                hedef.remove(0);
                hedef.add(this);
                boolean isMoved = true;
                return true;
            }
        }
        return false;
 }
      private boolean setSelectedAny(TasPanel[][] cells, int x, int y, boolean isSelected) {
        if (x >= 8 || y >= 8 || y < 0 || x < 0) {
            return false;
        }
        if (!cells[x][y].hasAnyTas(this) || cells[x][y].hasEnemy(this)) {
            cells[x][y].setCanMove(isSelected);
        }
        if (!cells[x][y].hasAnyTas(this)) {
            return true;
        }
        return false;
    }
        @Override
    public void setFree(TasPanel[][] cells) {
        super.setFree(cells);
        doSec(cells);
    }

    @Override
    public void setSelected(TasPanel[][] cells) {
        super.setSelected(cells);
        doSec(cells);
    }
     private void doSec(TasPanel[][] cells) {
        Point index = getIndex(cells);

        for (int i = 1; i < 8; i++) {
            if (!setSelectedAny(cells, index.x + i, index.y + i, isSelected))
             {
              break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (!setSelectedAny(cells, index.x - i, index.y - i, isSelected))
             {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (!setSelectedAny(cells, index.x - i, index.y + i, isSelected)) 
            {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (!setSelectedAny(cells, index.x + i, index.y - i, isSelected)) {
                break;
            }
       
        
      }
        
        
        
          for (int i = 1; i < 8; i++) {
            if (!setSelectedAny(cells, index.x, index.y + i, isSelected)) {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (!setSelectedAny(cells, index.x, index.y - i, isSelected)) {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (!setSelectedAny(cells, index.x - i, index.y, isSelected)) {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (!setSelectedAny(cells, index.x + i, index.y, isSelected)) {
                break;
            }
        }
    }
     

}
