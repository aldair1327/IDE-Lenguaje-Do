/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis_Lexico.Automata_finito;

import java.util.ArrayList;

/**
 *
 * @author Williams Vallejo
 */
public class prueba_listas {
    
    public static void main(String args[]){
        ArrayList<String> lista = new ArrayList<>();
        String declaracion1[] = {"ID", "ASIG", "EXPRESION", "PUNTO_Y_COMA"};
        for(String elemento : declaracion1){
            lista.add(elemento);
        }
        
        System.out.println("Resultado de la pila: " + lista.toString());
        
        System.out.println("Ultimo elemento: " + lista.get(lista.size()- 1));
        
    }
}
