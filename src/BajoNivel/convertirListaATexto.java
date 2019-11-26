/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BajoNivel;

import java.util.ArrayList;

/**
 *
 * @author Williams Vallejo
 */
public class convertirListaATexto {
    ArrayList<String> lista;
    
    public convertirListaATexto(ArrayList<String> lista){
        this.lista = lista;
    }

    public String getTexto(){
        String texto = "";
        
        if (this.lista == null) {
            return "Código vacío";
        }
        
        for(String el : this.lista){
            texto += el;
        }
        
        return texto;
    }
}
