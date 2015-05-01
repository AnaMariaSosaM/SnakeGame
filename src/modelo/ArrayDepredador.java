/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author AnaSosa
 */
public class ArrayDepredador<E> implements ArrayInterface<E>{

    private E[] cuadros;
    
    public ArrayDepredador(){
        this.cuadros = (E[]) (new Object[0]);
    }
    
    public int size(){
        return this.cuadros.length;
    }
    
    @Override
    public void add(E nuevo) {
        E[] aux = (E[]) (new Object[size() + 1]);
        
        System.arraycopy(cuadros, 0, aux, 0, size());
        
        aux[size()] = nuevo;
        cuadros = aux;
        
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        if (cuadros.length > 0) {
            return false;
        }
        
        return true;
    }
    
    public void move(E nuevo){
        
        E[] aux = (E[]) (new Object[cuadros.length]);
        
        for (int i = 0; i < cuadros.length -1; i++) {
            aux[i] = cuadros[i + 1];
        }
        
        aux[aux.length -1] = nuevo;
        
        cuadros = aux;
    }
    
    public E get(int i){
        if(i >= cuadros.length)
            throw new IndexOutOfBoundsException();
        return cuadros[i];
    }
}