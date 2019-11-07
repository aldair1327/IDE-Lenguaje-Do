/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis_Lexico.PilaAutomata;

import Analisis_Lexico.Token_;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author paty6
 */
public class ValidacionPila {
    public ArrayList<Token_> automata;
    
    public ValidacionPila(ArrayList<Token_> automata){
        this.automata = automata;
    }
    
    public LienzoPila genararAutomata(){
        
        switch(automata.get(0).componente_lexico){
            case "ENTERO":
            case "NOTA":
            case "CADENA":
                return afn_declaracion(this.automata);
            case "ID":
                return afn_asignacion(this.automata);
        }
        return null;
    }
    
    private LienzoPila afn_declaracion(ArrayList<Token_> automata_temporal){
        //Generacion de pila de los posibles resultados
        if (automata_temporal.isEmpty()) {
            return null;
        }
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
        //automata_temporal.remove(0);
        
        //Empieza el proceso de comparacion
        
        System.out.println("IF 1 Pila******************************");
        if (validacion(automata_temporal.subList(1, automata_temporal.size()), automata_declaracion_a)) {
            LienzoPila t = new LienzoPila(900, 500,automata_declaracion_a,automata_temporal);
            //t.setAutomata(automata_declaracion_a, automata_temporal);
            //return "Eligió el automata de declaracion 1";
            return t;
        }
        //System.out.println("Automata de Declaracion 1 Invalido\nIF 2*****************************");
        if (validacion(automata_temporal.subList(1, automata_temporal.size()), automata_declaracion_b)) {  
            //return "Eligió el automata de declaracion 2";
            LienzoPila t = new LienzoPila(900, 500,automata_declaracion_b,automata_temporal);
            //t.setAutomata(automata_declaracion_b, automata_temporal);
            return t;
        }
        //System.out.println("Automata de Declaracion 2 Invalido\nIF 3****************************");
        if (validacion(automata_temporal.subList(1, automata_temporal.size()), automata_declaracion_c)) {           
            //return "Eligió el automata de declaracion 3";
            //t.setAutomata(automata_declaracion_c, automata_temporal);
            LienzoPila t = new LienzoPila(900, 500,automata_declaracion_c,automata_temporal);
            return t;
        }
        //System.out.println("Automata de Declaracion 3 Invalido\nIF 4****************************");
        if (validacion(automata_temporal.subList(1, automata_temporal.size()), automata_declaracion_d)) {
            //return "Eligió el automata de declaracion 4";
            //t.setAutomata(automata_declaracion_d, automata_temporal);
            LienzoPila t = new LienzoPila(900, 500,automata_declaracion_d,automata_temporal);
            return t;
        }
        //System.out.println("Automata de Declaracion 4 Invalido\nAutomata Incorrecto");
        return null;
        
    }
    
    private LienzoPila afn_asignacion(ArrayList<Token_> automata_temporal){
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
        if (validacion(automata_temporal, automata_asignacion)) {
            LienzoPila t = new LienzoPila(900, 500,automata_asignacion,automata_temporal);
            //t.setAutomata(automata_asignacion, automata_temporal);
            return t;
        }

        return null;
    }
    
    private boolean validacion(List<Token_> datos, List<String> declaracion){
        if (datos.isEmpty()&& declaracion.isEmpty()) {            
            //System.out.println("No quedan elementos por validar\nPila Valida");
            return true;
        }
        if (datos.isEmpty()) {
            //System.out.println("Pila Vacia-Faltan elementos\nPila Invalida");
            return false;
        }
        if (declaracion.isEmpty()) {
            //System.out.println("Sobran elementos en la validacion\nPila Invalida");
            return false;
        }
        //System.out.println("--------");
        List<Token_> temp=datos;        
        
        boolean comparacion=datos.get(0).componente_lexico.equals(declaracion.get(0));
        
        //System.out.println(datos.get(0).componente_lexico+" = "+declaracion.get(0)+" ? "+ (comparacion?"Si":"No"));
        
        if (comparacion) {
            //System.out.println("Se remueve "+datos.get(0).componente_lexico);
            //En este punto se podria agregar otra pila a la vista para que sean redibujadas ambas pilas y pueda ser observado el proceso
            return(validacion(
                datos.subList(1, datos.size()), 
                declaracion.subList(1, declaracion.size())
            ));
        }
        //System.out.println("Pila Invalida");
        return false;
    }
   
    
    private ArrayList<String> llenarLista(String[]datos){
        ArrayList<String> nuevaLista = new ArrayList<>();
        for(String elemento: datos) nuevaLista.add(elemento);
        return nuevaLista;
    }
}
