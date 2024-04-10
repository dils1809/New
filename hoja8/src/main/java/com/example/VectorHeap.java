package com.example;

import java.util.Vector;

/**
 * Implementación de la cola de prioridad usando un montículo (heap) binario.
 * Los elementos son organizados en un Vector de tal manera que se mantiene
 * la propiedad de montículo, permitiendo operaciones eficientes de inserción
 * y eliminación con prioridad.
 *
 * @param <E> el tipo de elementos almacenados en esta cola de prioridad. Debe ser comparable.
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    private Vector<E> data; // Almacenamiento interno de los elementos del montículo.

    /**
     * Constructor que inicializa el montículo (heap) vacío.
     */
    public VectorHeap() {
        data = new Vector<E>();
    }

    /**
     * Calcula el índice del padre de un nodo.
     *
     * @param i índice del nodo.
     * @return índice del padre del nodo.
     */
    protected int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * Calcula el índice del hijo izquierdo de un nodo.
     *
     * @param i índice del nodo.
     * @return índice del hijo izquierdo del nodo.
     */
    protected int left(int i) {
        return 2 * i + 1;
    }

    /**
     * Calcula el índice del hijo derecho de un nodo.
     *
     * @param i índice del nodo.
     * @return índice del hijo derecho del nodo.
     */
    protected int right(int i) {
        return (2 * i) + 2;
    }

    /**
     * Percola un elemento hacia arriba para mantener la propiedad del montículo.
     *
     * @param leaf índice del nodo a percolar hacia arriba.
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
     * @param value el elemento a añadir.
     */
    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    /**
     * Percola un elemento hacia abajo para mantener la propiedad del montículo.
     *
     * @param root índice del nodo a percolar hacia abajo.
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
     * Remueve y retorna el elemento con mayor prioridad de la cola.
     *
     * @return el elemento con mayor prioridad.
     */
    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }
        E minVal = data.get(0);
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }

    /**
     * Retorna, sin remover, el elemento con mayor prioridad de la cola.
     *
     * @return el elemento con mayor prioridad.
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return data.get(0);
    }

    /**
     * Comprueba si la cola de prioridad está vacía.
     *
     * @return true si la cola está vacía, false en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Retorna el número de elementos en la cola de prioridad.
     *
     * @return el número de elementos en la cola.
     */
    @Override
    public int size() {
        return data.size();
    }
}
