/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis_Lexico.Arbol;

/**
 *
 * @author Toloza XD
 */
public class Nodo {
    private String dato;
    private int peso;
    private Nodo izq,der;

    public Nodo(String dato, Nodo izq, Nodo der,int peso) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
        this.peso = peso;
    }

    public String getDato() {
        return dato;
    }
    
    public int getPeso(){
        return peso;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }
 
}
