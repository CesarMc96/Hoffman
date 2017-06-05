package Objetos;

public class ListaDoble<T extends Comparable<T>> {

    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int tamano;

    public ListaDoble() {
        tamano = 0;
    }

    public void pop() {
        if (inicio != null) {
            if (inicio.getSiguiente() == null) {
                inicio = null;
            } else {
                Nodo<T> aux = inicio.getSiguiente();
                aux.setAnterior(null);
                inicio = null;
                inicio = aux;
            }
            tamano--;
        }
    }

    public void insertarAtras(T t) {
        Nodo<T> n = new Nodo(t);
        if (inicio == null) {
            inicio = n;
        } else {
            Nodo<T> aux = inicio;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(n);
            n.setAnterior(aux);
        }
        fin = n;
        tamano++;
    }

    public void insertarAdelante(T t) {
        Nodo<T> n = new Nodo(t);
        if (inicio == null) {
            inicio = n;
            fin = n;
        } else {
            inicio.setAnterior(n);
            n.setSiguiente(inicio);
            inicio = n;
        }
        tamano++;
    }

    public void insertarOrdenado(T t) {
        Nodo<T> n = new Nodo(t);
        if (inicio == null) {
            inicio = n;
            fin = n;
            tamano++;
        } else {
            Nodo<T> ant = null;
            Nodo<T> aux = inicio;
            while (aux != null && aux.getElemento().compareTo(t) < 0) {
                ant = aux;
                aux = aux.getSiguiente();
            }
            if (ant == null) {
                insertarAdelante(t);
            } else {
                if (aux != null) {
                    aux.setAnterior(n);
                    n.setSiguiente(aux);
                } else {
                    fin = n;
                }
                ant.setSiguiente(n);
                n.setAnterior(ant);
                tamano++;
            }
        }
    }

    public void recorrer() {
        Nodo<T> aux = inicio;
        while (aux != null) {
            System.out.print(aux.getElemento());
            aux = aux.getSiguiente();
        }
        System.out.println("");
    }

    @Override
    public String toString() {
        String s = new String();
        Nodo<T> aux = inicio;
        while (aux != null) {
            s += aux.getElemento() + " ";
            aux = aux.getSiguiente();
        }
        return s;
    }

    public Nodo<T> getInicio() {
        return inicio;
    }

    public Nodo<T> getFin() {
        return fin;
    }

    public int getTamano() {
        return tamano;
    }

}
