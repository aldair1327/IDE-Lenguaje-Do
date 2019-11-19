

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
    }
    
    
    public void imprimir(ArrayList<String> ci) throws InterruptedException{
        Collections.reverse(ci);  
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("c:/pruebas/"+nombreSolo2+".cod");
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
            fichero = new FileWriter("c:/pruebas/"+nombre);
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
        try{
            ProcessBuilder builder = new ProcessBuilder("arduino-cli compile --fqbn adruino:avr:uno c:/pruebas/"+this.nombre);
            Process process = builder.start();
            InputStream inputstream = process.getInputStream();
            BufferedInputStream bufferedinputstream = new BufferedInputStream(inputstream);
            Thread.sleep(5000);
            process.destroy();
            int i;
            String resultado="";
            while((i=bufferedinputstream.read())!=-1){    
                resultado+=((char)i);    
            } 
            JOptionPane.showMessageDialog(null, resultado);
        }catch(IOException e){
            e.printStackTrace();
        }
        try{
            ProcessBuilder builder = new ProcessBuilder("arduino-cli upload -p COM3 --fqbn arduino:avr:uno "+this.nombreSolo2);
            Process process = builder.start();
            InputStream inputstream = process.getInputStream();
            BufferedInputStream bufferedinputstream = new BufferedInputStream(inputstream);
            Thread.sleep(30000);
            process.destroy();
            int i;
            String resultado="";
            while((i=bufferedinputstream.read())!=-1){    
                resultado+=((char)i);    
            } 
            JOptionPane.showMessageDialog(null, resultado);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        /*imprimirCI a = new imprimirCI("nombre");
        ArrayList<String> prueba = new ArrayList<>();
        prueba.add("asdsdsdasd");
        a.imprimir(prueba);*/
    }
}
