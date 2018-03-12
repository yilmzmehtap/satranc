package com.satranc.taslar;
import com.satranc.tahta.TasPanel;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Point;
import java.awt.Container;

public class At extends Tas {
    boolean isMoved = false;
    public At(boolean isWhite, int width, int height) {
        super(isWhite);

        setIcon(new ImageIcon(
                new ImageIcon("icons/" + (isWhite ? "WhiteKnight.png" : "BlackKnight.png"))
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

    private void setSelectedAny(TasPanel[][] cells, int x, int y, boolean isSelected) 
    {
        if(x >= 8 || y >= 8 || y < 0 || x < 0) return;
                
        if (!cells[x][y].hasAnyTas(this) || cells[x][y].hasEnemy(this)) {
            cells[x][y].setCanMove(isSelected);
        }
    }
    
    @Override
    public void setFree(TasPanel[][] cells) {
        super.setFree(cells);
        Point index = getIndex(cells);
        for(int i=-2;i<=2;i++){
            if(i!=0){
                setSelectedAny(cells, index.x+i, index.y+(3-Math.abs(i)), isSelected);
                setSelectedAny(cells, index.x+i, index.y+(Math.abs(i)-3), isSelected);
            }
        }
    }
        
    @Override
    public void setSelected(TasPanel[][] cells) {
        super.setSelected(cells);
        Point index = getIndex(cells);

        for(int i=-2;i<=2;i++){
            if(i!=0){
                setSelectedAny(cells, index.x+i, index.y+(3-Math.abs(i)), isSelected);
                setSelectedAny(cells, index.x+i, index.y+(Math.abs(i)-3), isSelected);
            }
        }
        
    }
    
}
