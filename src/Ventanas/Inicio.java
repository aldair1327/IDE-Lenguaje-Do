/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Analisis_Lexico.ASintactico;
import Analisis_Lexico.Analisis_Lexico;
import Analisis_Lexico.Analisis_Lexico.Token_;
import Analisis_Lexico.AnalizadorLexico;
import Analisis_Lexico.EstiloDocumento;
import Analisis_Lexico.Interfaz;
import Analisis_Lexico.InterfazTablaSimbolos;
import Analisis_Lexico.Nodo;
import Archivos.Archivos;
import Manejador_errores.Manejador_Errores;
import Miscelaneos.Miscelaneo;
import Tabla_Simbolos.Tabla_Simbolos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author edgar
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public String errores_Sintacticos="";
    public static List<String> listaErrores;
    

    
    public Inicio() {
        initComponents();
        analisis_lexico = new Analisis_Lexico();
        //cons = new Consola();
        //btn_nuevo_archivo.doClick();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        tabs = new javax.swing.JTabbedPane();
        panel_consola = new javax.swing.JScrollPane();
        cons = new javax.swing.JEditorPane();
        analizar_lexico = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        archivos = new javax.swing.JTree();
        jMenuBar1 = new javax.swing.JMenuBar();
        btn_nuevo = new javax.swing.JMenu();
        btn_nuevo_archivo = new javax.swing.JMenuItem();
        btn_abrir = new javax.swing.JMenuItem();
        btn_abrir_carpeta = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        btn_guardar = new javax.swing.JMenuItem();
        guardar_como = new javax.swing.JMenuItem();
        btn_guardar_todos = new javax.swing.JMenuItem();
        eliminar_archivo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        cerrar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Editor");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tabs.setBackground(new java.awt.Color(102, 102, 102));

        cons.setEditable(false);
        cons.setBackground(new java.awt.Color(102, 102, 102));
        cons.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        cons.setForeground(new java.awt.Color(255, 255, 255));
        cons.setToolTipText("");
        panel_consola.setViewportView(cons);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_consola, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                    .addComponent(tabs))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_consola, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        analizar_lexico.setText("Compilar");
        analizar_lexico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analizar_lexicoActionPerformed(evt);
            }
        });

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(200, 403));

        archivos.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        archivos.setForeground(new java.awt.Color(255, 255, 255));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        archivos.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        archivos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        archivos.setRootVisible(false);
        archivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                archivosMouseClicked(evt);
            }
        });
        archivos.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                archivosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(archivos);

        btn_nuevo.setText("Archivo");

        btn_nuevo_archivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        btn_nuevo_archivo.setText("Nuevo Archivo");
        btn_nuevo_archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevo_archivoActionPerformed(evt);
            }
        });
        btn_nuevo.add(btn_nuevo_archivo);

        btn_abrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        btn_abrir.setText("Abrir Archivo");
        btn_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_abrirActionPerformed(evt);
            }
        });
        btn_nuevo.add(btn_abrir);

        btn_abrir_carpeta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        btn_abrir_carpeta.setText("Abrir Carpeta");
        btn_abrir_carpeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_abrir_carpetaActionPerformed(evt);
            }
        });
        btn_nuevo.add(btn_abrir_carpeta);
        btn_nuevo.add(jSeparator2);

        btn_guardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        btn_guardar.setText("Guardar Archivo");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        btn_nuevo.add(btn_guardar);

        guardar_como.setText("Guardar Como");
        guardar_como.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar_comoActionPerformed(evt);
            }
        });
        btn_nuevo.add(guardar_como);

        btn_guardar_todos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        btn_guardar_todos.setText("Guardar Todos");
        btn_guardar_todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar_todosActionPerformed(evt);
            }
        });
        btn_nuevo.add(btn_guardar_todos);

        eliminar_archivo.setText("Eliminar Archivo");
        eliminar_archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_archivoActionPerformed(evt);
            }
        });
        btn_nuevo.add(eliminar_archivo);
        btn_nuevo.add(jSeparator1);

        cerrar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        cerrar.setText("Cerrar");
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });
        btn_nuevo.add(cerrar);

        jMenuBar1.add(btn_nuevo);

        jMenu2.setText("Mostrar Tablas");

        jMenuItem1.setText("Tabla de simbolos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Tabla general");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(analizar_lexico, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(analizar_lexico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevo_archivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevo_archivoActionPerformed
        Archivos ar=new Archivos(ruta_default+"Nuevo Archivo "+id_archivo+".do","Nuevo Archivo "+id_archivo+".do");
        archivos_abiertos.add(ar);
        this.archivo_seleccionado=ar;
        this.archivo_seleccionado.guardado=false;
        Miscelaneo.actualizar_tab(tabs, archivos_abiertos,this);
        Miscelaneo.seleccionar_tab(tabs, archivos_abiertos, ar);
        id_archivo++;
    }//GEN-LAST:event_btn_nuevo_archivoActionPerformed

    private void btn_abrir_carpetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_abrir_carpetaActionPerformed
        String ruta=Miscelaneo.obtener_ruta(this,"Seleccionar carpeta",JFileChooser.DIRECTORIES_ONLY);
        if(ruta.equals(""))
            return;
        ruta+="/";
        archivos.setRootVisible(true);
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode(ruta);
        DefaultTreeModel modelo = new DefaultTreeModel(raiz);
        Miscelaneo.recorrer_carpeta(ruta,modelo,raiz);
        this.archivos.setModel(modelo);
    }//GEN-LAST:event_btn_abrir_carpetaActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        if(archivo_seleccionado==null)
            return;
        Miscelaneo.guardar_archivo(archivo_seleccionado, this,false,false);
        Miscelaneo.actualizar_tab(tabs, archivos_abiertos,this);
        Miscelaneo.seleccionar_tab(tabs, archivos_abiertos, archivo_seleccionado);
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_abrirActionPerformed

        String ruta=Miscelaneo.obtener_ruta(this,"Abrir",JFileChooser.FILES_ONLY);
        if(ruta.equals(""))
            return;
        Archivos ar=new Archivos(ruta, Miscelaneo.obtener_nombre_archivo(ruta));
        for (Archivos archivo : archivos_abiertos) {
            if(archivo.ruta.equals(ar.ruta)){
                return;
            }
        }
       
        archivos_abiertos.add(ar);
        this.archivo_seleccionado=ar;
        archivo_seleccionado.ruta=ruta;
        this.archivo_seleccionado.leer();
        this.archivo_seleccionado.guardado=true;
        Miscelaneo.actualizar_tab(tabs, archivos_abiertos,this);
        Miscelaneo.seleccionar_tab(tabs, archivos_abiertos, ar);
    }//GEN-LAST:event_btn_abrirActionPerformed

    private void btn_guardar_todosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar_todosActionPerformed
        for (Archivos archivo : archivos_abiertos) {
            Miscelaneo.guardar_archivo(archivo, this,false,false);
        }
    }//GEN-LAST:event_btn_guardar_todosActionPerformed
    public static void setErrors(String error){
        listaErrores.add(error+"");
    }
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.cerrar.doClick();
    }//GEN-LAST:event_formWindowClosing

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        if(archivos_abiertos.size()>0){
            int eleccion = JOptionPane.showConfirmDialog(this,"Deseas guardar los archivos abiertos","Mensaje de Confirmacion",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
            if (eleccion == -1){
                return;
            }else if(eleccion==0)
                this.btn_guardar_todos.doClick();
        }
        System.exit(0);
    }//GEN-LAST:event_cerrarActionPerformed

    private void guardar_comoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar_comoActionPerformed
        if(archivo_seleccionado==null)
            return;
        Miscelaneo.guardar_archivo(archivo_seleccionado, this,false,true);
        Miscelaneo.actualizar_tab(tabs, archivos_abiertos,this);
        Miscelaneo.seleccionar_tab(tabs, archivos_abiertos, archivo_seleccionado);
    }//GEN-LAST:event_guardar_comoActionPerformed

    private void eliminar_archivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_archivoActionPerformed
        if(archivo_seleccionado==null)
            return;
        File fichero = new File(archivo_seleccionado.ruta);
        int eleccion = JOptionPane.showConfirmDialog(this,"Deseas eliminar el archivo "+archivo_seleccionado.nombre_archivo,"Mensaje de Confirmacion",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE);
        if (eleccion == -1||eleccion==1)
            return;
        this.archivos_abiertos.remove(archivo_seleccionado);
        fichero.delete();
        Miscelaneo.actualizar_tab(tabs, archivos_abiertos,this);
        if(archivos.getModel().getRoot().toString().equals("root")){
            archivos.setRootVisible(false);
            return;
        } 
        String ruta=archivos.getModel().getRoot().toString();
        archivos.setRootVisible(true);
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode(ruta);
        DefaultTreeModel modelo = new DefaultTreeModel(raiz);
        Miscelaneo.recorrer_carpeta(ruta,modelo,raiz);
        this.archivos.setModel(modelo);
       
    }//GEN-LAST:event_eliminar_archivoActionPerformed

    private void analizar_lexicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analizar_lexicoActionPerformed
     analizar_lexico_sintactico();
    }//GEN-LAST:event_analizar_lexicoActionPerformed

    private void archivosValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_archivosValueChanged

    }//GEN-LAST:event_archivosValueChanged

    private void archivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archivosMouseClicked
        if(archivos.getSelectionCount()==0)
            return;
        String ruta=Miscelaneo.obtener_ruta_arr(archivos.getSelectionPath());
        boolean carpeta=Miscelaneo.es_carpeta(ruta);
        if(carpeta)
        return;

        String[] datos=Miscelaneo.obtener_ruta_arr_con_nombre(archivos.getSelectionPath());
        Archivos ar=new Archivos(datos[0],datos[1]);

        for (Archivos archivo : archivos_abiertos) {
            String r=archivo.ruta;
            String r2=datos[0]+"";
            if(r.equals(r2)){
                Miscelaneo.seleccionar_tab(tabs, archivos_abiertos, ar);
                return;
            }
        }
        ar.guardado=true;
        ar.leer();
        archivos_abiertos.add(ar);
        this.archivo_seleccionado=ar;
        Miscelaneo.actualizar_tab(tabs, archivos_abiertos,this);
        Miscelaneo.seleccionar_tab(tabs, archivos_abiertos, archivo_seleccionado);

    }//GEN-LAST:event_archivosMouseClicked

    public void analizar_lexico_sintactico(){
        boolean entrar = true;
        this.cons.setText("");
        this.btn_guardar_todos.doClick();
        if(this.archivo_seleccionado==null){
            this.cons.setText("Seleccione un archivo para analizarlo\n");
            return;
        }
        if(!"do".equals(this.archivo_seleccionado.extencion)){
            this.cons.setText("No es pososible analizar archivos que no sean .do\n"+" Estas intentando analizar: "+archivo_seleccionado.nombre_archivo);
            return;
        }
        String errores="Iniciando analísis léxico\n";
        ArrayList<Token_> ls = null;
        try {
            ls = analisis_lexico.obtener_lexemas(archivo_seleccionado);
        } catch (IOException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        int num_errores=0;
        for (Token_ l : ls) {
            if(l.componente_lexico.equals("ERROR")){
                entrar = false;
                String err=(num_errores+1)+"-"+manejador_errores.obtener_error("1");
                err=err.replace("LL", l.numero_linea+"");
                err=err.replace("'CC'", l.lexema);
                errores+=err+"\n";
                num_errores++;
            }else if(l.componente_lexico.equals("IdNoVal")){
                entrar = false;
                String err=(num_errores+1)+"-"+manejador_errores.obtener_error("2");
                err=err.replace("LL",l.numero_linea+"");
                err=err.replace("'CC'", l.lexema);
                errores+=err+"\n";
                num_errores++;
            }
        }
        errores+="----------------------\n";
        errores+="Errores encontrados : "+num_errores;
        this.cons.setText(errores);
        
        if(num_errores > 0){
            errores+="---------- Es necesario corregir las cadenas que no pertenecen al lenguaje para continuar: ------------ \n";
            this.cons.setText(errores);
            return;
        }
        generarCup();
        try {
            Reader file = new BufferedReader(new FileReader(archivo_seleccionado.ruta));
            this.cons.setText("");
            StringReader asa = new StringReader(archivo_seleccionado.contenido);
            AnalizadorLexico lexera = new AnalizadorLexico(asa);
            ASintactico as = new ASintactico(lexera);
            ASintactico.errores = "";
            as.setList(ls);
            as.setLex(lexera);
            as.parse();
            ls = as.ls;
            this.cons.setText(as.errores);
            
            if("".equals(as.errores)){
                this.cons.setText("----------------------------**Analisis exitoso**----------------------------");
                //Nodo raiz = as.padre;
                //Graficar(recorrido(raiz), "AST_PROYECTO");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        in=new Interfaz(ls,this);
        tabla=new InterfazTablaSimbolos(ls,this);
        
             
    }
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(tabla == null)
            return;
        tabla.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if(in == null)
            return;
        in.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    public void generarCup(){
       String[] asintactico = {"-parser", "ASintactico", "./src/Analisis_Lexico/sintactico.cup"};                   
                    try {
                        java_cup.Main.main(asintactico);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
        if(moverArch("ASintactico.java"))
            return;
    }
    public static boolean moverArch(String archNombre) {
       boolean efectuado = false;
       File arch = new File(archNombre);
       if (arch.exists()) {
           System.out.println("\n*** Moviendo " + arch + " \n***");
           Path currentRelativePath = Paths.get("");
           System.out.println(currentRelativePath.toString());
           String nuevoDir = currentRelativePath.toAbsolutePath().toString()
                   + File.separator + "src" + File.separator
                   + "Analisis_Lexico" + File.separator + arch.getName();
           File archViejo = new File(nuevoDir);
           archViejo.delete();
           if (arch.renameTo(new File(nuevoDir))) {
               System.out.println("\n*** Generado " + archNombre + "***\n");
               efectuado = true;
           } else {
               System.out.println("\n*** No movido " + archNombre + " ***\n");
           }

       } else {
           System.out.println("\nGenerando analisis sintatico \n");
       }
       return true;
    }
    private String recorrido(Nodo raiz) {
      String cuerpo = "";
        for (Nodo hijos : raiz.hijos) {
     
        
            
            if(raiz.valor==null){
                cuerpo += "\"" + raiz.idNod + "_" + raiz.Etiqueta ;
            }else {
                cuerpo += "\"" + raiz.idNod + "_(" + raiz.Etiqueta+")" + raiz.valor ; }
            
        if(!("VACIO".equals(hijos.Etiqueta))){   
            if (hijos.valor==null){
                cuerpo +=  "\"->\"" + hijos.idNod + "_" + hijos.Etiqueta + "\"";
            }else{
                cuerpo +=  "\"->\"" + hijos.idNod + "_(" + hijos.Etiqueta+")" + hijos.valor +"\"" ;
            }
          }else {cuerpo += "\"";}
        cuerpo += recorrido(hijos);
        }
        return cuerpo;
    }

    private void Graficar(String cadena, String cad) {
   
            FileWriter fichero = null;
        PrintWriter pw = null;
        String nombre = cad;
        String archivo = nombre + ".dot";
        try {
            fichero = new FileWriter(archivo);
            pw = new PrintWriter(fichero);
            pw.println("digraph G {node[shape=box, style=filled, color=Gray95]; edge[color=blue];rankdir=UD \n");
            pw.println(cadena);
            pw.println("\n}");
            fichero.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            String cmd = "dot.exe -Tpng " + nombre + ".dot -o " + cad + ".png"; //Comando de apagado en linux
            Runtime.getRuntime().exec(cmd);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    } 
     
     
    private final String ruta_default="./src/Archivos_creados/"; 
    public Tabla_Simbolos tabla_simbolos=new Tabla_Simbolos();
    public ArrayList<Archivos> archivos_abiertos=new ArrayList<Archivos>();
    public  Archivos archivo_seleccionado;
    public Analisis_Lexico analisis_lexico;
    public Manejador_Errores manejador_errores = new Manejador_Errores();
    private int id_archivo;
    Interfaz in;
    InterfazTablaSimbolos tabla;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton analizar_lexico;
    private javax.swing.JTree archivos;
    private javax.swing.JMenuItem btn_abrir;
    private javax.swing.JMenuItem btn_abrir_carpeta;
    private javax.swing.JMenuItem btn_guardar;
    private javax.swing.JMenuItem btn_guardar_todos;
    private javax.swing.JMenu btn_nuevo;
    private javax.swing.JMenuItem btn_nuevo_archivo;
    private javax.swing.JMenuItem cerrar;
    public javax.swing.JEditorPane cons;
    private javax.swing.JMenuItem eliminar_archivo;
    private javax.swing.JMenuItem guardar_como;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JScrollPane panel_consola;
    public javax.swing.JTabbedPane tabs;
    // End of variables declaration//GEN-END:variables
}