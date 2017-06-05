package Objetos;

import java.io.Serializable;

public class Hoja<T extends Comparable<T>> implements Comparable<Hoja>, Serializable {

    private T elemento;
    private Hoja izquierda;
    private Hoja derecha;

    public Hoja() {
    }

    public Hoja(T elemento) {
        this.elemento = elemento;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public Hoja getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Hoja izquierda) {
        this.izquierda = izquierda;
    }

    public Hoja getDerecha() {
        return derecha;
    }

    public void setDerecha(Hoja derecha) {
        this.derecha = derecha;
    }

    @Override
    public String toString() {
        return "Nodo{" + "elemento=" + elemento + ", izquierda=" + (izquierda != null)
                + ", derecha=" + (derecha != null) + '}';
    }

    @Override
    public int compareTo(Hoja t) {
        return this.elemento.compareTo((T) t.getElemento());
    }

}
