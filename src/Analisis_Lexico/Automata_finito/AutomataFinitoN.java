/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis_Lexico.Automata_finito;

import Analisis_Lexico.Token_;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Williams Vallejo
 */
public class AutomataFinitoN {
    private List<Token_> automata;
    
    AutomataFinitoN(List<Token_> automata){
        this.automata = automata;
    }
    
    public String genararAutomata(){
        
        //Analizando por cual de los 2 automatas existentes debe de irse
        System.out.println(automata.get(0).componente_lexico);
        switch(automata.get(0).componente_lexico){
            case "ENTERO":
            case "NOTA":
            case "CADENA":
                return afn_declaracion(this.automata);
            case "ID":
                return afn_asignacion(this.automata);
        }
        return "Error: Componente lexico no coincide con los requeridos "
                + "(ENTERO, NOTA, CADENA O ID)";
    }
    
    private String afn_declaracion(List<Token_> automata_temporal){
        /* 
            En teoria la declaracion deberia de ser:
            Declaracion a =     TIPO_DATO ID = ID ;
            Declaracion b =     TIPO_DATO ID = numEntero ;
            o
            Declaracion c =     TIPO_DATO ID ;
        */
        //Generacion de pila de los posibles resultados
        String declaracion_a[] = {"ID", "ASIG", "ID", "PUNTO_Y_COMA"};
        String declaracion_b[] = {"ID", "ASIG", "numEntero", "PUNTO_Y_COMA"};
        String declaracion_c[] = {"ID", "PUNTO_Y_COMA"};
        
        ArrayList<String> automata_declaracion_a;
        ArrayList<String> automata_declaracion_b;
        ArrayList<String> automata_declaracion_c;
        
        automata_declaracion_a = llenarLista(declaracion_a);
        automata_declaracion_b = llenarLista(declaracion_b);
        automata_declaracion_c = llenarLista(declaracion_c);
       
        //Como ya se validó el PRIMER TOKEN de la pila (TIPO_DATO) 
        //    se procede a eliminarlo
        automata_temporal.remove(0);
        
        //Empieza el proceso de comparacion
        System.out.println("IF 1******************************");
        if (validacionRecursividad(automata_temporal, automata_declaracion_a)) {
            System.out.println("retorno algo");
            return "Eligió el automata de declaracion 1";
        }
        System.out.println("IF 2*****************************");
        if (validacionRecursividad(automata_temporal, automata_declaracion_b)) {
            return "Eligió el automata de declaracion 2";
        }
        System.out.println("IF 3****************************");
        if (validacionRecursividad(automata_temporal, automata_declaracion_c)) {
            return "Eligió el automata de declaracion 3";
        }
        
        return "La expresión terminó en un estado no final";
        
    }
    
    private String afn_asignacion(List<Token_> automata_temporal){
        return "404";
    }
    /*
    0 == Terminó correctamente en un estado final
    1 == Terminó en un estado no final
    2 == Ya no hay más caminos
    -1 == ?????
    */
    private boolean validacionRecursividad(List<Token_> datos, List<String> declaracion){
        //System.out.println("Tamaño de datos: " + datos.size());
        //System.out.println("Tamaño de declaracion: " + declaracion.size());
        if (datos.size() == 0 && declaracion.size() == 0) return true;
        if (datos.size() == 0) return false;
        if (declaracion.size() == 0) return false;
        
        
        if (datos.get(0).componente_lexico.equals(declaracion.get(0))) {
            
            return(validacionRecursividad(
                datos.subList(1, datos.size()), 
                declaracion.subList(1, declaracion.size())
            ));
        }
        
        return false;
    }
   
    
    private ArrayList<String> llenarLista(String[]datos){
        ArrayList<String> nuevaLista = new ArrayList<>();
        for(String elemento: datos) nuevaLista.add(elemento);
        return nuevaLista;
    }
    

}