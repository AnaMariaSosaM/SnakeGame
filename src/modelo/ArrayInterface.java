/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public interface ArrayInterface<E> {
    public void add(E nuevo);
    public E remove();
    public boolean isEmpty();
}