/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Miscelaneos;

import javax.swing.JOptionPane;
import Miscelaneos.Renders.Render_Item;
import Archivos.Archivos;
import Miscelaneos.Renders.Tab;
import Ventanas.Inicio;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author edgar
 */
public class Miscelaneo  {
    
    public static void recorrer_carpeta(String ruta,DefaultTreeModel modelo,DefaultMutableTreeNode padre){
        File f= new File(ruta);
        File[] ficheros = f.listFiles();
        if(ficheros==null)
            return ;
        for (int x=0;x<ficheros.length;x++){
            String nombre=ficheros[x].getName();
            //String padre_=ficheros[x].getParent();
            boolean directorio=ficheros[x].isDirectory();
            
            DefaultMutableTreeNode carpeta = new DefaultMutableTreeNode(nombre);
            modelo.insertNodeInto(carpeta, padre, x);
            if(directorio){
                ruta+="/"+nombre;
                recorrer_carpeta(ruta,modelo,carpeta);
            }
        }
    }
    
  
    public static void actualizar_tab(JTabbedPane tab,ArrayList<Archivos> archivos,Inicio ini){
        int index=0;
        tab.removeAll();
        for (Archivos archivo : archivos) {
            Tab t= new Tab(archivo,ini);
            Render_Item r=new Render_Item(archivo,t,ini);
            tab.addTab(archivo.nombre_archivo, r);
            tab.setTabComponentAt(index++,t);
        }
        //return (ArrayList<Archivos>)data.get(1);
    }
    
    
    public static void seleccionar_tab(JTabbedPane tab,ArrayList<Archivos> archivos,Archivos ar){
        //tab.removeAll();
        int i=0;
        for (Archivos archivo : archivos) {
            if(ar.ruta.equals(archivo.ruta)){
                break;
            }
            i++;
        }
        tab.setSelectedIndex(i);
    }
    public static void actualizar_numeros(JTextArea area,Archivos archivos,boolean cargar){
        //area.setText("");
        int cantidad_lineas=archivos.num_lineas;
        archivos.actualizar_en_memoria();
        String nums=""; 
        for (int i = 1; i <= archivos.num_lineas; i++) {
            nums+=i+".\n";
        }
        if(cantidad_lineas==archivos.num_lineas&&!cargar)
            return;
        
        area.setText(nums);
        
    }
    public static String obtener_ruta(JFrame v,String titulo,int tipo){
        String ruta_imagen="";
        JFileChooser fc=new JFileChooser ();
        fc.setCurrentDirectory(new File("./src/Archivos_creados/"));
        fc.setFileSelectionMode(tipo);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de do", "do");
        fc.setFileFilter(filter);
        int returnVal = fc.showDialog(v, titulo);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            ruta_imagen=file.getPath();
        } else {
           ruta_imagen="";
        }
        return ruta_imagen;
    }
    public static void guardar_archivo(Archivos archivo_seleccionado,Inicio inicio,boolean eliminar,boolean guardar_como){
        if(archivo_seleccionado==null)
            return;
        if(!archivo_seleccionado.guardado||guardar_como){
            int eleccion = JOptionPane.showConfirmDialog(inicio,"Deseas guardar el archivo \n"
                    + archivo_seleccionado.nombre_archivo,"Guardar",JOptionPane.YES_NO_OPTION);
            if(eleccion==1){
                if(!eliminar)
                    return;
                inicio.archivos_abiertos.remove(archivo_seleccionado);
                Miscelaneo.actualizar_tab(inicio.tabs, inicio.archivos_abiertos,inicio);
                inicio.archivo_seleccionado=null;
                return;
            }else if(eleccion==-1){
                return;
            }
            String ruta=Miscelaneo.obtener_ruta(inicio,"Guardar",JFileChooser.FILES_AND_DIRECTORIES);
            if(ruta.equals("")){
                return;
            }
            File  f=new File(ruta);
            if(f.exists()){
                int eleccion2 = JOptionPane.showConfirmDialog(inicio,"Deseas remplazar el archivo","Guardar",JOptionPane.YES_NO_OPTION);
                if(eleccion2==1||eleccion==-1){
                    return;
                }
            }
            archivo_seleccionado.nombre_archivo=Miscelaneo.obtener_nombre_archivo(ruta);
            archivo_seleccionado.ruta=ruta;
            
        }
        //if(archivo_seleccionado.cambios){
            archivo_seleccionado.guardar(false);
            archivo_seleccionado.guardado=true;
        //}
        
        if(!eliminar)
            return;
        inicio.archivo_seleccionado=null;
        inicio.archivos_abiertos.remove(archivo_seleccionado);
        Miscelaneo.actualizar_tab(inicio.tabs, inicio.archivos_abiertos,inicio);
    }
    public static String obtener_ruta_arr(TreePath ruta){
        String rut="";
        for (Object cad : ruta.getPath()) {
            rut+=cad;
        }
        return rut;
    }
    public static String[] obtener_ruta_arr_con_nombre(TreePath ruta){
        String rut="";
        String nombre="";
        for (int i = 0; i < ruta.getPath().length; i++) {
            
            if(i==ruta.getPath().length-1){
                nombre=ruta.getPath()[i]+"";
                rut+=ruta.getPath()[i];
            }else{
                rut+=ruta.getPath()[i]+"/";
            }
        }
        return new String[]{rut,nombre};
    }
    
    public static String obtener_nombre_archivo(String ruta){
        String[] data = ruta.split("\\\\");
        return data[data.length-1];
    }
    public static boolean es_carpeta(String ruta){
        File f= new File(ruta);
        return f.isDirectory();
    }
    
}
