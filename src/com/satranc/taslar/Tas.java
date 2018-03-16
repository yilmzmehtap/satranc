/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.satranc.taslar;

import com.satranc.tahta.TasPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JLabel;

/**
 *
 * @author skardas
 */
public class Tas extends JLabel
{

    public static boolean IsWHITEORDER = true;
    public boolean isWhite;
    boolean isSelected = false;
    public static final Color SELECTED_COLOR = new Color(34, 139, 34, 120);
    public static final Color DISABLED_COLOR = new Color(255, 139, 34, 20);
    protected int width, height;

    public Tas(boolean isWhite) {
        this.isWhite = isWhite; 
                
    }
    
    public boolean move(TasPanel [][] cells, TasPanel hedef)
    {
        return false;
    }
    public void setSelected(TasPanel [][] cells)
    {
        this.isSelected = true;
        
        repaint();
    }
    public void setFree(TasPanel[][] cells)
    {
        this.isSelected = false;
        repaint();
    }
    
    public Point getIndex(TasPanel [][] cells)
    {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8;y++) {
                if(cells[x][y].getTas() == this)
                {
                    return new Point(x, y);
                }
            }
            
        }
        return null;
                
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        
        if(isSelected)
        {
            g.setColor(SELECTED_COLOR);
            g.fillRect(1, 1, getWidth()-2, getHeight()-2);
        }
        
        if((isWhite && Tas.IsWHITEORDER) ||  (!isWhite && !Tas.IsWHITEORDER))
        {
            g.setColor(DISABLED_COLOR);
            g.fillRect(1, 1, getWidth()-2, getHeight()-2);
        }
    }
    
}
