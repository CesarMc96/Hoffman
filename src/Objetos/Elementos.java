package Objetos;

public class Elementos implements Comparable<Elementos> {

    private char caracter;
    private int numero;

    public Elementos() {
    }

    public Elementos(char caracter) {
        this.caracter = caracter;
    }

    public Elementos(int numero) {
        this.numero = numero;
    }

    public Elementos(char caracter, int numero) {
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
        return caracter + ":" + numero;
    }

    @Override
    public int compareTo(Elementos t) {
        return this.numero - t.getNumero();
    }

}
