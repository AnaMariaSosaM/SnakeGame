/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;



import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JPanel;

/**
 *
 * @author AnaSosa
 */
public class Sprite extends JPanel{
    private ImageIcon background;
    
    private ImageIcon border;
    private JButton closeGame;
    private Presa presa;
    private Depredador depredador;
    private Obstaculos obstaculo = new Obstaculos();
    
    public Sprite(Presa presa, Depredador depredador){
        iniciarComponentes();
        this.presa = presa;
        this.depredador = depredador;
        //this.obstaculo = obstaculo;
    }
    public void iniciarComponentes(){
        background = new ImageIcon(this.getClass().getResource("/juego/images/bg.jpg"));
        border = new ImageIcon(this.getClass().getResource("/juego/images/point.png"));
       
    }
    
    
    @Override
    protected void paintComponent(Graphics g){
        g.drawImage(this.background.getImage(), 0, 0, null);

       
        for (int i = 2; i < 600; i += 30) {
            g.drawImage(this.border.getImage(), i, 2, null);
            g.drawImage(this.border.getImage(), i, 483, null);
        }
        for (int i = 2; i < 500; i += 30) {
            g.drawImage(this.border.getImage(), 2, i, null);
            g.drawImage(this.border.getImage(), 573, i, null);   
        }
        
        this.presa.graficar(g);
        this.depredador.graficar(g);
        this.obstaculo.graficar(g);
        
    }

  
 
   
}
