/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis_Lexico.Automata_finito;

import Analisis_Lexico.Token_;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import javax.swing.JFrame;

/**
 *
 * @author Williams Vallejo
 */
public class AutomataFinitoN {
    public List<Token_> automata;
    
    public AutomataFinitoN(List<Token_> automata){
        this.automata = automata;
    }
    
    public LienzoAutomata genararAutomata(){
        //Analizando por cual de los 2 automatas existentes debe de irse
        // System.out.println(automata.get(0).componente_lexico);
        String elemento_1 = automata.get(0).componente_lexico;
        
        
        switch(elemento_1){
            case "ENTERO":
            case "NOTA":
            case "CADENA":
                return afn_declaracion(this.automata);
            case "ID":
                return afn_asignacion(this.automata);
        }
        return null;
    }
    
    public Token_ getFirst(){
        return automata.get(0);
    }
    
    public Token_ getAnterior(int i){
        return automata.get(i - 1);
    }
    
    private LienzoAutomata afn_declaracion(List<Token_> automata_temporal){
        /* 
            En teoria la declaracion deberia de ser:
            Declaracion a =     TIPO_DATO ID = ID ;
            Declaracion b =     TIPO_DATO ID = numEntero ;
            o
            Declaracion c =     TIPO_DATO ID ;
        */
        //Generacion de pila de los posibles resultados
        String tipos_declaracion[] = {"ENTERO", "NOTA", "CADENA" };
        
        String declaracion_a[] = {"TIPO_DATO", "ID", "ASSIGNACION", "ID", "PUNTO_Y_COMA"};
        String declaracion_d[] = {"TIPO_DATO", "ID", "ASSIGNACION", "PALABRA_RESERVADA", "PUNTO_Y_COMA"};
        String declaracion_b[] = {"TIPO_DATO", "ID", "ASSIGNACION", "numEntero", "PUNTO_Y_COMA"};
        String declaracion_c[] = {"TIPO_DATO", "ID", "PUNTO_Y_COMA"};
        
        ArrayList<String> automata_declaracion_a;
        ArrayList<String> automata_declaracion_b;
        ArrayList<String> automata_declaracion_c;
        ArrayList<String> automata_declaracion_d;
        
        automata_declaracion_a = llenarLista(declaracion_a);
        automata_declaracion_b = llenarLista(declaracion_b);
        automata_declaracion_c = llenarLista(declaracion_c);
        automata_declaracion_d = llenarLista(declaracion_d);
        
        //Empieza el proceso de comparacion
        for(String tipo: tipos_declaracion){ 
            if(automata_temporal.get(0).componente_lexico.equals(tipo)) {
                automata_declaracion_a.set(0, automata_temporal.get(0).componente_lexico);
                automata_declaracion_b.set(0, automata_temporal.get(0).componente_lexico);
                automata_declaracion_c.set(0, automata_temporal.get(0).componente_lexico);
                automata_declaracion_d.set(0, automata_temporal.get(0).componente_lexico);
                break;
            }
        }
        
        LienzoAutomata t = new LienzoAutomata(800, 400);
        if (validacionRecursividad(automata_temporal, automata_declaracion_a)) {
            t.setAutomata(automata_declaracion_a, automata_temporal);
            return t;
        }
        if (validacionRecursividad(automata_temporal, automata_declaracion_b)) {
            t.setAutomata(automata_declaracion_b, automata_temporal);
            return t;
        }
        if (validacionRecursividad(automata_temporal, automata_declaracion_c)) {
            t.setAutomata(automata_declaracion_c, automata_temporal);
            return t;
        }
        if (validacionRecursividad(automata_temporal, automata_declaracion_d)) {
            t.setAutomata(automata_declaracion_d, automata_temporal);
            return t;
        }
        return null;
    }
    
    private LienzoAutomata afn_asignacion(List<Token_> automata_temporal){
        /* 
            En teoria la asignacion deberia de ser:
            ID = ID ;
            ID = DO ;
            ID = RE ;
            ID = MI ;
            ID = FA ;
            ID = SOL ;
            ID = LA ;
            ID = SII ;
            ID = numEntero ;
        */
        //Generacion de pila de los posibles resultados
        if (automata_temporal.size() != 4) {
            return null;
        }
        String tipos_asignacion[] = {"ID","PALABRA_RESERVADA", "DO", "RE", "MI", "FA", "SOL", "LA", "SII", "numEntero"};
        String asignacion[] = {"ID", "ASSIGNACION", "VALOR", "PUNTO_Y_COMA"};
        
        ArrayList<String> automata_asignacion;
        
        automata_asignacion = llenarLista(asignacion);
        
        //Empieza el proceso de comparacion
        boolean cambio = false;
        //System.out.println("Token en 2: " + automata_temporal.get(2).componente_lexico);
                
        for(String tipo: tipos_asignacion){ 
            
            if(automata_temporal.get(2).componente_lexico.equals(tipo)) {
                automata_asignacion.set(2, automata_temporal.get(2).componente_lexico);
                cambio = true;
                break;
            }
        }
        if (!cambio) return null;
        
        String cadena="[";
        for(Token_ elemento: automata_temporal){
            cadena += elemento.componente_lexico + "("+elemento.lexema+"),";
        }
        cadena+="]";
        
        String cadena2="[";
        for(String elemento: automata_asignacion){
            cadena2 += elemento + ",";
        }
        cadena2 +="]";
        
        System.out.println("automata original: " + cadena);
        System.out.println("automata base: " + cadena2);
        
        
        if (validacionRecursividad(automata_temporal, automata_asignacion)) {
            LienzoAutomata t = new LienzoAutomata(800, 400);
            t.setAutomata(automata_asignacion, automata_temporal);
            return t;
        }

        return null;
    }
    
    /*
    0 == Terminó correctamente en un estado final
    1 == Terminó en un estado no final
    2 == Ya no hay más caminos
    -1 == ?????
    */
    private boolean validacionRecursividad(List<Token_> datos, List<String> declaracion){

        if (datos.size() == 0 && declaracion.size() == 0) return true;
        if (datos.size() == 0) return false;
        if (declaracion.size() == 0) return false;
        
        if (datos.get(0).componente_lexico.equals(declaracion.get(0))) {
            return(validacionRecursividad(
                datos.subList(1, datos.size()), 
                declaracion.subList(1, declaracion.size()))
            );
        }
        return false;
    }
   
    
    private ArrayList<String> llenarLista(String[]datos){
        ArrayList<String> nuevaLista = new ArrayList<>();
        nuevaLista.addAll(Arrays.asList(datos));
        return nuevaLista;
    }
    

}