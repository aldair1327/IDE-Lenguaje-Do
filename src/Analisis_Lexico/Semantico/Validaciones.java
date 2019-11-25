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
    
    String cad = "",tipo_aAsig ="", tipo_aComp="",valor="",valor2="";
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
                             cad += "Error semántico en la linea: - "+aux[2]+ " El dato " + aux[0] + "  no ha sido declarado. \n";
                             continue;
                        }
                        if( aux[0].length() > 25 ){
                            cad += "Error semántico en la linea: - " + aux[2] + " El tamaño del identificador " + aux[0] + " excede el límite de 25 caracteres \n";  
                            continue;
                            
                        }else if( aux[1].length() > 25 ){
                            cad += "Error semántico en la linea: - " + aux[2] + " El tamaño del identificador " + aux[1] + " excede el límite de 25 caracteres \n";
                            continue;
                        }
                        
                        Integer.parseInt(aux[1]);
                        if( aux[1].length() > 6){
                            cad += "Error semántico en la linea: - "+aux[2]+ " El tamaño del valor " + aux[1] + "  excede el límite de 5 caracteres. \n";
                            
                        }else{
                            tipo_aAsig = optab.validar_tipoDato(aux[0],ls);
                            tipo_aComp = "entero";
                            //JOptionPane.showMessageDialog(null,tipo_aAsig);
                            
                            if( !tipo_aAsig.equals(tipo_aComp)){
                                cad += "Error semántico en la linea: - "+aux[2]+ " Asignación incompatible, el tipo de dato de: " + aux[1] + " no es compatible. Se esperaba un valor del tipo: " + tipo_aAsig +  " \n";

                            }
                        }
                                
                    }catch(NumberFormatException e){
                        if(idAComp == null){
                            cad += "Error semántico en la linea: - "+aux[2]+ " El dato " + aux[1] + "  no ha sido declarado. \n";
                        }
                        
                        tipo_aAsig = optab.validar_tipoDato(aux[0],ls);
                        tipo_aComp = optab.validar_tipoDato(aux[1],ls);
                        
                        if(idAAsig == null){
                           cad += "Error semántico en la linea: - "+aux[2]+ " El dato " + aux[0] + "  no ha sido declarado. \n";
                           continue;
                        }
                        
                        //JOptionPane.showMessageDialog(null,tipo_aComp);
                        //JOptionPane.showMessageDialog(null,tipo_aAsig);
                        
                        if( !tipo_aAsig.equals(tipo_aComp)){
                             cad += "Error semántico en la linea: - "+aux[2]+ " Asignación incompatible, el tipo de dato de: " + aux[1] + 
                                           " no es compatible. Se esperaba un valor del tipo: " + tipo_aAsig+ " \n";
                        }else{
                            //JOptionPane.showMessageDialog(null,asig.get(0));
                            valor = optab.ObtenerValor(aux[1], ls);
                            if( valor == null ){
                                cad += "Error semántico en la linea: - "+aux[2]+ " La variable: " + aux[1] + " no ha sido inicializada  \n";
                            } 
                        }
                    }
        }
        
        return cad;
    }
    
    public String InicializarVariable(ArrayList<String> ini, ArrayList<Token_> ls){
        cad ="";
        Collections.reverse(ini);
        //JOptionPane.showMessageDialog(null,ini.get(0));
        
        for(int x=0; x < ini.size(); x++) {
            aux = ini.get(x).split("=");
            if(!valorPredefinido(aux[1])){
                    try{
                        if( aux[0].length() > 25 ){
                            cad += "Error semántico en la linea: - " + aux[2] + " El tamaño del identificador " + aux[0] + " excede el límite de 25 caracteres \n";  
                            continue;
                            
                        }else if( aux[1].length() > 25 ){
                            cad += "Error semántico en la linea: - " + aux[2] + " El tamaño del identificador " + aux[1] + " excede el límite de 25 caracteres \n";
                            continue;
                        }
                        
                        Integer.parseInt(aux[1]); 
                        
                        if( aux[1].length() > 6){
                            cad += "Error semántico en la linea: - "+aux[2]+ " El tamaño del valor " + aux[1] + "  excede el límite de 5 caracteres. \n";
                            
                        }else{
                            tipo_aAsig = optab.validar_tipoDato(aux[0],ls);
                            tipo_aComp = "entero";
                            //JOptionPane.showMessageDialog(null,tipo_aAsig);
                            
                            if(tipo_aAsig == null){
                                //JOptionPane.showMessageDialog(null,"NULL");
                                cad += "Error semántico en la linea: - "+aux[2]+ " Asignación incompatible, el tipo de dato de: " + aux[1] + " no es compatible. Se esperaba un valor del tipo: " + tipo_aAsig +  " \n";

                            }else if(!tipo_aAsig.equals(tipo_aComp)){
                                //JOptionPane.showMessageDialog(null,"TIPOS DIFERNTES");
                                cad += "Error semántico en la linea: - "+aux[2]+ " Asignación incompatible, el tipo de dato de: " + aux[1] + " no es compatible. Se esperaba un valor del tipo: " + tipo_aAsig +  " \n";

                            }
                        }
                    
                    }catch(NumberFormatException e){
                        idAComp = optab.buscarIDCup(aux[1],ls);
                        
                        if(idAComp == null){
                            cad += "Error semántico en la linea: - "+ aux[2] + " El dato " + aux[1] + "  no ha sido declarado. \n";

                        }else{
                            if(valorPredefinido(aux[1])){
                                
                            }else{
                                tipo_aAsig = optab.validar_tipoDato(aux[0],ls);
                                tipo_aComp = "nota";
                                //JOptionPane.showMessageDialog(null,tipo_aAsig);

                                if( !tipo_aAsig.equals(tipo_aComp)){
                                    cad += "Error semántico en la linea: - "+aux[2]+ " Asignación incompatible, el tipo de dato de: " + aux[1] + " no es compatible. Se esperaba un valor del tipo: " + tipo_aAsig +  " \n";

                                }
                            }
                            
                            tipo_aAsig = optab.validar_tipoDato(aux[0],ls);
                            tipo_aComp = optab.validar_tipoDato(aux[1],ls);

                            if( !tipo_aAsig.equals(tipo_aComp)){
                                cad += "Error semántico en la linea: - "+aux[2]+ " Asignación incompatible, el tipo de dato de: " + aux[1] + " no es compatible. Se esperaba un valor del tipo: " + tipo_aAsig +  " \n";

                                }else{
                                        //System.out.println("-------------> " + aux[1] + "<------------    ANTES DE OBTENER VALOR \n" + ls );
                                        
                                        valor = optab.ObtenerValor(aux[1], ls);

                                        if( valor == null ){
                                            cad += "Error semántico en la linea: - "+aux[2]+ " La variable: " + aux[1] + " no ha sido inicializada  \n";
                                        }
                                    }
                            }
                    }
            }else{
            }
            
        }
        
        return cad;
    }
    
public String OpLogSimples(ArrayList<String> ini, ArrayList<Token_> ls){
        cad ="";
        Collections.reverse(ini);
        //JOptionPane.showMessageDialog(null,ini.get(0));
        
        for(int x=0; x < ini.size(); x++) {
            //JOptionPane.showMessageDialog(null,ini.get(x));
            aux = ini.get(x).split("=");
                    try{
                        Integer.parseInt(aux[0]);
                        //JOptionPane.showMessageDialog(null,"PARTE IZQUIERDA ES NUMERO");
                        try{
                            //JOptionPane.showMessageDialog(null,.equals("entero"));
                            Integer.parseInt(aux[1]);
                             
                        }catch(Exception e){
                           tipo_aAsig =optab.validar_tipoDato(aux[1], ls);
                             
                        if(tipo_aAsig != null && optab.validar_tipoDato(aux[1], ls).equals("entero")){
                            //JOptionPane.showMessageDialog(null,"ES ENTERA LA PARTE IZQUIERDA");
                            if(optab.ObtenerValor(aux[1], ls) == null){
                                cad += "Error semántico en la linea: - "+ aux[2] + " condición icompatible. La variable "+ aux[1] +
                                       " no ha sido inicializada . \n";
                                }else{
                                        
                                    }
                            }else if(!(optab.verificarTipo(aux[1], ls) != null && optab.verificarTipo(aux[1], ls).equals("entero"))){
                                cad += "Error semántico en la linea: - "+aux[2]+ " La variable: " + aux[1] + " no ha sido declarada  \n";
                            }else{
                                
                                cad += "Error semántico en la linea: - "+aux[2]+ " La variable: " + aux[1] + " no ha sido incializada  \n";
                            }
                             
                           //JOptionPane.showMessageDialog(null,o);
                        }
                    }catch(NumberFormatException e){
                        //JOptionPane.showMessageDialog(null,"HAY LETRAS EN PARTE IZQUIERDA");
                        idAComp = optab.buscarIDCup(aux[1],ls); 
                        idAAsig = optab.buscarIDCup(aux[0],ls);
                        if(idAAsig == null){
                        //JOptionPane.showMessageDialog(null,"PARTE IZQUIERDA NO DECLARADA");
                            cad += "Error semántico en la linea: - "+ aux[2] + " El dato " + aux[0] + "  no ha sido declarado. \n";
                            continue;
                        }
                        if(idAComp == null){
                            try{
                                Integer.parseInt(aux[1]);
                                //JOptionPane.showMessageDialog(null,"PARTE DERECHA ES NUMERO");
                                //JOptionPane.showMessageDialog(null,optab.validar_tipoDato(aux[0], ls).equals("entero"));
                                 
                                if(optab.validar_tipoDato(aux[0], ls).equals("entero")){
                                    //JOptionPane.showMessageDialog(null,"ES ENTERA LA PARTE IZQUIERDA");
                                    if(optab.ObtenerValor(aux[0], ls) == null){
                                         cad += "Error semántico en la linea: - "+ aux[2] + " condición icompatible. La variable "+ aux[0] +
                                        " no ha sido inicializada . \n"; 
                                        continue;
                                    }else{
                                        
                                    }
                                }else{
                                    cad += "Error semántico en la linea: - "+ aux[2] + " condición icompatible. El tipo de dato de "+ aux[0] +
                                    " no es compatible con el tipo de dato de: "+aux[1] +". \n"; 
                                    continue;
                                }
                                
                            }catch(NumberFormatException z){
                                //JOptionPane.showMessageDialog(null,"HAY LETRAS EN PARTE DERECHA");
                                cad += "Error semántico en la linea: - "+ aux[2] + " El dato " + aux[1] + "  no ha sido declarado. \n";
                                
                            }
                        }
                        
                        //JOptionPane.showConfirmDialog(null, "SI ESTAN DECLARADAS");
                           if(valorPredefinido(aux[0])){
                            cad += "Error semántico en la linea: - "+ aux[2] + " condición icompatible. El tipo de dato de "+ aux[0] +
                                    " no es compatible con el tipo de dato de: "+aux[1] +". \n";    
                        
                        }else if(valorPredefinido(aux[1])){
                            cad += "Error semántico en la linea: - "+ aux[2] + " condición icompatible. El tipo de dato de "+ aux[0] +
                                    " no es compatible con el tipo de dato de: "+aux[1] +". \n";    
                            
                        }else{
                            tipo_aAsig = optab.validar_tipoDato(aux[0],ls);
                            tipo_aComp = optab.validar_tipoDato(aux[1],ls);

                            if( !tipo_aAsig.equals(tipo_aComp) && !(tipo_aAsig.equals("entero"))){
                                cad += "Error semántico en la linea: - "+aux[2]+ "  condición incompatible, el tipo de dato de: " + aux[0] + 
                                        " no es compatible con el tipo de dato de: "+ aux[1] +". Se esperaba un valor del tipo: " + tipo_aComp +  " \n";

                            }else{
                                    //System.out.println("-------------> " + aux[1] + "<------------    ANTES DE OBTENER VALOR \n" + ls );
                                        
                                    valor = optab.ObtenerValor(aux[0], ls);
                                    valor2 = optab.ObtenerValor(aux[1], ls);
                                        
                                    if( valor == null ){
                                        cad += "Error semántico en la linea: - "+aux[2]+ " La variable: " + aux[0] + " no ha sido inicializada  \n";
                                    }else if(valor2 == null){
                                            cad += "Error semántico en la linea: - "+aux[2]+ " La variable: " + aux[1] + " no ha sido inicializada  \n";
                                            }else{
                                            }
                                }
                        }
                    }
        }
        return cad;
    }
    public String IncVar(ArrayList<String> ini, ArrayList<Token_> ls){
        cad ="";
        Collections.reverse(ini);
        //JOptionPane.showMessageDialog(null,ini.get(0));
        
        for(int x=0; x < ini.size(); x++) {
            //JOptionPane.showMessageDialog(null,ini.get(x));
            aux = ini.get(x).split("=");
                    try{
                        Integer.parseInt(aux[0]);
                        cad += "Error semántico en la línea: " + aux[2] + "La operación " + aux[1] + "solo puede ser ejecutada en variables del tipo enterio";  
                    }catch(NumberFormatException e){
                        //JOptionPane.showMessageDialog(null,"POSIBLE ID");
                        tipo_aAsig = optab.validar_tipoDato(aux[0], ls);
                        //JOptionPane.showMessageDialog(null,tipo_aAsig);
                        
                        if(valorPredefinido(aux[0])){
                             //JOptionPane.showMessageDialog(null,"VALOR PREDEFINIDO");
                            cad += "Error semántico en la línea: " + aux[2] + "La operación " + aux[1] 
                                    +" solo puede ejecutarse con variales enteras, no con valores estáticos";
                            
                        }else{
                                if(tipo_aAsig == null){
                                 //JOptionPane.showMessageDialog(null,"SIN DECLARAR");
                                cad += "Error semántico en la línea: " + aux[2] + "La operación " + aux[1] 
                                        +"no puede ejecutarse porque la variable " + aux[0] + "No ha sido declarada.";

                                }else if(tipo_aAsig.equals("entero")){
                                 //JOptionPane.showMessageDialog(null,"TIPO ENTERO");
                                 //JOptionPane.showMessageDialog(null,tipo_aAsig);
                                 valor = optab.ObtenerValor(aux[0], ls);

                                    if(valor == null){
                                         //JOptionPane.showMessageDialog(null,"SIN INICIALIZAR");
                                        
                                        cad += "Error semántico en la línea: " + aux[2] + "La operación " + aux[1] 
                                            +"no puede ejecutarse porque la variable " + aux[0] + "No ha sido inicializada.";
                                    }
                                }else{
                                   cad += "Error semántico en la línea: " + aux[2] + "La operación " + aux[1] 
                                            +"no puede ejecutarse porque la variable " + aux[0] + "debe ser del tipo entero."; 
                                }
                        }
                        
                    } 
        }
        return cad;
    }
    
    public String parametros(ArrayList<String> ini, ArrayList<Token_> ls){
        cad ="";
        Collections.reverse(ini);
        //JOptionPane.showMessageDialog(null,ini.get(0));
        
        for(int x=0;x<ini.size();x++) {
            aux = ini.get(x).split("=");
            
            try{  
                    Integer.parseInt(aux[0]);
                    if( aux[1].length() > 6){
                        cad += "Error semántico en la linea: - "+aux[2]+ " El tamaño del valor " + aux[1] + "  excede el límite de 5 caracteres. \n";
                    }
                                
                }catch(NumberFormatException e){
                    idAComp = optab.buscarIDCup(aux[0],ls);
                    //JOptionPane.showMessageDialog(null,idAComp);
                    if(valorPredefinido(aux[0])){
                        
                    }else if(idAComp == null){
                            cad += "Error semántico en la linea: - "+aux[1]+ " El dato " + aux[0] + "  no ha sido declarado. \n";
                        }else if( aux[0].length() > 25 ){
                            cad += "Error semántico en la linea: - " + aux[1] + " El tamaño del identificador " + aux[0] + " excede el límite de 25 caracteres \n";  

                            }else{
                                tipo_aComp = optab.validar_tipoDato(aux[0],ls);
                                //JOptionPane.showMessageDialog(null,tipo_aComp);
                                if( !(tipo_aComp.equals("entero"))){
                                    cad += "Error semántico en la linea: - "+aux[1]+ " el tipo de dato del parámetro: " + aux[0] + " debe ser del tipo entero. Se esperaba un valor del tipo: entero \n";
                                }else {
                                    tipo_aComp = optab.ObtenerValor(aux[0],ls);
                                  //  JOptionPane.showMessageDialog(null,tipo_aComp);
                                    if( tipo_aComp == null)
                                        cad += "Error semántico en la linea: - "+aux[1]+ " el dato del parámetro: " + aux[0] + " no ha sido inicializado \n";
                                }
                    }
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
