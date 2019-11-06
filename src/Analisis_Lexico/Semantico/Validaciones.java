/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis_Lexico.Semantico;

import java.util.ArrayList;
import java.util.Collections;
import Analisis_Lexico.OpeTabla;
import Analisis_Lexico.Token_;
import javax.swing.JOptionPane;

/**
 *
 * @author saiddias
 */
public class Validaciones {
    Analisis_Lexico.Token_  idAAsig=null,idAComp=null; //idAAsig lado izquierdo, idAComp lado derecho
    
    String cad = "",tipo_aAsig ="", tipo_aComp="",valor="";
    String aux [] = new String [3]; // 0 es el dato izq, 1 el derecho y el 2 es el número de línea
    
    Analisis_Lexico.OpeTabla optab = new OpeTabla();
    
    
    
    public String AsignacionSimple(ArrayList<String> asig, ArrayList<Token_> ls){
        Collections.reverse(asig);
        
        for(int x=0;x<asig.size();x++) {
            aux = asig.get(x).split("=");
            
            idAAsig = optab.buscarIDCup(aux[0],ls);
            idAComp = optab.buscarIDCup(aux[1],ls);
            
            try{
                        if(idAAsig == null){
//                             System.out.println("IF ASIGNULL"+idAAsig);
//                             System.out.println(idAComp);
                             cad += "Error en la linea: "+aux[2]+ " El dato " + aux[0] + "  no ha sido declarado. \n";
                             continue;
                        }
                        if( aux[0].length() > 25 ){
                            cad += "Error en la línea: " + aux[2] + " El tamaño del identificador " + aux[0] + " excede el límite de 25 caracteres \n";  
                            continue;
                            
                        }else if( aux[1].length() > 25 ){
                            cad += "Error en la línea: " + aux[2] + " El tamaño del identificador " + aux[1] + " excede el límite de 25 caracteres \n";
                            continue;
                        }
                        
                        Integer.parseInt(aux[1]);
                        if( aux[1].length() > 2){
                            cad += "Error en la linea: "+aux[2]+ " El tamaño del valor " + aux[1] + "  excede el límite de 3 dígitos. \n";
                            
                        }else{
                            tipo_aAsig = optab.validar_tipoDato(aux[0],ls);
                            tipo_aComp = "entero";
                            JOptionPane.showMessageDialog(null,tipo_aAsig);
                            
                            if( !tipo_aAsig.equals(tipo_aComp)){
                                cad += "Error en la linea: "+aux[2]+ " Asignación incompatible, el tipo de dato de: " + aux[1] + " no es compatible. Se esperaba un valor del tipo: " + tipo_aAsig +  " \n";

                            }
                        }
                                
                    }catch(NumberFormatException e){
                        if(idAComp == null){
                            cad += "Error en la linea: "+aux[2]+ " El dato " + aux[1] + "  no ha sido declarado. \n";
                        }
                        
                        tipo_aAsig = optab.validar_tipoDato(aux[0],ls);
                        tipo_aComp = optab.validar_tipoDato(aux[1],ls);
                        
                        if(idAAsig == null){
                           cad += "Error en la linea: "+aux[2]+ " El dato " + aux[0] + "  no ha sido declarado. \n";
                           continue;
                        }
                        
                        //JOptionPane.showMessageDialog(null,tipo_aComp);
                        //JOptionPane.showMessageDialog(null,tipo_aAsig);
                        
                        if( !tipo_aAsig.equals(tipo_aComp)){
                             cad += "Error en la linea: "+aux[2]+ " Asignación incompatible, el tipo de dato de: " + aux[1] + 
                                           " no es compatible. Se esperaba un valor del tipo: " + tipo_aAsig+ " \n";
                        }else{
                            JOptionPane.showMessageDialog(null,asig.get(0));
                            valor = optab.ObtenerValor(aux[1], ls);
                            if( valor == null ){
                                cad += "Error en la linea: "+aux[2]+ " La variable: " + aux[1] + " no ha sido inicializada  \n";
                            } 
                        }
                    }
        }
        
        return cad;
    }
    
    public String InicializarVariable(ArrayList<String> ini, ArrayList<Token_> ls){
        cad ="";
        Collections.reverse(ini);
        JOptionPane.showMessageDialog(null,ini.get(0));
        
        for(int x=0; x < ini.size(); x++) {
            aux = ini.get(x).split("=");
            if(!valorPredefinido(aux[1])){
                    try{
                        if( aux[0].length() > 25 ){
                            cad += "Error en la línea: " + aux[2] + " El tamaño del identificador " + aux[0] + " excede el límite de 25 caracteres \n";  
                            continue;
                            
                        }else if( aux[1].length() > 25 ){
                            cad += "Error en la línea: " + aux[2] + " El tamaño del identificador " + aux[1] + " excede el límite de 25 caracteres \n";
                            continue;
                        }
                        
                        Integer.parseInt(aux[1]); 
                        
                        if( aux[1].length() > 2){
                            cad += "Error en la linea: "+aux[2]+ " El tamaño del valor " + aux[1] + "  excede el límite de 3 caracteres. \n";
                            
                        }else{
                            tipo_aAsig = optab.validar_tipoDato(aux[0],ls);
                            tipo_aComp = "entero";
                            JOptionPane.showMessageDialog(null,tipo_aAsig);
                            
                            if( !tipo_aAsig.equals(tipo_aComp)){
                                cad += "Error en la linea: "+aux[2]+ " Asignación incompatible, el tipo de dato de: " + aux[1] + " no es compatible. Se esperaba un valor del tipo: " + tipo_aAsig +  " \n";

                            }
                        }
                    
                    }catch(NumberFormatException e){
                        idAComp = optab.buscarIDCup(aux[1],ls);
                        
                        if(idAComp == null){
                            cad += "Error en la linea: "+aux[2]+ " El dato " + aux[1] + "  no ha sido declarado. \n";

                        }else{
                            if(valorPredefinido(aux[1])){
                                
                            }else{
                                tipo_aAsig = optab.validar_tipoDato(aux[0],ls);
                                tipo_aComp = "nota";
                                JOptionPane.showMessageDialog(null,tipo_aAsig);

                                if( !tipo_aAsig.equals(tipo_aComp)){
                                    cad += "Error en la linea: "+aux[2]+ " Asignación incompatible, el tipo de dato de: " + aux[1] + " no es compatible. Se esperaba un valor del tipo: " + tipo_aAsig +  " \n";

                                }
                            }
                            
                            tipo_aAsig = optab.validar_tipoDato(aux[0],ls);
                            tipo_aComp = optab.validar_tipoDato(aux[1],ls);

                            if( !tipo_aAsig.equals(tipo_aComp)){
                                cad += "Error en la linea: "+aux[2]+ " Asignación incompatible, el tipo de dato de: " + aux[1] + " no es compatible. Se esperaba un valor del tipo: " + tipo_aAsig +  " \n";

                                }else{
                                        //System.out.println("-------------> " + aux[1] + "<------------    ANTES DE OBTENER VALOR \n" + ls );
                                        
                                        valor = optab.ObtenerValor(aux[1], ls);

                                        if( valor == null ){
                                            cad += "Error en la linea: "+aux[2]+ " La variable: " + aux[1] + " no ha sido inicializada  \n";
                                        }
                                    }
                            }
                    }
            }else{
                continue;
            }
            
        }
        
        return cad;
    }
    
    private boolean valorPredefinido(String id){
        switch(id){
            case "RE":   return true;
            case "MI":   return true; 
            case "FA":   return true; 
            case "SOL":  return true; 
            case "LA":   return true; 
            case "SII":  return true;           
            case "DO":   return true;              
            case "DOS":  return true;           
            case "RES":  return true;             
            case "MIS":  return true;             
            case "FAS":  return true;            
            case "SOLS": return true;            
            case "LAS":  return true;               
            case "SIS":  return true;                
            default: return false;
        }
    }
    
}
