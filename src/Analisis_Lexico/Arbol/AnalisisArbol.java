/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis_Lexico.Arbol;

import Analisis_Lexico.Automata_finito.AutomataFinitoN;
import Analisis_Lexico.PilaAutomata.ValidacionPila;
import Analisis_Lexico.Token_;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import com.sun.webkit.ContextMenu;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

/**
 *
 * @author EricPc
 */
public class AnalisisArbol {
    ArbolAsignacion arbolesAeignacion= new ArbolAsignacion();
    JTabbedPane tapArbol = new JTabbedPane();
    public JTabbedPane automataDeclaraciones(ArrayList<Token_> ts,JPanel panel,JTabbedPane panelOptimizado){
        ArrayList<Token_> lista_asignacion = new ArrayList<Token_>();
        Boolean inicio_asignacion = false;
        Boolean error = false;


        for(int i =0;i<ts.size();i++){
            if(ts.get(i).componente_lexico.equals("ID")) {
                if(!inicio_asignacion && comAnterior(ts.get(i-1)) && comPost(ts.get(i+1)) ){
                    inicio_asignacion = true;
                    //elemento.componente_lexico = "ID";
                    lista_asignacion.add(ts.get(i));
                    continue;
                }
            }
            if(ts.get(i).lexema.equals(";")){
                if (inicio_asignacion) {
                    inicio_asignacion = false;
                    lista_asignacion.add(ts.get(i));
                    terminarArbol(lista_asignacion, panel);
                    lista_asignacion.clear();
                }
                continue;
            }
            if(inicio_asignacion && compContinuar(ts.get(i)) ){
                    inicio_asignacion = false;
                    lista_asignacion.add(new Token_("ERROR NO PERTENECE AL ARBOL: " +ts.get(i).lexema, "", ""));
                    terminarArbol(lista_asignacion, panel);
                    lista_asignacion.clear();
                    continue;
            }
            if(inicio_asignacion && !ts.get(i).lexema.equals("=") && compararOp(ts.get(i-1),ts.get(i),ts.get(i+1))){
                    inicio_asignacion = false;
                    lista_asignacion.add(new Token_("ERROR NO PERTENECE AL ARBOL: " +ts.get(i).lexema, "", ""));
                    terminarArbol(lista_asignacion, panel);
                    lista_asignacion.clear();
                    continue;
            }
            
            if (inicio_asignacion ) {
                    lista_asignacion.add(ts.get(i));
            }
        }

        
        return tapArbol;
    }
    public JPanel crearArboles(String arbol,JPanel panelArbol){
            
            return arbolesAeignacion.generarArbol(arbol, panelArbol);
    }
    public void terminarArbol(ArrayList<Token_> lista_asignacion,JPanel panel){
        String arbol="";
        
        for(int j = 0; j< lista_asignacion.size();j++){
            arbol+=lista_asignacion.get(j).lexema+"!";
            System.out.println(arbol);
        }
        tapArbol.addTab(arbol,crearArboles(arbol,panel) );
    }
    
    public boolean comAnterior(Token_ anterior){
        switch(anterior.lexema){
            case "entero":
                return false;
            case "nota":
                return false;
            case "cadena":
                return false;
            case ";":
                return true;
        }
        return false;
    }
    public boolean comPost(Token_ posterior){
        switch(posterior.lexema){
            case "=":
                return true;
        }
        return false;
    }
        
    public boolean compContinuar(Token_ anterior){
        if(anterior.lexema.equals("+"))
            return false;
        if(anterior.lexema.equals("-"))
            return false;
        if(anterior.lexema.equals("/"))
            return false;
        if(anterior.lexema.equals("*"))
            return false;
        if(anterior.componente_lexico.equals("numEntero"))
            return false;
        if(anterior.componente_lexico.equals("ID"))
            return false;
        if(anterior.lexema.equals("="))
            return false;
        return true;
    }
    public boolean compararOp(Token_ anterior,Token_ actual, Token_ posterior){
        if(operadores(actual) && operadores(posterior))
           return true;
        if(operadores(actual) && compContinuar(posterior))
           return true;
        if(actual.lexema.equals(";") && anterior.lexema.equals("="))
           return true;
        if(compContinuar(actual))
           return true;
        
        return false;
    }
    public boolean operadores(Token_ actual){
        if(actual.lexema.equals("+"))
            return true;
        if(actual.lexema.equals("-"))
            return true;
        if(actual.lexema.equals("/"))
            return true;
        if(actual.lexema.equals("*"))
            return true;
        return false;
    }
    
    
}
