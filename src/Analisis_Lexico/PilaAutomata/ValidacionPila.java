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
    public List<Token_> automata;
    
    public ValidacionPila(List<Token_> automata){
        this.automata = automata;
    }
    
    public String genararAutomata(){
        
        switch(automata.get(0).componente_lexico){
            case "ENTERO":
            case "NOTA":
            case "CADENA":
                return afn_declaracion(this.automata);
            case "ID":
                //return afn_asignacion(this.automata);
        }
        return null;
    }
    
    private String afn_declaracion(List<Token_> automata_temporal){
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
        //Considerando que existe una lista de pilas a dibujar en la vista, se podria hacer un metodo que agregue la pila original para que la vista la dibuje
        //Como ya se validó el PRIMER TOKEN de la pila (TIPO_DATO) 
        //    se procede a eliminarlo
        automata_temporal.remove(0);
        
        //Empieza el proceso de comparacion
        System.out.println("IF 1 Pila******************************");
        if (validacion(automata_temporal, automata_declaracion_a)) {             
            return "Eligió el automata de declaracion 1";
        }
        System.out.println("Automata de Declaracion 1 Invalido\nIF 2*****************************");
        if (validacion(automata_temporal, automata_declaracion_b)) {  
            return "Eligió el automata de declaracion 2";
        }
        System.out.println("Automata de Declaracion 2 Invalido\nIF 3****************************");
        if (validacion(automata_temporal, automata_declaracion_c)) {           
            return "Eligió el automata de declaracion 3";
        }
        System.out.println("Automata de Declaracion 3 Invalido\nIF 4****************************");
        if (validacion(automata_temporal, automata_declaracion_d)) {
            System.out.println("Entro al IF 4");
            return "Eligió el automata de declaracion 4";
        }
        System.out.println("Automata de Declaracion 4 Invalido\nAutomata Incorrecto");
        return null;
        
    }
    
    private boolean validacion(List<Token_> datos, List<String> declaracion){
        if (datos.isEmpty()&& declaracion.isEmpty()) {            
            System.out.println("No quedan elementos por validar\nPila Valida");
            return true;
        }
        if (datos.isEmpty()) {
            System.out.println("Pila Vacia-Faltan elementos\nPila Invalida");
            return false;
        }
        if (declaracion.isEmpty()) {
            System.out.println("Sobran elementos en la validacion\nPila Invalida");
            return false;
        }
        System.out.println("--------");
        List<Token_> temp=datos;        
        for(Token_ dato:temp){
            System.out.println("|"+dato.componente_lexico+"|");
        }
        boolean comparacion=datos.get(0).componente_lexico.equals(declaracion.get(0));
        
        System.out.println(datos.get(0).componente_lexico+" = "+declaracion.get(0)+" ? "+ (comparacion?"Si":"No"));
        
        if (comparacion) {
            System.out.println("Se remueve "+datos.get(0).componente_lexico);
            //En este punto se podria agregar otra pila a la vista para que sean redibujadas ambas pilas y pueda ser observado el proceso
            return(validacion(
                datos.subList(1, datos.size()), 
                declaracion.subList(1, declaracion.size())
            ));
        }
        System.out.println("Pila Invalida");
        return false;
    }
   
    
    private ArrayList<String> llenarLista(String[]datos){
        ArrayList<String> nuevaLista = new ArrayList<>();
        for(String elemento: datos) nuevaLista.add(elemento);
        return nuevaLista;
    }
}
