/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis_Lexico;

import Archivos.Archivos;
import Miscelaneos.Renders.Tab;
import Ventanas.Inicio;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JTextPane;

/**
 *
 * @author edgar
 */
public class Analisis_Lexico {
    public AnalizadorLexico lexer;
    public class Token_{
        public String lexema,componente_lexico; 
        public int numero_linea;
        public String contenido_linea;
    }
    private final String ruta_lexer="./src/Analisis_Lexico/Lexer.jflex";
    
    public ArrayList<Token_> obtener_lexemas(Archivos archivo) throws IOException{
        ArrayList<Token_> lista_tokens=new ArrayList<Token_>();
        try{
            File file_ = new File(ruta_lexer);
            jflex.Main.generate(file_);
            Reader file = new BufferedReader(new FileReader(archivo.ruta));
            BufferedReader reader = new BufferedReader(new FileReader(archivo.ruta));
            
             lexer = new AnalizadorLexico(file);
            Symbol s = (Symbol)lexer.next_token();
            int numero_linea=1;
            String line=reader.readLine();
            while(s.sym !=0){
                lexer.pintar.insertar(reader.readLine());
                String token = lexer.comp;
                System.err.println(s.sym);
                System.err.println(lexer.comp);
                if(token == null){
                    break;
                }
                if("SALTO".equals(token)){
                    numero_linea++;
                    line=reader.readLine();
                    continue;
                }
                
                Token_ t=new Token_();
                t.lexema=lexer.lexeme;
                t.componente_lexico=lexer.comp;//token.toString();
                t.numero_linea=numero_linea;
                t.contenido_linea= line;
                lista_tokens.add(t);
                s = (Symbol)lexer.next_token();
            }
        }catch(Exception e){
        }
        return lista_tokens;
    }
    
    /*public void hacerLex() throws IOException{
    txtErrores.setText("");
    DefaultTableModel tm=(DefaultTableModel)Table.getModel();
    palabrasReservadasLexema.clear();
    palabrasReservadasComponente.clear();
    identificadores.clear();
    StringReader sr = new StringReader(txtCodigo.getText());
     AnalizadorLexico lex = new AnalizadorLexico(sr);
      tm.setRowCount(0);
      Symbol s = (Symbol)lex.next_token();
      //System.out.println(s.sym + " el S.sym");
      int contador = 0;
      while(s.sym != 0){
          //System.out.println(lex.comp+" comp linea> "+(lex.linea+1));
          if(!lex.comp.equals("error")){
              agregar_tabla(tm, (lex.linea+1), lex.comp, lex.lexeme);
              // Codigo de Identificador
              if(s.sym == 14){
                  System.out.println("Lexema: " + tm.getValueAt(contador, 0) + " Componente lexico: " + tm.getValueAt(contador, 1));
                  
                  identificadores.add(tm.getValueAt(contador, 0)+ "");
                  
              }
              // Codigo de palabra reservada
              if (s.sym == 13) {
                  System.out.println("Lexema: " + tm.getValueAt(contador, 0) + " Componente lexico: " + tm.getValueAt(contador, 1));
                  //System.out.println(lex.lexeme);
                  palabrasReservadasLexema.add(tm.getValueAt(contador, 0)+"");
                  palabrasReservadasComponente.add(tm.getValueAt(contador, 0).toString());
              }
              //System.out.println("Lexem  "+lex.lexeme+"   token  "+s.sym+"  linea> "+(lex.linea+1));
          }else{
              agregar_tabla(tm, (lex.linea+1), lex.comp, lex.lexeme);
              txtErrores.setText(txtErrores.getText()+"Error Lexico. Linea "+(lex.linea+1)+".  La cadena <<"+lex.lexeme+">> no es valida.\n");
          }
          s = (Symbol)lex.next_token();
          contador ++;
      }
    }*/
}
