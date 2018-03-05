package com.satranc.taslar;

import com.satranc.tahta.TasPanel;
import java.awt.Container;
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;

/**
 *
 * @author skardas
 */
public class Piyon extends Tas {

    boolean isMoved = false;

    public Piyon(boolean isWhite, int width, int height) {
        super(isWhite);

        setIcon(new ImageIcon(
                new ImageIcon("icons/" + (isWhite ? "WhitePawn.png" : "BlackPawn.png"))
                        .getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
    }



    @Override
    public boolean move(TasPanel[][] cells, TasPanel hedef) 
    {
        Tas tas = hedef.getTas();      
        if(tas == null)
        {
            if(hedef.doCanMove())
            {
                setFree(cells);
                this.getParent().remove(this);
                hedef.add(this);
                isMoved = true;
                return true;
            }
        }
        else if(tas == this || isWhite == tas.isWhite)
        {
            return false;
        }
        else if(isWhite != tas.isWhite)
        {
            if(hedef.doCanMove())
            {
                //eat enemy
                //move
                setFree(cells);
                this.getParent().remove(this);
                hedef.remove(0);
                hedef.add(this);
                isMoved = true;
                return true;
            }
        }
        return false;
    }

    private void setSelectedVertical(TasPanel[][] cells, int x, int y, boolean isSelected) 
    {
        if(x >= 8 || y >= 8 || y < 0 || x < 0) return;
                
        if (!cells[x][y].hasAnyTas(this)) {
            cells[x][y].setCanMove(isSelected);
        }
    }
    private void setSelected2Vertical(TasPanel[][] cells, int x, int y, boolean isSelected) 
    {
        if(x >= 8 || y >= 8 || y < 0 || x < 0) return;
                
        if (!cells[x][y - (isWhite ? 1 : -1)].hasAnyTas(this) &&
                !cells[x][y].hasAnyTas(this)) {
            cells[x][y].setCanMove(isSelected);
        }
    }
    private void setSelectedCross(TasPanel[][] cells, int x, int y, boolean isSelected) 
    {
        if(x >= 8 || y >= 8 || y < 0 || x < 0) return;
                
        if (cells[x][y].hasEnemy(this)) {
            cells[x][y].setCanMove(isSelected);
        }
    }
        
    @Override
    public void setFree(TasPanel[][] cells) {
        super.setFree(cells);
        Point index = getIndex(cells);
        int coeff = isWhite ? 1 : -1;
        setSelectedVertical(cells, index.x, index.y + coeff * 1, false);
        if (!isMoved) {
            setSelected2Vertical(cells, index.x, index.y + coeff * 2, false);
        }
        if ((index.x < 7 && isWhite) || (index.x > 0 && !isWhite)) {
            setSelectedCross(cells, index.x + coeff * 1, index.y + coeff * 1, false);

        }
        if ((index.x > 0 && isWhite) || (index.x < 7 && !isWhite)) {
            setSelectedCross(cells, index.x - coeff * 1, index.y + coeff * 1, false);
        }
    }
    
    
    @Override
    public void setSelected(TasPanel[][] cells) {
        super.setSelected(cells);
        Point index = getIndex(cells);

        int coeff = isWhite ? 1 : -1;
        
        setSelectedVertical(cells, index.x, index.y + coeff * 1, true);
        if (!isMoved) 
        {
            setSelected2Vertical(cells, index.x, index.y + coeff * 2, true);
        }
        if ((index.x < 7 && isWhite) || (index.x > 0 && !isWhite)) {
            setSelectedCross(cells, index.x + coeff * 1, index.y + coeff * 1, true);

        }
        if ((index.x > 0 && isWhite) || (index.x < 7 && !isWhite)) {
            setSelectedCross(cells, index.x - coeff * 1, index.y + coeff * 1, true);
        }

    }

}
