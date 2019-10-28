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
        
        String componente_pruebas1[] = {"NOTA", "ID", "ASIG", "ID", "PUNTO_Y_COMA"};
        String lexema_pruebas1[] = {"nota", "variable", "=", "a", ";"};
        
        String datos_pruebas2[] = {"NOTA", "ID", "ASIG", "numEntero", "PUNTO_Y_COMA"};
        String datos_pruebas3[] = {"NOTA", "ID", "PUNTO_Y_COMA"};
        
        
        
        Token_ datos_pruebas1[] = new Token_[componente_pruebas1.length];
        for(int i = 0; i < datos_pruebas1.length; i++){
            prueba1.add(new Token_(componente_pruebas1[i], lexema_pruebas1[i], "", ""));
        }
        
        
        //for(String elemento: datos_pruebas3) prueba1.add(new Token_(elemento, "", "", ""));
        
        AutomataFinitoN automata = new AutomataFinitoN(prueba1);
        
        System.out.println(automata.genararAutomata());
        
    }
}
