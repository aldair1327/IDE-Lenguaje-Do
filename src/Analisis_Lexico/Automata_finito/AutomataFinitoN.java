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
        System.out.println(automata.get(0).componente_lexico);
        switch(automata.get(0).componente_lexico){
            case "ENTERO":
            case "NOTA":
            case "CADENA":
                return afn_declaracion(this.automata);
            case "ID":
                //return afn_asignacion(this.automata);
        }
        return null;
        //return "Error: Componente lexico no coincide con los requeridos "
            //    + "(ENTERO, NOTA, CADENA O ID)";
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
        Token_ tipo_dato = automata_temporal.get(0);
        
        String declaracion_a[] = {"ID", "ASSIGNACION", "ID", "PUNTO_Y_COMA"};
        String declaracion_d[] = {"ID", "ASSIGNACION", "PALABRA_RESERVADA", "PUNTO_Y_COMA"};
        String declaracion_b[] = {"ID", "ASSIGNACION", "numEntero", "PUNTO_Y_COMA"};
        String declaracion_c[] = {"ID", "PUNTO_Y_COMA"};
        
        ArrayList<String> automata_declaracion_a;
        ArrayList<String> automata_declaracion_b;
        ArrayList<String> automata_declaracion_c;
        ArrayList<String> automata_declaracion_d;
        
        automata_declaracion_a = llenarLista(declaracion_a);
        automata_declaracion_b = llenarLista(declaracion_b);
        automata_declaracion_c = llenarLista(declaracion_c);
        automata_declaracion_d = llenarLista(declaracion_d);
       
        //Como ya se validó el PRIMER TOKEN de la pila (TIPO_DATO) 
        //    se procede a eliminarlo
        automata_temporal.remove(0);
        
        //Empieza el proceso de comparacion
        System.out.println("IF 1******************************");
        if (validacionRecursividad(automata_temporal, automata_declaracion_a)) {
            System.out.println("retorno algo");
                    
        
//            JFrame jf = new JFrame();
//            jf.setTitle("Automata finito");
//            jf.setSize(800, 400);
//            jf.setVisible(true);
//            jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//            jf.setResizable(false);
            
            LienzoAutomata t = new LienzoAutomata(800, 400);
            t.setAutomata(automata_declaracion_a, automata_temporal, tipo_dato);
            //jf.add(t);
            return t;
            
            //return "Eligió el automata de declaracion 1";
        }
        System.out.println("IF 2*****************************");
        if (validacionRecursividad(automata_temporal, automata_declaracion_b)) {
//            JFrame jf = new JFrame();
//            jf.setTitle("Automata finito");
//            jf.setSize(800, 400);
//            jf.setVisible(true);
//            jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//            jf.setResizable(false);
            
            LienzoAutomata t = new LienzoAutomata(800, 400);
            t.setAutomata(automata_declaracion_b, automata_temporal, tipo_dato);
            //jf.add(t);
            return t;
            //return "Eligió el automata de declaracion 2";
        }
        System.out.println("IF 3****************************");
        if (validacionRecursividad(automata_temporal, automata_declaracion_c)) {
//            JFrame jf = new JFrame();
//            jf.setTitle("Automata finito");
//            jf.setSize(800, 400);
//            jf.setVisible(true);
//            jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//            jf.setResizable(false);
            
            LienzoAutomata t = new LienzoAutomata(800, 400);
            t.setAutomata(automata_declaracion_c, automata_temporal, tipo_dato);
            //jf.add(t);
            return t;
            
            //return "Eligió el automata de declaracion 3";
        }
        System.out.println("IF 4****************************");
        if (validacionRecursividad(automata_temporal, automata_declaracion_d)) {
            System.out.println("Entro al IF 4");
//            JFrame jf = new JFrame();
//            jf.setTitle("Automata finito");
//            jf.setSize(800, 400);
//            jf.setVisible(true);
//            jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//            jf.setResizable(false);
            
            LienzoAutomata t = new LienzoAutomata(800, 400);
            t.setAutomata(automata_declaracion_d, automata_temporal, tipo_dato);
            //jf.add(t);
            return t;
            
            //return "Eligió el automata de declaracion 4";
        }
        
        return null;
        //return "La expresión terminó en un estado no final";
        
    }
    
    private String afn_asignacion(List<Token_> automata_temporal){
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
                    
        
            JFrame jf = new JFrame();
            jf.setTitle("Automata finito");
            jf.setSize(800, 400);
            jf.setVisible(true);
            jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jf.setResizable(false);
            
            LienzoAutomata t = new LienzoAutomata(jf.getWidth(), jf.getHeight());
            //t.setAutomata(automata_declaracion_a, automata_temporal, tipo_dato);
            jf.add(t);
            
            
            return "Eligió el automata de asignacion 1";
        }
        System.out.println("IF 2*****************************");
        if (validacionRecursividad(automata_temporal, automata_declaracion_b)) {
            JFrame jf = new JFrame();
            jf.setTitle("Automata finito");
            jf.setSize(800, 400);
            jf.setVisible(true);
            jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jf.setResizable(false);

            LienzoAutomata t = new LienzoAutomata(jf.getWidth(), jf.getHeight());
           // t.setAutomata(automata_declaracion_b, automata_temporal, tipo_dato);
            jf.add(t);
            
            return "Eligió el automata de asignacion 2";
        }
        System.out.println("IF 3****************************");
        if (validacionRecursividad(automata_temporal, automata_declaracion_c)) {
            JFrame jf = new JFrame();
            jf.setTitle("Automata finito");
            jf.setSize(800, 400);
            jf.setVisible(true);
            jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            LienzoAutomata t = new LienzoAutomata(jf.getWidth(), jf.getHeight());
            //t.setAutomata(automata_declaracion_c, automata_temporal, tipo_dato);
            jf.add(t);
            
            return "Eligió el automata de asignacion 3";
        }
        
        return "La expresión terminó en un estado no final";
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