/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis_Lexico.PilaAutomata;

import Analisis_Lexico.Token_;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;


public class LienzoPila extends JPanel{
    public ArrayList<String> automata_modelo;
    public ArrayList<Token_> automata_a_validar;
    public ArrayList<Token_> aux=new ArrayList();
    public ArrayList<Token_> aux2=new ArrayList();
    public String cadena_automata = "";
    public int ancho_ventana = 0;
    public int alto_ventana = 0;
    private int max;
    private int general;

    public LienzoPila(int ancho, int alto,ArrayList<String> automata_modelo, ArrayList<Token_> automata_a_validar){
        this.ancho_ventana = ancho;
        this.alto_ventana = alto;
        this.automata_modelo = automata_modelo;
        this.automata_a_validar = automata_a_validar;
        this.max=automata_a_validar.size();
        this.general=0;
        for(Token_ elemento : automata_a_validar){
            cadena_automata += " " + elemento.lexema ;
            aux.add(elemento);
            aux2.add(elemento);
        }
        //Collections.reverse(aux);
    }
    
    public void setAutomata(ArrayList<String> automata_modelo, ArrayList<Token_> automata_a_validar) {
        this.automata_modelo = automata_modelo;
        this.automata_a_validar = automata_a_validar;
        this.max=automata_a_validar.size();
        for(Token_ elemento : automata_a_validar){
            cadena_automata += " " + elemento.lexema ;
        }
        //repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        //super.repaint();
        //super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        fondo(g);
        //Ecuacion inicial
        textoEcuacion(g,"Instruccion inicial: " + cadena_automata );
        this.aux=this.aux2;
        this.general=0;
        //Estado inicial
        g.setFont(new Font("Arial", 0, 12));
        g.setColor(Color.BLACK);
        //g.drawLine(10, this.alto_ventana / 2, 30, this.alto_ventana / 2);
        for (int i = 1; i <= aux2.size() ; i++) {
            if (i < aux2.size()  ) {
                dibujarTransicion(g, ((160 * i)-30), (30+ (160 * i)));
                g.drawLine((30+ (160 * i)), (this.alto_ventana / 3)+(this.alto_ventana / 6), (15+ (160 * i)), (this.alto_ventana / 3)+(this.alto_ventana / 6)-15);
                g.drawLine((30+ (160 * i)), (this.alto_ventana / 3)+(this.alto_ventana / 6), (15+ (160 * i)), (this.alto_ventana / 3)+(this.alto_ventana / 6)+15);
                //letraTransicion(g, (80 + (130 * i)), automata_modelo.get(i));
            }else{
                dibujarTransicion(g, ((160 * i)-30), ((160 * i)));
                g.drawLine(( (160 * i)), (this.alto_ventana / 3)+(this.alto_ventana / 6), (-15+ (160 * i)), (this.alto_ventana / 3)+(this.alto_ventana / 6)-15);
                g.drawLine(((160 * i)), (this.alto_ventana / 3)+(this.alto_ventana / 6), (-15+ (160 * i)), (this.alto_ventana / 3)+(this.alto_ventana / 6)+15);
                g.setColor(Color.GREEN);
                g.drawString("Pila", ((160 * i))+15, (this.alto_ventana / 3)+(this.alto_ventana / 6)-15);
                g.drawString("Validada", ((160 * i))+5, (this.alto_ventana / 3)+(this.alto_ventana / 6)+10);
            }
            dibujarPila(g,30 + (160 * (i-1)),(this.alto_ventana / 3));
            this.general++;
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
        g.drawLine(posx_inicial, (this.alto_ventana / 3)+(this.alto_ventana / 6), posx_final, (this.alto_ventana / 3)+(this.alto_ventana / 6));
    }
    private void dibujarPila(Graphics g, int x, int y){
        g.setColor(Color.BLACK);
        g.drawLine(x, y, x, y+this.max*30);
        g.drawLine(x, y+this.max*30, x+100, y+this.max*30);
        g.drawLine(x+100, y+this.max*30, x+100, y);
        int auxY=y+this.max*30;
        if (aux!=null) {
            for (int i=this.aux.size()-1;i>=this.general;i--) {
                g.drawRect(x, auxY, 100, 30);
                g.drawString(aux.get(i).lexema, x+10, auxY+20);
                auxY-=30;
            }
            
        }
    }
    
}
