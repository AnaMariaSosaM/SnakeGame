/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;



import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author AnaSosa
 */
public class PanelInformacion extends JPanel{
    private ImageIcon background;
    private  ImageIcon close;
    private JButton closeGame;
    private JLabel puntuacion;
    private JLabel puntos;
    public PanelInformacion(){
        iniciarComponentes();
        
    }
    public void iniciarComponentes(){
        this.setSize(602, 0);
        
        
        background = new ImageIcon(this.getClass().getResource("/juego/images/bg.jpg"));
        close = new ImageIcon(this.getClass().getResource("/juego/images/close.png"));
        closeGame = new JButton(close);
        setCloseGame(closeGame);
        getCloseGame().setOpaque(false);
        getCloseGame().setContentAreaFilled(false);
        getCloseGame().setBorderPainted(false);
        add(getCloseGame());
        
        this.puntuacion = new JLabel("Puntuación:");
        this.puntos = new JLabel("0");
        
        getPuntos().setFont(new Font("Verdana", Font.PLAIN, 20));
        puntuacion.setFont(new Font("Verdana", Font.PLAIN, 20));
        add(puntuacion);
        add(getPuntos());
    }
    
    
    @Override
    protected void paintComponent(Graphics g){
        g.drawImage(this.background.getImage(), 0, 0, null);
        
    }

  
    public JButton getCloseGame() {
        return closeGame;
    }

    
    public void setCloseGame(JButton closeGame) {
        this.closeGame = closeGame;
    }

    /**
     * @return the puntos
     */
    public JLabel getPuntos() {
        return puntos;
    }

    /**
     * @param puntos the puntos to set
     */
    public void setPuntos(JLabel puntos) {
        this.puntos = puntos;
    }
   
}
