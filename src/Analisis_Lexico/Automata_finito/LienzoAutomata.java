/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis_Lexico.Automata_finito;

import Analisis_Lexico.Token_;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RepaintManager;

/**
 *
 * @author Williams Vallejo
 */
public class LienzoAutomata extends JPanel{
    public ArrayList<String> automata_modelo;
    public ArrayList<Token_> automata_a_validar;
    public String cadena_automata = "";
    public int ancho_ventana;
    public int alto_ventana;
    public String mensajeEstado = "TERMINO";
    
    
    public LienzoAutomata(int ancho, int alto){
        this.ancho_ventana = ancho;
        this.alto_ventana = alto;
    }
    
    public void setAutomata(ArrayList<String> automata_modelo, ArrayList<Token_> automata_a_validar, String mensaje) {
        this.automata_modelo = new ArrayList<>(automata_modelo);
        this.automata_a_validar = new ArrayList<> (automata_a_validar);
        this.mensajeEstado = mensaje;
        
        
        for(Token_ elemento : automata_a_validar){
            cadena_automata += " " + elemento.lexema ;
        }
        //System.out.println("Entro al set automata");
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        //super.repaint();
        //super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        fondo(g);
        
        //Ecuacion inicial
        textoEcuacion(g,"Instruccion inicial: " + cadena_automata );
        
        dibujarModelo(g);
        
        dibujarRecorrido(g);
        //System.out.println("es el paint componbents");
        //dibujarRecorrido(g, automata_modelo.size());
        
        g.setColor(new Color(149,173,208)); //eS COLOR AZUL
        g.setColor(new Color(183,28,28)); // COLOR ROJO DANGER
        g.setFont(new Font("Arial", 1, 18));
        g.drawString(mensajeEstado, ( this.ancho_ventana / 2 ) - 150, 320);
        
    }
    
    private void dibujarModelo(Graphics g){
        //Linea que va al estado inicial
        g.setFont(new Font("Arial", 0, 12));
        g.setColor(Color.BLACK);
        g.drawLine(10, this.alto_ventana / 2, 30, this.alto_ventana / 2);
        
        
        for (int i = 0; i <= automata_modelo.size() ; i++) {
            //Siguiente estado
            if ( i == automata_modelo.size() ) {
                g.setColor(new Color(248,206,204));
                g.fillOval(30 + (130 * i), (this.alto_ventana / 2) -25 , 50, 50);
            } else {
                g.drawOval(30 + (130 * i), (this.alto_ventana / 2) -25 , 50, 50);
            }
            g.setColor(Color.BLACK);
            g.drawString("q" + i, 50 + (130 * i), ( this.alto_ventana / 2 ));
        
            //Agregar transicion
            if (i < automata_modelo.size()  ) {
                dibujarTransicion(g, (80 + (130 * i)), (160 + (130 * i)));
                
                letraTransicion(g, (80 + (130 * i)), automata_modelo.get(i));
            }

        }
    }
    
    
    public void dibujarRecorrido(Graphics g) {
        //Linea que va al estado inicial
        g.setFont(new Font("Arial", 0, 12));
        
        g.setColor(new Color(149,173,208)); //eS COLOR AZUL
        g.fillOval(30 + 15 + (130 * 0), (this.alto_ventana / 2) , 20, 20);
        boolean flag = false;
        for (int i = 1; i <= automata_modelo.size() ; i++) {
            //System.out.println("If de ["+automata_a_validar.get(i-1).componente_lexico+"] con ["+automata_modelo.get(i-1)+"]");
            if (automata_a_validar.get(i-1).componente_lexico == automata_modelo.get(i-1)) {
                g.setColor(new Color(149,173,208)); //eS COLOR AZUL
                g.fillOval(30 + 15 + (130 * i), (this.alto_ventana / 2) , 20, 20);
                flag = true;
            } else {
                g.setColor(new Color(183,28,28)); // COLOR ROJO DANGER
                g.fillOval(30 + 15 + (130 * i), (this.alto_ventana / 2) , 20, 20);
                flag = false;
                break;
            }
        }
        if (flag) {
            g.setColor(new Color(149,173,208)); //eS COLOR AZUL
            g.fillOval(30 + 15 + (130 * (automata_modelo.size())), (this.alto_ventana / 2) , 20, 20);
        }
    }
    
    private void fondo(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.ancho_ventana, this.alto_ventana);
    }
    
    private void textoEcuacion(Graphics g, String texto){
        g.setColor(new Color(149,173,208));
        g.setFont(new Font("Arial", 1, 20));
        g.drawString(texto, ( this.ancho_ventana / 2 ) - 150, 50);
        
    }
    
    private void dibujarTransicion(Graphics g, int posx_inicial, int posx_final){
        g.drawLine(posx_inicial, this.alto_ventana / 2, posx_final, this.alto_ventana / 2);
    }
    
    private void letraTransicion(Graphics g, int x, String componente){
        g.drawString(componente, x, (this.alto_ventana / 2) - 20);
    }
    
        

}
