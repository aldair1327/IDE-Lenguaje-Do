package Analisis_Lexico;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author titab
 */
public class EstiloGramatica extends DefaultStyledDocument{
    JTextPane textPane;
    
    //Los pinches colores
    final StyleContext cont;
    final AttributeSet red;
    final AttributeSet black;
    public EstiloGramatica(JTextPane textPane){
        this.textPane = textPane;
        
        //Colores
        cont = StyleContext.getDefaultStyleContext();
        red = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(252, 53, 10));
        black = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLACK);
    }//Fin constructor
    
    public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
        super.insertString(offset, str, a);
        
        String texto="";
        texto = textPane.getText(0, getLength());
        int before = findLastNonWordChar(texto, offset);
        if (before < 0) {
            before = 0;
        }
        int after = findFirstNonWordChar(texto, offset + str.length());
        int wordL = before;
        int wordR = before;
        
        while (wordR <= after) {
                    if (wordR == after || String.valueOf(texto.charAt(wordR)).matches("\\W")) {

                        if (texto.substring(wordL, wordR).matches("(\\W)(ERROR)*")) {
                            setCharacterAttributes(wordL, wordR - wordL, red, false);
                        }

                        wordL = wordR;
                    }
                    wordR++;
                }
    }//Fin insertString
    
    private int findFirstNonWordChar(String text, int index) {
        while (index < text.length()) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
            index++;
        }
        return index;
    }
    
    private int findLastNonWordChar(String text, int index) {
        while (--index >= 0) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
        }
        return index;
    }
}//Fin clase
