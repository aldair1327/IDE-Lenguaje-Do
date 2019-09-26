/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis_Lexico;

import Analisis_Lexico.Analisis_Lexico.Token_;
import java.util.ArrayList;
import Analisis_Lexico.InterfazTablaSimbolos;
import Ventanas.Inicio;

/**
 *
 * @author corre
 */
public class OpeTabla{
    int c=0;
    
    public ArrayList<Token_> buscarID( String lexema, String tipo,String valor,ArrayList<Token_> ls){
        System.out.print("****************************************************");
        
        for (Analisis_Lexico.Token_ l : ls) {
            c++;
            if(ls.get(c).lexema.equals(lexema)){
               ls.get(c).tipoDato = tipo;
               ls.get(c).valor = valor;
               //System.out.print( ls.get(c).valor + "<-- el valor segun");
               return ls;
            }
        }
        return ls;
    }
    
}