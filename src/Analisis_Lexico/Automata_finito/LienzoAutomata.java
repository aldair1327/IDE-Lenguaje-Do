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

/**
 *
 * @author Williams Vallejo
 */
public class LienzoAutomata extends JPanel{
    public ArrayList<String> automata_modelo;
     public List<Token_> automata_a_validar;
     public Token_ tipo_dato;
    public String cadena_automata = "";
    public int ancho_ventana = 0;
    public int alto_ventana = 0;

    public LienzoAutomata(int ancho, int alto){
        this.ancho_ventana = ancho;
        this.alto_ventana = alto;
    }
    
    public void setAutomata(ArrayList<String> automata_modelo, List<Token_> automata_a_validar, Token_ tipo_dato) {
        this.automata_modelo = automata_modelo;
        this.automata_a_validar = automata_a_validar;
        this.tipo_dato = tipo_dato;
        //entero a = 0 ;
        cadena_automata += tipo_dato.lexema;
        for(Token_ elemento : automata_a_validar){
            cadena_automata += " " + elemento.lexema ;
        }
        
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        fondo(g);
        //Ecuacion inicial
        textoEcuacion(g,"Instruccion inicial: " + cadena_automata );
        
        //Estado inicial
        g.setFont(new Font("Arial", 0, 12));
        g.setColor(Color.BLACK);
        g.drawLine(10, this.alto_ventana / 2, 30, this.alto_ventana / 2);
        
        automata_modelo.add(0, tipo_dato.componente_lexico);
        
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
