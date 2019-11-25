package Analisis_Lexico;

/* --------------------------Codigo de Usuario----------------------- */


import java_cup.runtime.*;
import java.io.Reader;
      
%%
%class AnalizadorLexico
%cup
%public
%unicode
%line
%column
%char
%{
    /*  Generamos un java_cup.Symbol para guardar el tipo de token 
        encontrado */
    public Symbol symbol(int type) {
        return new Symbol(type, yyline+1, columna+1);
    }
    
    /* Generamos un Symbol para el tipo de token encontrado 
       junto con su valor */
    public Symbol symbol(int type,Object value) {
        
        return new Symbol(type, yyline+1, columna+1, value);
    }
    public int linea,columna;
    public String lexeme,cadena;
    public String comp;
%}

L = [a-zA-Z_]
D = [0-9]
P = [.0-9]
ABC = {L}
WHITE=[ \t\r]
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]
/* comments */
Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}
TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*
CommentContents       =  ( [^*] | \*+ [^/*] )* 
Novalidos = ("."|":"|"?"|"""|"!"|"#"|"&"|"@"|"\"|"^"|"`"|"|"|"~"|"¡"|"¨"|"¯"|"°"|"´"|"¿"|"À"|"Á"|"Ã"|"Ä"|"Ç"|"È"|"É"|"Ë"|"Ì"|"Í"|"Í"|"Ñ"|"Ò"|"Ò"|"Õ"|"Ö"|"Ù"|"Ú"|"Ü"|"à"|"á"|"ã"|"ä"|"ç"|"è"|"é"|"ë"|"ì"|"í"|"ï"|"ñ"|"ò"|"ó"|"õ"|"ö"|"ù"|"ú"|"ü")
%{
Pintar_Palabras pintar = new Pintar_Palabras();

%}
%%

{WHITE} {/*Ignore*/}
{Comment} {/*Ignore*/}
"//" {/*Ignore*/}
"\n" {/*Ignore*/}
"&" {lexeme=yytext(); comp="LOGICO"; return new Symbol(sym.AND, yychar,yyline,yytext());}
"|" {lexeme=yytext(); comp="LOGICO"; return new Symbol(sym.OR, yychar,yyline,yytext());}
"!" {lexeme=yytext(); comp="LOGICO"; return new Symbol(sym.NOT, yychar,yyline,yytext());}

"+"  {lexeme=yytext(); comp="ARITMETICO"; return new Symbol(sym.ADD, yychar,yyline,yytext());}
"*"  {lexeme=yytext(); comp="ARITMETICO"; return new Symbol(sym.MUL, yychar,yyline,yytext());}
"-"  {lexeme=yytext(); comp="ARITMETICO"; return new Symbol(sym.MIN, yychar,yyline,yytext());}
"/"  {lexeme=yytext(); comp="ARITMETICO"; return new Symbol(sym.DIV, yychar,yyline,yytext());}
"++"  {lexeme=yytext(); comp="ARITMETICO"; return new Symbol(sym.PLUSPLUS, yychar,yyline,yytext());}
"--"  {lexeme=yytext(); comp="ARITMETICO"; return new Symbol(sym.MINMIN, yychar,yyline,yytext());}


"+="  {lexeme=yytext(); comp="MASIGUAL"; return new Symbol(sym.ADDASIG, yychar,yyline,yytext());}
"-=" {lexeme=yytext(); comp="MINIGUAL"; return new Symbol(sym.MINASIG, yychar,yyline,yytext());}
"/="  {lexeme=yytext(); comp="DIVIGUAL"; return new Symbol(sym.DIVASIG, yychar,yyline,yytext());}
"*="  {lexeme=yytext(); comp="PORIGUAL"; return new Symbol(sym.MULASIG, yychar,yyline,yytext());}
"="  {lexeme=yytext(); comp="ASSIGNACION"; return new Symbol(sym.ASIG, yychar,yyline,yytext());}

">"  {lexeme=yytext(); comp="RELACIONAL"; return new Symbol(sym.MAYTHAN, yychar,yyline,yytext());}
"<"  {lexeme=yytext(); comp="RELACIONAL"; return new Symbol(sym.MINTHAN, yychar,yyline,yytext());}
">="  {lexeme=yytext(); comp="RELACIONAL"; return new Symbol(sym.MAYEQUAL, yychar,yyline,yytext());}
"<="  {lexeme=yytext(); comp="RELACIONAL"; return new Symbol(sym.MINEQUAL, yychar,yyline,yytext());}
"==" {lexeme=yytext(); comp="RELACIONAL"; return new Symbol(sym.EQUAL, yychar,yyline,yytext());}
"!=" {lexeme=yytext(); comp="RELACIONAL"; return new Symbol(sym.NOTEQUAL, yychar,yyline,yytext());}



"'"  {lexeme=yytext(); comp="AGRUPACION"; return new Symbol(sym.COMILLA, yychar,yyline,"'");}
","  {lexeme=yytext(); comp="AGRUPACION"; return new Symbol(sym.COMA, yychar,yyline,",");}
"("  {lexeme=yytext(); comp="AGRUPACION"; return new Symbol(sym.PAROPEN, yychar,yyline,"(");}
")"  {lexeme=yytext(); comp="AGRUPACION"; return new Symbol(sym.PARCLOSE, yychar,yyline,")");}
"["  {lexeme=yytext(); comp="AGRUPACION"; return new Symbol(sym.COROPEN, yychar,yyline,"[");}
"]"  {lexeme=yytext(); comp="AGRUPACION"; return new Symbol(sym.CORCLOSE, yychar,yyline,"]");}
"{"  {lexeme=yytext(); comp="AGRUPACION"; return new Symbol(sym.KEYOPEN, yychar,yyline,"{");}
"}"  {lexeme=yytext(); comp="AGRUPACION"; return new Symbol(sym.KEYCLOSE, yychar,yyline,"}");}

";"  {lexeme=yytext(); comp="PUNTO_Y_COMA"; return new Symbol(sym.PUNTO_Y_COMA, yychar,yyline,yytext());}

"inicio" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext(); comp="PALABRA_RESERVADA";return new Symbol(sym.INICIO, yychar,yyline,"inicio");}
"mientras" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext(); comp="PALABRA_RESERVADA";return new Symbol(sym.MIENTRAS, yychar,yyline,"mientras");}
"reproduce" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext(); comp="PALABRA_RESERVADA";return new Symbol(sym.REPRODUCE, yychar,yyline,"reproduce");}
"si" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext(); comp="PALABRA_RESERVADA";return new Symbol(sym.SI, yychar,yyline,"si");}
"sino" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext();comp="PALABRA_RESERVADA";return new Symbol(sym.SINO, yychar,yyline,"sino");}
"importar" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext();comp="PALABRA_RESERVADA";return new Symbol(sym.IMPORTAR, yychar,yyline,"importar");}
"romper"   {pintar.pintaAzul(yychar,yylength()); lexeme=yytext();comp="PALABRA_RESERVADA";return new Symbol(sym.ROMPER, yychar,yyline,"romper");}
"continuar" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext();comp="PALABRA_RESERVADA";return new Symbol(sym.CONTINUAR, yychar,yyline,"continuar");}
"volumen" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext();comp="PALABRA_RESERVADA";return new Symbol(sym.VOLUMEN, yychar,yyline,"volumen");}
"frecuencia" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext();comp="PALABRA_RESERVADA";return new Symbol(sym.FRECUENCIA, yychar,yyline,"frecuencia");}
"silencio" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext();comp="PALABRA_RESERVADA";return new Symbol(sym.SILENCIO, yychar,yyline,"silencio");}
"verdadero" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext();comp="PALABRA_RESERVADA";return new Symbol(sym.VERDADERO, yychar,yyline,"verdadero");}
"falso"   {pintar.pintaAzul(yychar,yylength()); lexeme=yytext();comp="PALABRA_RESERVADA";return new Symbol(sym.FALSO, yychar,yyline,"falso");}
"nulo" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext();comp="PALABRA_RESERVADA";return new Symbol(sym.NULO, yychar,yyline,"nulo");}
"imprimir" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext();comp="PALABRA_RESERVADA";return new Symbol(sym.IMPRIMIR, yychar,yyline,"imprimir");}
"nota" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext();comp="PALABRA_RESERVADA";return new Symbol(sym.NOTA, yychar,yyline,"nota");}
"vacio" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext();comp="PALABRA_RESERVADA";return new Symbol(sym.VACIO, yychar,yyline,"vacio");}
"cadena" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext();comp="PALABRA_RESERVADA";return new Symbol(sym.CADENA, yychar,yyline,"cadena");}
"entero" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext();comp="PALABRA_RESERVADA";return new Symbol(sym.ENTERO, yychar,yyline,"entero");}
"por" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext(); comp="PALABRA_RESERVADA";return new Symbol(sym.POR, yychar,yyline,"por");}

"booleano" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext(); comp="PALABRA_RESERVADA";return new Symbol(sym.BOOLEANO, yychar,yyline,"booleano");}

"DO" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext(); comp="PALABRA_RESERVADA";return new Symbol(sym.DO, yychar,yyline,"DO");}
"RE" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext(); comp="PALABRA_RESERVADA";return new Symbol(sym.RE, yychar,yyline,"RE");}
"MI" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext(); comp="PALABRA_RESERVADA";return new Symbol(sym.MI, yychar,yyline,"MI");}
"FA" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext(); comp="PALABRA_RESERVADA";return new Symbol(sym.FA, yychar,yyline,"FA");}
"SOL" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext(); comp="PALABRA_RESERVADA";return new Symbol(sym.SOL, yychar,yyline,"SOL");}
"LA" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext(); comp="PALABRA_RESERVADA";return new Symbol(sym.LA, yychar,yyline,"LA");}
"SI" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext(); comp="PALABRA_RESERVADA";return new Symbol(sym.SII, yychar,yyline,"SII");}


/*
"DO'" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext(); comp="PALABRA_RESERVADA";return new Symbol(sym.DOS, yychar,yyline,"DO'");}
"RE'" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext(); comp="PALABRA_RESERVADA";return new Symbol(sym.RES, yychar,yyline,"RE'");}
"MI'" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext(); comp="PALABRA_RESERVADA";return new Symbol(sym.MIS, yychar,yyline,"MI'");}
"FA'" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext(); comp="PALABRA_RESERVADA";return new Symbol(sym.FAS, yychar,yyline,"FA'");}
"SOL'" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext(); comp="PALABRA_RESERVADA";return new Symbol(sym.SOLS, yychar,yyline,"SOL'");}
"LA'" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext(); comp="PALABRA_RESERVADA";return new Symbol(sym.LAS, yychar,yyline,"LA'");}
"SI'" {pintar.pintaAzul(yychar,yylength()); lexeme=yytext(); comp="PALABRA_RESERVADA";return new Symbol(sym.SIS, yychar,yyline,"SI'");}
*/


\"{CommentContents}\" {pintar.pintaNara(yychar,yylength());lexeme=yytext(); return new Symbol(sym.CADENA, yychar,yyline,yytext());}
[0-9][0-9]* {lexeme=yytext();comp="numEntero"; return new Symbol(sym.numEntero, yychar,yyline,yytext());}
{L}({L}|{D})* {lexeme=yytext();comp="ID"; return new Symbol(sym.ID, yychar,yyline,yytext());}
{D}({L}|{D})* {lexeme=yytext();comp="idNoVal"; return new Symbol(sym.idNoVal, yychar,yyline,yytext());}

({L}|{D}|{Novalidos})* { try { lexeme=yytext(); comp="ERROR"; return new Symbol(sym.ERROR, yychar,yyline,yytext()); } catch(Exception e) { lexeme=yytext(); comp="idNoVal"; return new Symbol(sym.idNoVal, yychar,yyline,yytext()); } }
({L}|{D}|{Novalidos})*"."({L}|{D}|{Novalidos})* { try { lexeme=yytext(); comp="ERROR"; return new Symbol(sym.ERROR, yychar,yyline,yytext()); } catch(Exception e) { lexeme=yytext(); comp="idNoVal"; return new Symbol(sym.idNoVal, yychar,yyline,yytext()); } }


. { try { lexeme=yytext(); comp="ERROR"; return new Symbol(sym.ERROR, yychar,yyline); } catch(Exception e) { lexeme=yytext(); comp="idNoVal"; return new Symbol(sym.idNoVal, yychar,yyline ,yytext()); } }



