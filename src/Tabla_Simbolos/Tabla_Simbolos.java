/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabla_Simbolos;

import Analisis_Lexico.Token_;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edgar
 */
public class Tabla_Simbolos {
    ArrayList<String> listaLex = new ArrayList<String>();
    ArrayList<Token_> listaToken = new ArrayList<Token_>();
    Hashtable<Integer, Token_> tabla_simbolos = new Hashtable<Integer, Token_>();
    
    public void llenar_hash(Token_ rec){
        Token_ aux = rec;
        if (listaLex.contains(aux.lexema)) 
            return;
        listaLex.add(aux.lexema);
        listaToken.add(aux);
    }
    public DefaultTableModel llenarJtable(JTable model){
        DefaultTableModel modelo_ = (DefaultTableModel)model.getModel();
        for(Token_ aux : listaToken) {
            modelo_.addRow(new Object[] {aux.componente_lexico, aux.lexema});
        }
//        for(int i = 0; i < listaToken.size(); i++){
//            Token_ aux = listaToken.
//            modelo_.addRow(new Object[] {aux.componente_lexico, aux.lexema});
//        }
        return modelo_;
    }
}
