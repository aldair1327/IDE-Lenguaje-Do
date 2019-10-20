/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis_Lexico.Automata_finito;

import Analisis_Lexico.Token_;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Williams Vallejo
 */
public class pruebas_AFN {
    public static void main(String[] args){
        
        
        ArrayList<Token_> prueba1;
        prueba1 = new ArrayList<>();
        
        String datos_pruebas1[] = {"NOTA", "ID", "ASIG", "ID", "PUNTO_Y_COMA"};
        String datos_pruebas2[] = {"NOTA", "ID", "ASIG", "numEntero", "PUNTO_Y_COMA"};
        String datos_pruebas3[] = {"NOTA", "ID", "PUNTO_Y_COMA"};
        
        for(String elemento: datos_pruebas3) prueba1.add(new Token_(elemento, "", "", ""));
        
        AutomataFinitoN automata = new AutomataFinitoN(prueba1);
        
        System.out.println(automata.genararAutomata());
        
    }
}
