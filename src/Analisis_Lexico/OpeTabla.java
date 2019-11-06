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
        for (int i = 0; i < ls.size(); i++ ) {
           
            if(ls.get(i).lexema.equals(lexema)){
                try {
                    ls.get(i).tipoDato = tipo;
                    ls.get(i).valor = valor;
                    ls.get(i).lexema = lexema;
                    
                    System.out.println("valor asignado:" + ls.get(i).toString());
                    
                   } catch (Exception e) {
                       
                   }
               return ls;
            }
        }
        
        return ls;
    }
    public Token_ buscarIDCup(String lexema, ArrayList<Token_> ls){
        int i = 0;
        
        //System.err.println(ls.toString());
        for (i = 0; i < ls.size(); i++ ) {
            if(ls.get(i).lexema.equals(lexema) && !ls.get(i).tipoDato.equals("")){
                System.out.println(ls.get(i).tipoDato.toString() +"---------------");
                return ls.get(i);
            }
        }
        return null;
    }
    public String verificarTipo(String lexema, ArrayList<Token_> ls){
        try { 
            if(Integer.parseInt(lexema.toString())/Integer.parseInt(lexema.toString())==1)
                return "entero"; 
            if(lexema.toString()=="true" || lexema.toString()=="falso")
                return "boleano";
            if(lexema.toString()=="DO" || lexema.toString()=="RE" || lexema.toString()=="MI" || lexema.toString()=="FA"
                    || lexema.toString()=="SOL" || lexema.toString()=="LA" || lexema.toString()=="SI")
                return "nota";  
        } catch ( Exception d) {
            
        }
        return "cadena";
    }
    public String validar_tipoDato(String lexema, ArrayList<Token_> ls){
        int i = 0;
        
        //System.err.println(ls.toString());
        for (i = 0; i < ls.size(); i++ ) {
            if(ls.get(i).lexema.equals(lexema) && !ls.get(i).tipoDato.equals("")){
                System.out.println(ls.get(i).tipoDato.toString() +"SE ENCONTRO TIPO DE DATO");
                return ls.get(i).tipoDato.toString();
            }
        }
        return null;
    }
    
    public String ObtenerValor(String lexema, ArrayList<Token_> ls){
        int i = 0;
        
        //System.err.println(ls.toString());
        for (i = 0; i < ls.size(); i++ ) {
            if(ls.get(i).lexema.equals(lexema)){
                System.out.println("--------------------------------------------->  " + ls.get(i).valor +"  <--------------- Valor");
                return ls.get(i).valor;
            }
        }
        return null;
    }
    
}