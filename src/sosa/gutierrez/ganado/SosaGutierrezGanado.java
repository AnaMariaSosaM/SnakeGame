/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sosa.gutierrez.ganado;

import gui.Juego;

/**
 *
 * @author AnaSosa
 */
public class SosaGutierrezGanado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          Juego ventana = new Juego();
            ventana.setVisible(true);
            (new Thread(ventana)).start();
    }
    
}
