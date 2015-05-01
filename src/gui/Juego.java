/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Punto;

/**
 *
 * @author AnaSosa
 */
public class Juego extends JFrame implements Runnable, KeyListener {
    
    private Sprite sprite;
    private Depredador depredador;
    private Presa presa;
    private PanelInformacion info;
    private String arrow = "";
    private Thread hilo = new Thread();
    private String accion;
    private int puntaje = 0;
    private boolean play = true;
 
    private int tiempo = 200;
    
    private int width = 60;
    private int height = 51;
    
    private int x = 17;
    private int y = 25;
    
    
    
    Random rdm = new Random();
    
    
    public Juego(){
        iniciarComponentes();

    }
    public void iniciarComponentes(){
        this.presa = new Presa();
        this.depredador = new Depredador();
        this.sprite = new Sprite(this.presa,this.depredador);
        this.accion = "start";
        this.info = new PanelInformacion();
        setSize(602, 559);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);
        getContentPane().add(this.sprite);
        getContentPane().add(this.info, "South");
    
        addKeyListener(this);
        setFocusable(true);
        info.getCloseGame().addActionListener((ActionEvent e) -> {
           System.exit(0);  
        });
        
        //this.hilo = new Thread(this).start();
//        this.hilo.start();
        
    }
    
    public void up(){
            this.y -= 1;
            Punto nuevo = new Punto(x,y);
            this.depredador.cuerpoDepredador.move(nuevo);
            arrow = "up";
    }
    
    public void down(){
            this.y += 1;
            Punto nuevo = new Punto(x,y);
            this.depredador.cuerpoDepredador.move(nuevo);  
            arrow = "down";
    }
    
    public void left(){
            this.x -= 1;
            Punto nuevo = new Punto(x,y);
            this.depredador.cuerpoDepredador.move(nuevo); 
            arrow = "left";
    }
    
    public void right(){
            this.x += 1;
            Punto nuevo = new Punto(x,y);
            this.depredador.cuerpoDepredador.move(nuevo);
            arrow = "right";
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //int keyCode = e.getKeyCode();
        if(accion.equals("start")){
            switch(e.getKeyCode()) { 
                case KeyEvent.VK_UP:
                    if(!arrow.equals("up"))
                    Juego.this.up();
                    break;
                case KeyEvent.VK_DOWN:
                    if(!arrow.equals("down"))
                    Juego.this.down();
                    break;
                case KeyEvent.VK_LEFT:
                    if(!arrow.equals("left"))
                    Juego.this.left();
                    break;
                case KeyEvent.VK_RIGHT :
                    if(!arrow.equals("right"))
                    Juego.this.right();
                    break;
                default:
                    break;
            } 
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    } 
    
    public void moveAuto(){
        
        if(!this.depredador.cuerpoDepredador.isEmpty()){
            
          switch(arrow) {
            case "up": up();
                break;
            case "down": down();
                break;
            case "left": left();
                break;
            case "right": right();
            } 
        }
    }
    
    public Presa randomPresa(){
           int xPresa = (int)(Math.floor(Math.random()*54-3));
           int yPresa = (int)(Math.floor(Math.random()*45-3));
           presa.setX(xPresa);
           presa.setY(yPresa);
         
         Punto nuevo = new Punto (xPresa, yPresa);
         while((depredador.esIgual(nuevo)) || (this.x == 27) || (this.y == 23) 
                 || (this.x == 31) || (this.y == 31) || (this.y == 27) || (xPresa<3)|| (yPresa<3) )
         {
            xPresa = (int)(Math.floor(Math.random()*(54-3)));
            yPresa = (int)(Math.floor(Math.random()*(44-3)));
            presa.setX(xPresa);
            presa.setY(yPresa);
         }
        return presa;
        
    }
    
    public void rules(){
        Punto nuevo = new Punto(x, y);
        
        if((this.x < 3) || (this.x > 55) || (this.y < 3) || (this.y > 47) || (this.x == 26 && this.y == 23) 
                || (this.x == 32 && this.y == 23) || (this.x == 26 && this.y == 27) 
                || (this.x == 32 && this.y == 27)){
            System.out.println("Perdio");
            play = false;
            JOptionPane.showMessageDialog(this, "Perdiste :(" + "\nPuntuación: " + puntaje);
       } else
        if(this.x == this.presa.getX() && this.y == this.presa.getY()){
            puntaje += 10;
            info.getPuntos().setText(String.valueOf(puntaje));
            depredador.cuerpoDepredador.add(nuevo);
            randomPresa();
            tiempo -= 10;
            moveAuto();
            }else{
                moveAuto();
        }
         
    }
    
    @Override
    public void run() {
        long tiempoInicial = System.currentTimeMillis();
        while (play){
            
            long tiempoFinal = System.currentTimeMillis();
            
            if ((this.accion.equals("start")) && (tiempoFinal - tiempoInicial >= this.tiempo)) {
                tiempoInicial = tiempoFinal;
            rules();
            repaint();
            }
        }
        
    }
    
}
