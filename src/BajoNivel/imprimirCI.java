

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BajoNivel;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author aldai
 */
public class imprimirCI {
    public String nombre,nombreSolo,nombreSolo2;

    public imprimirCI(String nombre) {
        this.nombreSolo= nombre;
        int index = nombre.length();
        this.nombreSolo2 = nombre.substring(0, index-3);
        this.nombre = nombreSolo2+".ino";
        this.nombreSolo = this.nombreSolo.toLowerCase();
        this.nombreSolo2 = this.nombreSolo2.toLowerCase();
        this.nombre = this.nombre.toLowerCase();
    }
    
    
    public void imprimir(ArrayList<String> ci) throws InterruptedException{
        Collections.reverse(ci);  
        FileWriter fichero = null;
        PrintWriter pw = null;
        boolean success = (new File("c:/pruebas/"+nombreSolo2)).mkdirs();
        if (!success) {
            // Directory creation failed
        }
        try
        {
            fichero = new FileWriter("c:/pruebas/"+nombreSolo2+"/"+nombreSolo2+".cod");
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
    
    public void imprimir2(ArrayList<String> ci) throws InterruptedException{
        Collections.reverse(ci);  
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("c:/pruebas/"+nombreSolo2+"/"+nombre);
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
        try {
            String cmd = "arduino-cli compile --fqbn arduino:avr:uno C:\\pruebas\\"+nombreSolo2; //Comando de apagado en linux
            Runtime.getRuntime().exec(cmd); 
        } catch (IOException ioe) {
                System.out.println (ioe);
        }
        try {
            String cmd = "arduino-cli upload -p COM5 --fqbn arduino:avr:uno C:\\pruebas\\"+nombreSolo2; //Comando de apagado en linux
            Runtime.getRuntime().exec(cmd); 
        } catch (IOException ioe) {
                System.out.println (ioe);
        }
    }
    public static void main(String[] args){
        /*imprimirCI a = new imprimirCI("nombre");
        ArrayList<String> prueba = new ArrayList<>();
        prueba.add("asdsdsdasd");
        a.imprimir(prueba);*/
    }
}
