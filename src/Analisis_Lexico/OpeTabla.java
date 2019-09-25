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
    public ArrayList<Token_> buscarID( String lexema, String tipo,ArrayList<Token_> ls){
        System.out.print("****************************************************");
        
        for (Analisis_Lexico.Token_ l : ls) {
            c++;
            if(ls.get(c).lexema.equals(lexema)){
               ls.get(c).tipoDato = tipo;
               //System.out.print(l.tipoDato.toString());
               return ls;
            }
        }
        return ls;
    }
    
}