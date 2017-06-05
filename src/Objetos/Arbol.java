package Objetos;

import java.util.ArrayList;

public class Arbol<T extends Comparable<T>> implements Comparable<Arbol> {

    private Hoja<T> raiz;
    private String diccionario;

    public Arbol() {
        this.raiz = null;
    }

    public Hoja<T> getRaiz() {
        return raiz;
    }

    public void insertar(T elemento) {
        Nodo<T> nuevo = new Nodo(elemento);
        if (raiz == null) {
            raiz = ((Arbol) elemento).getRaiz();
        } else {
            int suma = ((Dato) this.raiz.getElemento()).getNumero() + ((Dato) ((Arbol) elemento).getRaiz().getElemento()).getNumero();
            Hoja<T> nuevaRaiz = new Hoja(new Dato(suma));
            nuevaRaiz.setIzquierda(raiz);
            nuevaRaiz.setDerecha(((Arbol) elemento).getRaiz());
            raiz = nuevaRaiz;
        }
    }

    public void agregar(T coso) {
        Hoja<T> h = new Hoja(coso);
        if (raiz == null) {
            raiz = h;
        } else {
            Hoja<T> aux = raiz;
            boolean f = false;
            while (!f) {
                if (raiz.getElemento().compareTo(coso) >= 0) {
                    if (aux.getIzquierda() != null) {
                        aux = aux.getIzquierda();
                    } else {
                        aux.setIzquierda(h);
                        f = true;
                    }
                } else if (aux.getDerecha() != null) {
                    aux = aux.getDerecha();
                } else {
                    aux.setDerecha(h);
                    f = true;
                }
            }
        }
    }

    private void generarDiccionario(Hoja<T> t, String camino) {
        if (t != null) {
            if (t.getIzquierda() == null && t.getDerecha() == null) {
//                System.out.println("letra: "+((Dato)t.getDato()).getCaracter()+" Camino: "+camino);
                char c = ((Dato) t.getElemento()).getCaracter();
                if (c == '0' || c == '1') {
                    diccionario += "no" + c + camino;
                } else {
                    diccionario += c + camino;
                }
            } else {
                generarDiccionario(t.getIzquierda(), camino + 0);
                generarDiccionario(t.getDerecha(), camino + 1);
            }
        }
    }

    public String generarDiccionario() {
        ArrayList<String> camino = new ArrayList();
        diccionario = new String();
        generarDiccionario(this.raiz, new String());
        return diccionario;
    }

    private void imprime(Hoja<T> t) {
        if (t != null) {
            if (t.getIzquierda() == null && t.getDerecha() == null) {
                System.out.println(t);
            } else {
                imprime(t.getIzquierda());
                System.out.println(t);
                imprime(t.getDerecha());
            }
        }
    }

    public void imprime() {
        imprime(this.raiz);
    }

    @Override
    public String toString() {
        return raiz.getElemento().toString();
    }

    @Override
    public int compareTo(Arbol t) {
        return this.raiz.compareTo(t.getRaiz());
    }
    
    private boolean estaVacio(){
        return raiz == null;
    }
}
