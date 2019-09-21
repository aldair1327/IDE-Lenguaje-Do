package Archivos;

import com.sun.javafx.util.Utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author edgar
 */
public class Archivos {
    
    public String nombre_archivo;
    public String ruta;
    public String contenido;
    public int num_lineas;
    public boolean cambios;
    public boolean guardado;
    public String extencion="";
    public Archivos(){
        
    }
    
    public Archivos(String ruta,String nombre_archivo){
        this.ruta=ruta;
        this.nombre_archivo=nombre_archivo;
        this.contenido="";
        String separar[]=Utils.split(nombre_archivo,".");
        if(separar.length>0)
            this.extencion=separar[1];
    }
    
    public void actualizar_en_memoria(){
        if(!this.contenido.isEmpty()){
            int lineas=1;
            for (int i = 0; i < contenido.length(); i++) {
                if(contenido.charAt(i)==10)
                    lineas++;
            }
            num_lineas=lineas;
        }
    }
    
    public boolean leer(){
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                contenido+=sCurrentLine+"\n";
            }
            this.contenido=contenido;
            actualizar_en_memoria();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    public boolean guardar(boolean agregar){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta,agregar))) {
            bw.write(contenido);
        } catch (IOException e) {
            return false;
        }
        return true;
    }
    
    public boolean eliminar(){
        try{
            File file = new File(ruta);
            return file.delete();
    	}catch(Exception e){
            return false;
    	}
    }
    
    public static void main(String[] args){
        //System.out.println(guardar("./src/Archivos/ar2.txt",true,"Contenido          sadad asdad asd   "));
        //System.out.println(leer("./src/Archivos/ar2.txt"));  
        //System.out.println(eliminar("./src/Archivos/ar.txt"));
    }
}
