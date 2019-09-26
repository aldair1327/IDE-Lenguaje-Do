/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis_Lexico;

import Analisis_Lexico.Token_;
import java.util.ArrayList;
import Analisis_Lexico.InterfazTablaSimbolos;
import Ventanas.Inicio;

/**
 *
 * @author corre
 */
public class OpeTabla{
    
    public ArrayList<Token_> buscarID( 
      String lexema, 
      String tipo,
      String valor,
      ArrayList<Token_> ls
      ){
        System.out.println("****************************************************");
        for (int i = 0; i < ls.size(); i++ ) {
           
            if(ls.get(i).lexema.equals(lexema)){
                try {
                    ls.get(i).tipoDato = tipo;
                    ls.get(i).valor = valor;
                    ls.get(i).lexema = lexema;
                    
//                    Token_ temp;
//                    temp = new Token_();
//                    temp.tipoDato = tipo;
//                    temp.valor = valor;
//                    temp.lexema = lexema;
//                    System.out.println(temp.toString());
//                    if (ls.tipoDato.get(i) != null && !ls.tipoDato.get(i).equals("")) {
//                        
//                        System.out.println(ls.get(i).tipoDato + "awa");
//                            
//                    }
                       
                   } catch (Exception e) {
                       
                   }
               
               
//               if (ls.get(i).tipoDato != null) {
//                 ls.get(i).tipoDato = tipo;
//               }
//               if (ls.get(i).valor != null) {
//                  ls.get(i).valor = valor;
//               }
               /* System.out.println(valor + "valorcito"); */
               
               //System.out.print( ls.get(c).valor + "<-- el valor segun");
               return ls;
            }
        }
        
        return ls;
    }
    
}