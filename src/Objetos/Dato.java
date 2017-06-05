/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author j4v13
 */
public class Dato implements Comparable<Dato> {
    
    private char caracter;
    private int numero;

    public Dato() {
    }

    public Dato(char caracter) {
        this.caracter = caracter;
    }

    public Dato(int numero) {
        this.numero = numero;
    }        

    public Dato(char caracter, int numero) {
        this.caracter = caracter;
        this.numero = numero;
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return caracter+ ":" + numero;
    }

    @Override
    public int compareTo(Dato t) {
        return this.numero - t.getNumero();
    }
    
}
