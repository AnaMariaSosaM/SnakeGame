/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Graphics;
import java.awt.Color;

/**
 *
 * @author SunRise
 */
public class Presa {
    
    private int x;
    private int y;
    private  Color colorPresa = java.awt.Color.red;

    public Presa() {
        this.x = 29;
        this.y = 25;
    }

    public Presa(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Color getColorPresa() {
        return colorPresa;
    }

    public void setColorPresa(Color colorPresa) {
        this.colorPresa = colorPresa;
    }
    
    
     public void graficar(Graphics g){
          g.setColor(getColorPresa());
          g.fillRect(x*10, y*10, 10, 10);
          
    }
}
