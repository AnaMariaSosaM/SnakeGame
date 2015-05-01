/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Graphics;
import java.awt.List;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import modelo.Punto;
import modelo.ArrayDepredador;
import modelo.EmptyStructureException;


/**
 *
 * @author AnaSosa
 */
public class Depredador extends ArrayDepredador {
    public ArrayDepredador<Punto> cuerpoDepredador = new ArrayDepredador();
    private Color colorSerpiente = Color.DARKGREEN;

    public Depredador(){
        this.cuerpoDepredador.add(new Punto(15, 25));
        this.cuerpoDepredador.add(new Punto(16, 25));
        this.cuerpoDepredador.add(new Punto(17, 25));
    }
    
    public Color getColorSerpiente() {
        return colorSerpiente;
    }

    public void setColorSerpiente(Color colorSerpiente) {
        this.colorSerpiente = colorSerpiente;
    }
    
    public void graficar(Graphics g){
          for (int i = 0; i < cuerpoDepredador.size(); i++) {
              g.setColor(java.awt.Color.orange);
                g.fillRect((this.cuerpoDepredador.get(i)).getX()*10,
                        (this.cuerpoDepredador.get(i)).getY()*10, 10, 10);
            }
    }
    
    public String toString2(){
        String asd = "";
        for (int i = 0; i < cuerpoDepredador.size(); i++) {
            asd += "\n x=" + cuerpoDepredador.get(i).getX() + " y=" + cuerpoDepredador.get(i).getY();
        }
        return asd;
    }
    
    public boolean esIgual(Punto p){
        for (int i = 0; i < cuerpoDepredador.size(); i++) {
            if(cuerpoDepredador.get(i).getX() == (p.getX()) && cuerpoDepredador.get(i).getY() == (p.getY())){
                return true;
            }
        }
        return false;
    }
}
