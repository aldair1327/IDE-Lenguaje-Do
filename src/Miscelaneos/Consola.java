/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Miscelaneos;

import javax.swing.*;

/**
 *
 * @author JuanManuel
 */
public class Consola {
    public JTextArea consola;
    
    public Consola(JTextArea consola){
        this.consola = consola;
    }
    
    public void setText(String text){
        consola.setText(text);
    }
}
