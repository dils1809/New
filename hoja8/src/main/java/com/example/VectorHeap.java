package com.example;
import java.util.Vector;

/**
 * Una implementación de cola de prioridad basada en un montículo (heap),
 * donde los elementos son ordenados según su orden natural o por un Comparator
 * proporcionado en el momento de la construcción de la cola.
 *
 * @param <E> El tipo de elementos que la cola de prioridad mantendrá.
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    private Vector<E> data; // El contenedor interno para almacenar los elementos del heap.

    /**
     * Constructor que inicializa el VectorHeap sin elementos.
     */
    public VectorHeap() {
        data = new Vector<E>();
    }

    /**
     * Calcula el índice del padre del nodo en la posición dada.
     *
     * @param i El índice del nodo.
     * @return El índice del padre del nodo.
     */
    protected int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * Calcula el índice del hijo izquierdo del nodo en la posición dada.
     *
     * @param i El índice del nodo.
     * @return El índice del hijo izquierdo del nodo.
     */
    protected int left(int i) {
        return 2 * i + 1;
    }

    /**
     * Calcula el índice del hijo derecho del nodo en la posición dada.
     *
     * @param i El índice del nodo.
     * @return El índice del hijo derecho del nodo.
     */
    protected int right(int i) {
        return (2 * i) + 2;
    }

    /**
     * Realiza el proceso de percolación hacia arriba para mantener las propiedades del heap.
     *
     * @param leaf Índice del nodo que se percolará hacia arriba.
     */
    protected void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 && (value.compareTo(data.get(parent)) < 0)) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }

    /**
     * Añade un nuevo elemento a la cola de prioridad.
     *
     * @param value El elemento a añadir.
     */
    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    /**
     * Realiza el proceso de percolación hacia abajo para mantener las propiedades del heap.
     *
     * @param root Índice del nodo raíz que se percolará hacia abajo.
     */
    protected void pushDownRoot(int root) {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if ((right(root) < heapSize) && ((data.get(childpos + 1)).compareTo(data.get(childpos)) < 0)) {
                    childpos++;
                }
                if ((data.get(childpos)).compareTo(value) < 0) {
                    data.set(root, data.get(childpos));
                    root = childpos;
                } else {
                    data.set(root, value);
                    return;
                }
            } else {
                data.set(root, value);
                return;
            }
        }
    }

    /**
     * Remueve y retorna el elemento con mayor prioridad en la cola.
     *
     * @return El elemento con mayor prioridad.
     */
    @Override
    public E remove() {
        if (isEmpty()) {
            return null; // O lanzar una excepción, dependiendo de cómo desees manejar este caso.
        }
        E minVal = data.get(0);
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }

    /**
     * Obtiene, sin remover, el elemento con mayor prioridad en la cola.
     *
     * @return El elemento con mayor prioridad, o null si la cola está vacía.
     */
    @Override
    public E peek() {
        if (isEmpty()) {

