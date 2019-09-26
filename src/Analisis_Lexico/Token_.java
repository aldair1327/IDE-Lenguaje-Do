/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis_Lexico;

/**
 *
 * @author Williams Vallejo
 */
public class Token_ {
    public String lexema,componente_lexico,tipoDato,valor; 
    public int numero_linea;
    public String contenido_linea;
        
    public Token_ (){
        this.lexema = "";
        this.componente_lexico = "";
        this.tipoDato = "";
        this.valor = "";

        this.numero_linea = 0;

        this.contenido_linea ="";
    }

    public Token_(String lexema, String tipoDato, String valor) {
        this.lexema = lexema;
        this.tipoDato = tipoDato;
        this.valor = valor;
    }
    
    @Override
    public String toString(){
        String mensaje = "";
        mensaje += "lexema: " + lexema + "\n";
        mensaje += "componente_lexico: " + componente_lexico + "\n";
        mensaje += "tipoDato: " + tipoDato + "\n";
        mensaje += "valor: " + valor + "\n";
        
        mensaje += "numero_linea: " + numero_linea + "\n";
        
        mensaje += "contenido_linea: " + contenido_linea + "\n";
        
        return mensaje;
    }
}
