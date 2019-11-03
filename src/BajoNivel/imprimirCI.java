

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BajoNivel;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author aldai
 */
public class imprimirCI {
    public void imprimir(ArrayList<String> ci){
        Collections.reverse(ci);  
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("c:/pruebas/intermedio.intermedio");
            pw = new PrintWriter(fichero);

            for (String elemento:ci)
                fichero.write(elemento);
           
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    
    public static void main(String[] args){
        imprimirCI a = new imprimirCI();
        ArrayList<String> prueba = new ArrayList<>();
        prueba.add("asdsdsdasd");
        a.imprimir(prueba);
    }
}
