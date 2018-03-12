/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.satranc.tahta;

import com.satranc.taslar.Tas;
import com.satranc.taslar.Piyon;
import com.satranc.taslar.At;
import com.satranc.taslar.Fil;
import static com.satranc.taslar.Tas.SELECTED_COLOR;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author skardas
 */
public class TasPanel extends JPanel {
    
    private boolean canMove = false;

    TasPanel(LayoutManager layout) {
        super(layout);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public boolean doCanMove() {
        return canMove;
    }
    
    
    public void setCanMove(boolean canMove)
    {
        this.canMove = canMove;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        
        if(canMove)
        {
            g.setColor(SELECTED_COLOR);
            g.fillRect(1, 1, getWidth()-2, getHeight()-2);
        }
    }

    public Tas getTas() {
        return  getComponentCount() < 1 ? null : (Tas) getComponent(0);
    }

    public boolean isBosPanel() {
        return getComponentCount() < 1;
    }
 

    public boolean isCorrectTasSelected(boolean whiteOrder) {
        Tas tas = getTas();
        if(null == tas) return false;
        return tas.isWhite == whiteOrder;
    }

    public boolean hasEnemy(Tas ts) {
        Tas tas = getTas();
        if(null == tas) return false;
        return tas.isWhite != ts.isWhite;
    }

    public boolean hasAnyTas(Piyon aThis) {
       return getTas() != null;
    }
       public boolean hasAnyTas(At aThis) {
       return getTas() != null;
       }
       
       public boolean hasAnyTas(Fil aThis) {
       return getTas() != null;
    }

    

       
    }

    


