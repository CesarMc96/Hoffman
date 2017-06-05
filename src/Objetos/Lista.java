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
public class Lista<T extends Comparable<T>> {
    
    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int size;
    
    public Lista() {
        size = 0;
    }
    
    public void pop() {
        if(inicio != null) {
            if(inicio.getSiguiente() == null) {
                inicio = null;
            } else {
                Nodo<T> aux = inicio.getSiguiente();
                aux.setAnterior(null);
                inicio = null;
                inicio = aux;
            }    
            size--;
        }
    }
    
    public void agregarAtras(T t) {
        Nodo<T> n = new Nodo(t);              
        if(inicio == null) 
            inicio = n;
        else {
            Nodo<T> aux = inicio;  
            while(aux.getSiguiente()!=null){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(n);
            n.setAnterior(aux);
        }
        fin = n;
        size++;
    }
    
    public void agregarAdelante(T t) {
        Nodo<T> n = new Nodo(t);
        if(inicio == null) {
            inicio = n;
            fin = n;
        } else {
            inicio.setAnterior(n);
            n.setSiguiente(inicio);
            inicio = n;
        }
        size++;
    }
    
    public void agregarOrdenado(T t) {
        Nodo<T> n = new Nodo(t);
        if (inicio == null) {
            inicio = n;
            fin = n;
            size++;
        } else {
            Nodo<T> ant = null;
            Nodo<T> aux = inicio;
            while(aux != null && aux.getDato().compareTo(t)<0) {
                ant = aux;
                aux = aux.getSiguiente();                
            }
            if(ant == null) {
                agregarAdelante(t);
            }else {
                if(aux != null) {
                    aux.setAnterior(n);
                    n.setSiguiente(aux);                    
                } else
                    fin = n;
                ant.setSiguiente(n);
                n.setAnterior(ant);
                size++;
            }
        }                
    }    
    
    public String imprimirDes() {
        String s = new String();
        Nodo<T> aux = fin;
        while(aux != null) {
            s += aux.getDato() + " ";
            aux = aux.getAnterior();
        }
        return s;
    }

    @Override
    public String toString() {
        String s = new String();
        Nodo<T> aux = inicio;
        while(aux != null) {
            s += aux.getDato() + " ";
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

    public int getSize() {
        return size;
    }    

}
