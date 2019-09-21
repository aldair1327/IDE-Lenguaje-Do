package Manejador_errores;

import java.util.Enumeration;
import java.util.Hashtable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aguil
 */
public class Manejador_Errores {
    private Hashtable<String,String> contenedor=new Hashtable<String,String>();
    
    
    public Manejador_Errores() {
        contenedor.put("1", "Caracter no valido en la cadena ''CC'' en la línea 'LL'  ");
        contenedor.put("2", "Estructura de identificador no valida en la línea ''LL'' en la cadena ''CC'' ");
        //contenedor.put("2", "null pointer exception");
        //contenedor.put("3", "; expected");
        //contenedor.put("4", "falta pasar parametros");
        //contenedor.put("5", ": expected");
    }
    
    public String obtener_error (String codigo_error){
        return contenedor.get(codigo_error);
    }
    
}
