/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Graphics;
import modelo.Punto;

/**
 *
 * @author AnaSosa
 */
public class Obstaculos {
    
    private Color color = java.awt.Color.BLACK;
            
    public void graficar(Graphics g)
  {
      g.setColor(this.color);
      g.fillRect(260, 230, 10, 10);
      g.fillRect(320, 230, 10, 10);
      g.fillRect(260, 270, 10, 10);
      g.fillRect(320, 270, 10, 10);
    }
    //296, 251 / 306, 261
}
