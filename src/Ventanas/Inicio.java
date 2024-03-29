/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Analisis_Lexico.ASintactico;
import Analisis_Lexico.Analisis_Lexico;
import Analisis_Lexico.Token_;
import Analisis_Lexico.AnalizadorLexico;
import Analisis_Lexico.Arbol.AnalisisArbol;
import Analisis_Lexico.Arbol.ArbolAsignacion;
import Analisis_Lexico.Automata_finito.AutomataFinitoN;
import Analisis_Lexico.EstiloGramatica;
import Analisis_Lexico.PilaAutomata.ValidacionPila;
//import Analisis_Lexico.EstiloDocumento;
import Analisis_Lexico.Interfaz;
import Analisis_Lexico.InterfazTablaSimbolos;
import Analisis_Lexico.Nodo;
import Analisis_Lexico.OpeTabla;
import Analisis_Lexico.Semantico.Validaciones;
import Analisis_Lexico.TextLineNumber;
import Archivos.Archivos;
import BajoNivel.convertirListaATexto;
import BajoNivel.imprimirCI;
import Manejador_errores.Manejador_Errores;
import Miscelaneos.Miscelaneo;
import Tabla_Simbolos.Tabla_Simbolos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;
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
    
    public OpeTabla optab = new OpeTabla();
    Token_ idAAsig = null;
    Token_ idAComp = null;
    String tipo_aAsig="";
    String tipo_aComp="";
    String valor_aComp="";

    StyledDocument doc;
            Style style;
    
    public Inicio() {
        initComponents();
        analisis_lexico = new Analisis_Lexico();
        Image i = null;
        try {
            i = ImageIO.read(getClass().getResource("/Imagenes/music.png"));
        } catch (IOException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        setIconImage(i);
        //LineNumber del codigo intermedio
        TextLineNumber tln = new TextLineNumber(mostrarAutomata.textPane_Intermedio);
        
        tln.setBackground(new Color(38,50,56));
        tln.setForeground(new Color(238,255,255));
        tln.setFont(mostrarAutomata.textPane_Intermedio.getFont());
        mostrarAutomata.jScrollPane_intermedio.setRowHeaderView( tln );
        
        //LineNumber del codigo optimizado
        TextLineNumber tln2 = new TextLineNumber(mostrarAutomata.textPane_Optimizado);
        
        tln2.setBackground(new Color(38,50,56));
        tln2.setForeground(new Color(238,255,255));
        tln2.setFont(mostrarAutomata.textPane_Optimizado.getFont());
        mostrarAutomata.jScrollPane_optimizado.setRowHeaderView( tln2 );
        
        //Line number gramatica
        TextLineNumber tln3 = new TextLineNumber(mostrarAutomata.jTextPane_Gramatica);
        
        tln3.setBackground(new Color(38,50,56));
        tln3.setForeground(new Color(238,255,255));
        tln3.setFont(mostrarAutomata.jTextPane_Gramatica.getFont());
        mostrarAutomata.jScrollPane_Gramatica.setRowHeaderView( tln3 );
        
        //Line number codigo maquina
        TextLineNumber tln4 = new TextLineNumber(mostrarAutomata.textPane_Maquina);
        
        tln4.setBackground(new Color(38,50,56));
        tln4.setForeground(new Color(238,255,255));
        tln4.setFont(mostrarAutomata.textPane_Maquina.getFont());
        mostrarAutomata.jScrollPane_maquina.setRowHeaderView( tln4 );
        
         
            doc = new EstiloGramatica(mostrarAutomata.jTextPane_Gramatica);
            mostrarAutomata.jTextPane_Gramatica.setDocument(doc);

            style = mostrarAutomata.jTextPane_Gramatica.addStyle("I'm a Style", null);
            this.getContentPane().setBackground(new Color(255, 203, 87));
            //255, 234, 163
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        archivos = new javax.swing.JTree();
        btnGrabar = new javax.swing.JButton();
        btnCargar = new javax.swing.JButton();
        analizar_lexico = new javax.swing.JButton();
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
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        btnVPila = new javax.swing.JMenuItem();

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
                    .addComponent(panel_consola, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
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

        btnGrabar.setBackground(new java.awt.Color(255, 0, 0));
        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/rec_16.png"))); // NOI18N
        btnGrabar.setText("Grabar Canción");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnCargar.setBackground(new java.awt.Color(0, 153, 255));
        btnCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/baseline_unarchive_black_18dp.png"))); // NOI18N
        btnCargar.setText("Cargar");
        btnCargar.setEnabled(false);
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        analizar_lexico.setBackground(new java.awt.Color(0, 204, 153));
        analizar_lexico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/play.png"))); // NOI18N
        analizar_lexico.setText("Compilar");
        analizar_lexico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analizar_lexicoActionPerformed(evt);
            }
        });

        btn_nuevo.setText("Archivo");

        btn_nuevo_archivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        btn_nuevo_archivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/baseline_add_black_18dp.png"))); // NOI18N
        btn_nuevo_archivo.setText("Nuevo Archivo");
        btn_nuevo_archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevo_archivoActionPerformed(evt);
            }
        });
        btn_nuevo.add(btn_nuevo_archivo);

        btn_abrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        btn_abrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/baseline_insert_drive_file_black_18dp.png"))); // NOI18N
        btn_abrir.setText("Abrir Archivo");
        btn_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_abrirActionPerformed(evt);
            }
        });
        btn_nuevo.add(btn_abrir);

        btn_abrir_carpeta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        btn_abrir_carpeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/baseline_folder_black_18dp.png"))); // NOI18N
        btn_abrir_carpeta.setText("Abrir Carpeta");
        btn_abrir_carpeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_abrir_carpetaActionPerformed(evt);
            }
        });
        btn_nuevo.add(btn_abrir_carpeta);
        btn_nuevo.add(jSeparator2);

        btn_guardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/baseline_save_black_18dp.png"))); // NOI18N
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
        cerrar.setText("Salir");
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });
        btn_nuevo.add(cerrar);

        jMenuBar1.add(btn_nuevo);

        jMenu2.setText("Mostrar Tablas");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/baseline_font_download_black_18dp.png"))); // NOI18N
        jMenuItem1.setText("Tabla de variables");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/baseline_table_chart_black_18dp.png"))); // NOI18N
        jMenuItem2.setText("Tabla general");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);
        jMenu2.add(jSeparator3);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/baseline_account_tree_black_18dp.png"))); // NOI18N
        jMenuItem3.setText("Autómata Finito");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Gramática");
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Árbol de expresiones");
        jMenu2.add(jMenuItem5);
        jMenu2.add(jSeparator4);

        jMenuItem6.setText("Código intermedio");
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Código optimizado");
        jMenu2.add(jMenuItem7);
        jMenu2.add(jSeparator5);

        btnVPila.setText("Pila Asignaciones");
        btnVPila.setEnabled(false);
        btnVPila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVPilaActionPerformed(evt);
            }
        });
        jMenu2.add(btnVPila);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170)
                        .addComponent(analizar_lexico, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCargar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(analizar_lexico, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnGrabar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
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
     btnVPila.setEnabled(true);
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
            AnalisisArbol analisisArbol = new AnalisisArbol();
            ASintactico.errores = "";
            as.setList(ls);
            as.setLex(lexera);
            as.parse();
            ls = as.ls;
            Validaciones v = new Validaciones();
            
            as.errores += v.AsignacionSimple(as.asig_simples, ls);
            as.errores += v.InicializarVariable(as.asig_Ini, ls);
            as.errores += v.OpLogSimples(as.op_log,ls);
            as.errores += v.IncVar(as.inc_var, ls);
            as.errores += v.parametros(as.param, ls);
            this.cons.setText(as.errores);
            
            
              
            /***************Arboles***************/
            Dimension tamaño = new Dimension(1920, 1080);
            mostrarAutomata.panelArbol.removeAll();
            mostrarAutomata.panelArbol.add("asd",analisisArbol.automataDeclaraciones(ls,mostrarAutomata.panelArbol,mostrarAutomata.panelOptimizado)); 
            mostrarAutomata.panelArbol.getComponents()[0].setSize(tamaño);
            /***************Arboles***************/
            
            for(int j = 0; j<as.codop.size();j++){
                   
                     as.codop.set(j,as.codop.get(j).replaceAll("DO", "130.80"));     
                     as.codop.set(j,as.codop.get(j).replaceAll("RE", "146.80"));
                     as.codop.set(j,as.codop.get(j).replaceAll("MI", "164.80"));
                     as.codop.set(j,as.codop.get(j).replaceAll("FA", "174.60"));
                     as.codop.set(j,as.codop.get(j).replaceAll("SOL", "196.00"));
                     as.codop.set(j,as.codop.get(j).replaceAll("LA", "220.00"));
                     as.codop.set(j,as.codop.get(j).replaceAll("SII", "246.90"));
                 }
            imprimirCI intermedio = new imprimirCI(archivo_seleccionado.nombre_archivo);
            //Codigo maquina
            intermedio.imprimir2(as.codop);
            
            for(int j = 0; j<as.ci.size();j++){
                   
                     as.ci.set(j,as.ci.get(j).replaceAll("tone", "reproduce"));     
                     as.ci.set(j,as.ci.get(j).replaceAll("delay", "continuar"));
                     as.ci.set(j,as.ci.get(j).replaceAll("for", "por"));
                     as.ci.set(j,as.ci.get(j).replaceAll("if", "si"));
                     as.ci.set(j,as.ci.get(j).replaceAll("while", "mientras"));
                 }            
            
            /*Lo de willy para mandarlo a la ventana de codigo intermedio*/
            convertirListaATexto imprimir_sinOptimizar = new convertirListaATexto(as.ci);
            mostrarAutomata.textPane_Intermedio.setText(imprimir_sinOptimizar.getTexto());
            /*Fin lo de willy*/
            
            //Intermedio sin optimizar
            intermedio.imprimir3(as.ci);
            
            
            for(int i = 1; i< as.listavar.size();i++){
                 for(int j = 0; j<as.codop.size();j++){
                   
                     as.codop.set(j,as.codop.get(j).replaceAll("\\b"+as.listavar.get(i)+"\\b", "temp"+i));     
                     
                 }
            }
            
            /*Lo de willy para mandarlo a la ventana de codigo optimizado*/
            
            /*Fin lo de willy*/
            convertirListaATexto imprimir_Optimizado = new convertirListaATexto(as.codop);
            mostrarAutomata.textPane_Optimizado.setText(imprimir_Optimizado.getTexto());
            mostrarAutomata.textPane_Maquina.setText(imprimir_Optimizado.getTexto());
            //Codigo optimizado
            intermedio.imprimir(as.codop);// de ls se optienen los lexemas y componentes lexicos
            
            /*IMPRIMIR LA GRAMATICA*/
            String gramatica_impresa = "terminal AND, OR , NOT, ADD, MUL, MIN, DIV,PLUSPLUS,MINMIN, ASIG,ADDASIG,MINASIG,DIVASIG,MULASIG,MAYTHAN,\n"
                    + "MINTHAN,MAYEQUAL,MINEQUAL,EQUAL,NOTEQUAL,COMILLA,\n" +
                "COMA,PAROPEN,PARCLOSE,COROPEN,CORCLOSE,KEYOPEN,KEYCLOSE,PUNTO_Y_COMA,MIENTRAS,REPRODUCE,SI,SINO,IMPORTAR,ROMPER,CONTINUAR,VOLUMEN,FRECUENCIA,SILENCIO,VERDADERO,\n" +
                "FALSO,NULO,IMPRIMIR,NOTA,VACIO,CADENA,INICIO,idNoVal,ENTERO,ID,ERROR,numEntero, POR , VV,DO,RE,MI,FA,SOL,LA,SII, DOS,RES,MIS,FAS,SOLS,LAS,SIS, BOOLEANO  ;\n" +
                "\n\n" +
                "non terminal inicio, cuerpo, inicializarVariable,\n" +
                "decvariables, dato, sentencia_si, condicion, cond, log, ope_relacional, op_rel, sig_rel, acciones, asignar, llamarFuncion,\n"
                    + "valoresCamion, cuerpoFuncion, cuerpo_sentencia_si1, sentencia_mientras,\n" +
                "incrementar_var,  funcionesDo,declaraReproduce , declaraImprimir , declaraImportar , declaraContinuar , declaraSilencio ,\n" +
                "declaraVolumen , declaraFrecuencia ,opasig , datoasig, tipo, ciclos, operacion, ari, rel, opers, sentencia_por, ope_logico,\n "
                    + "arreglo, asig_arreglo, datos, log2,errores,errores1,ciclos_errores, notas,notapuras, asignarDeclaracion,paramRero;\n" +
                "   \n" +
                "start with inicio;\n\n";
            
            ArrayList<String> gramatica = new ArrayList<String>();
            
         
            for(int i = as.producciones.size()-1; i >= 0; i--) {
                gramatica.add(as.producciones.get(i));
            }
            
            convertirListaATexto temp = new convertirListaATexto(gramatica);
            String tempo = temp.getTexto();
            gramatica_impresa += tempo;
            
           
            mostrarAutomata.jTextPane_Gramatica.setText(gramatica_impresa);
            //EstiloGramatica tgmp = new EstiloGramatica(mostrarAutomata.jTextPane_Gramatica);
            //mostrarAutomata.jTextPane_Gramatica.

            vPila.tabPanel.removeAll();
            
            
            
            //AHI VIENE LO DE WILLY y Gaby
                // AutomataFN - Declaraciones
                automataDeclaraciones(ls);
            
            //TERMINA LO DE WILLY y Gaby
            
            if("".equals(as.errores)){
               
                this.cons.setText("*******************************COMPILACIÓN CON EXITO*******************************");
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
    
   
    private void automataDeclaraciones(ArrayList<Token_> ts){
        ArrayList<Token_> lista_declaraciones = new ArrayList<>();
            Boolean inicio_declaracion = false;
            JTabbedPane tabbedPane = new JTabbedPane();
            JTabbedPane tPilaA = new JTabbedPane();
            
            for(Token_ elemento : ts){
                switch (elemento.lexema.trim()) {
                    case "entero":
                        inicio_declaracion = true;
                        elemento.componente_lexico = "ENTERO";
                        //lista_declaraciones.add(elemento);
                        break;
                    case "nota":
                        inicio_declaracion = true;
                        elemento.componente_lexico = "NOTA";
                        //lista_declaraciones.add(elemento);
                        break;
                    case "cadena":
                        inicio_declaracion = true;
                        elemento.componente_lexico = "CADENA";
                        //lista_declaraciones.add(elemento);
                        break;
                    
                    case ";":
                        if (inicio_declaracion) {
                            inicio_declaracion = false;
                            lista_declaraciones.add(elemento);
                            AutomataFinitoN automata = new AutomataFinitoN(lista_declaraciones);
                            ValidacionPila pila= new ValidacionPila(lista_declaraciones);
                            tPilaA.addTab("Tab",pila.genararAutomata());
                            tabbedPane.addTab("Tab",automata.genararAutomata());
                            lista_declaraciones.clear();
                        }
                }
                if (inicio_declaracion) {
                    lista_declaraciones.add(elemento);
                }
            }
            
            if (tabbedPane.getTabCount() > 0) {
                Dimension tamaño = new Dimension(1920, 1080);
                Icon iconStack = new ImageIcon(getClass().getResource("/Imagenes/stack.png"));
                mostrarAutomata.panelAutomata.removeAll();
                mostrarAutomata.panelAutomata.add("as",tabbedPane);
                mostrarAutomata.panelAutomata.getComponents()[0].setSize(tamaño);
                vPila.tabPanel.addTab("Pila - Declaraciones",iconStack, tPilaA, "STACK- DEC");
            }
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

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        mostrarAutomata.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void btnVPilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVPilaActionPerformed
        vPila.setVisible(true);
    }//GEN-LAST:event_btnVPilaActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        try
        {  
         // We are running "dir" and "ping" command on cmd 
         Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"python c:/pruebas/musicalNoteDetector.py\""); 
        } 
        catch (Exception e) 
        { 
            System.out.println("HEY Buddy ! U r Doing Something Wrong "); 
            e.printStackTrace(); 
        }
        btnCargar.setEnabled(true);
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        String texto="";
        try {
            String ruta=ruta_cargar;
            String cadena;
            FileReader f = new FileReader(ruta);
            BufferedReader b = new BufferedReader(f);
            while((cadena = b.readLine())!=null) {
                texto+=cadena+"\n";
            }
            b.close();
        } catch (IOException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        Archivos ar=new Archivos(ruta_default+"Nuevo Archivo "+id_archivo+".do","Nuevo Archivo "+id_archivo+".do");
        archivos_abiertos.add(ar);
        this.archivo_seleccionado=ar;
        archivo_seleccionado.contenido=texto;
        this.archivo_seleccionado.guardado=false;
        Miscelaneo.actualizar_tab(tabs, archivos_abiertos,this);
        Miscelaneo.seleccionar_tab(tabs, archivos_abiertos, ar);
        id_archivo++;
        
        btnCargar.setEnabled(false);
    }//GEN-LAST:event_btnCargarActionPerformed
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
     
     
    private final String ruta_default="./src/Archivos_creados/";
    private final String ruta_cargar="C:\\pruebas\\DoRec.txt";
    public Tabla_Simbolos tabla_simbolos=new Tabla_Simbolos();
    public ArrayList<Archivos> archivos_abiertos=new ArrayList<Archivos>();
    public  Archivos archivo_seleccionado;
    public Analisis_Lexico analisis_lexico;
    public Manejador_Errores manejador_errores = new Manejador_Errores();
    private int id_archivo;
    Interfaz in;
    InterfazTablaSimbolos tabla;
    ArbolAsignacion arbolesAeignacion= new ArbolAsignacion();
    MostrarTablas mostrarAutomata = new MostrarTablas();
    Pila vPila=new Pila();
    
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
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JMenuItem btnVPila;
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
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JScrollPane panel_consola;
    public javax.swing.JTabbedPane tabs;
    // End of variables declaration//GEN-END:variables
}