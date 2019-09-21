/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis_Lexico;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author Eric
 */
public class Pintar_Palabras {
    public JTextPane caja2=new JTextPane(); 
    public StyleContext sc = new StyleContext();
    public DefaultStyledDocument doc = new DefaultStyledDocument(sc);

    public void insertar(String texto){
        caja2.setDocument(doc);
        try {
            doc.insertString(0,texto,null);

        }catch (Exception ex) {
            System.out.println("ERROr: no se pudo establecer estilo de documento");
        }
   
   }
   
   public void pintaRojo(int posini,int posfin){
      Style rojo = sc.addStyle("ConstantWidth", null);
      StyleConstants.setForeground(rojo, Color.red);
      doc.setCharacterAttributes(posini,posfin, rojo, false);

   }
   
     public void pintaVerde(int posini,int posfin){
            Style verde = sc.addStyle("ConstantWidth", null);
            StyleConstants.setForeground(verde, Color.green);
            doc.setCharacterAttributes(posini,posfin, verde, false);
     }
   
       public void pintaAzul(int posini,int posfin){
            Style azul = sc.addStyle("ConstantWidth", null);
            StyleConstants.setForeground(azul, Color.blue);
            doc.setCharacterAttributes(posini,posfin, azul, false);
       
       } 
   
        public void pintaAzulO(int posini,int posfin){
            Style azulo = sc.addStyle("ConstantWidth", null);
            StyleConstants.setForeground(azulo, Color.getHSBColor(240, 100, 55));
            doc.setCharacterAttributes(posini,posfin, azulo, false);
       
       } 
        
         public void pintaCafe(int posini,int posfin){
            Style cafe = sc.addStyle("ConstantWidth", null);
            StyleConstants.setForeground(cafe, Color.getHSBColor(0, 75, 65));
            doc.setCharacterAttributes(posini,posfin, cafe, false);
         }
         
         public void pintaMora(int posini,int posfin){
            Style mora = sc.addStyle("ConstantWidth", null);
            StyleConstants.setForeground(mora, Color.getHSBColor(271, 81, 89));
            doc.setCharacterAttributes(posini,posfin,mora, false);
         }
         
         public void pintaNara(int posini,int posfin){
            Style nara = sc.addStyle("ConstantWidth", null);
            StyleConstants.setForeground(nara, Color.getHSBColor(33, 100, 100));
            doc.setCharacterAttributes(posini,posfin,nara, false);
         }
}
