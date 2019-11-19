/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis_Lexico.Arbol;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

/**
 *
 * @author EricPc
 */
public class ArbolAsignacion {
    
    private SimuladorArbolBinario simulador = new SimuladorArbolBinario();
    public int x=10,y=10;
    
    public JPanel generarArbol(String cadena,JPanel panel){
        simulador.limpiar();
        String[] raices={"=","+","-","*","/"};
        String dato[] = cadena.split("!");
        ArrayList<datosNodo> datosNodos = new ArrayList<datosNodo>();
        datosNodos.clear();

        //agregar peso y enviar
        int pivotesPrioridad = 2;
        int datosPrioridad = 1;
        boolean salto=false;
        for(int i = 0 ; i<dato.length;i++){
            salto=false;
            for(String raiz:raices){
                if(!salto && raiz.equals(dato[i])){
                    datosNodos.add(new datosNodo(dato[i], pivotesPrioridad));
                    pivotesPrioridad+=2;
                    salto=true;
                }
            }
        }
        System.out.println("*****************************************");
        for(int i = 0 ; i<dato.length;i++){
            salto=false;
            for(String raiz:raices){
                if(!salto && raiz.equals(dato[i])){
                    salto=true;
                }
            }
            if(!salto){
                datosNodos.add(new datosNodo(dato[i], datosPrioridad));
                datosPrioridad+=2;
            }
        }
        for(datosNodo raiz:datosNodos){
            if (this.simulador.insertar(raiz)) {
                continue;
            }
        }
        return this.simulador.getDibujo();
    }
    
    private JPanel repintarArbol(JPanel panel) {
        panel.removeAll();
        Rectangle tamaño = new Rectangle(20, 20, 500, 500);
        JInternalFrame frame = new JInternalFrame("Representación gráfica", true);
        frame.setBounds(tamaño);
        panel.add(frame, JLayeredPane.DEFAULT_LAYER);
        panel.setBounds(tamaño);
        frame.setSize(400,400);
        panel.repaint();
        frame.setVisible(true);
        frame.add(this.simulador.getDibujo(), BorderLayout.CENTER);
       return panel;
    }
    public class datosNodo{
        public String dato;
        public int peso;
        public datosNodo(String dato,int peso){
            this.dato=dato;
            this.peso=peso;
        }
    }    
}
