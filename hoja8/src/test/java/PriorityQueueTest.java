import com.example.PriorityQueue;
import com.example.VectorHeap;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    private PriorityQueue<Integer> priorityQueue;

    @BeforeEach
    void setUp() {
        // Aquí asumimos que VectorHeap es tu implementación de PriorityQueue
        priorityQueue = new VectorHeap<>();
    }

    @Test
    void testAddAndPeek() {
        assertTrue(priorityQueue.isEmpty(), "La cola de prioridad debe estar vacía inicialmente.");

        priorityQueue.add(10);
        assertEquals(10, priorityQueue.peek(), "Peek debe retornar el primer elemento añadido.");

        priorityQueue.add(5);
        assertEquals(5, priorityQueue.peek(), "Peek debe retornar el elemento con mayor prioridad.");

        priorityQueue.add(15);
        assertEquals(5, priorityQueue.peek(), "Peek debe aún retornar el elemento con mayor prioridad después de añadir uno mayor.");
    }

    @Test
    void testRemove() {
        priorityQueue.add(10);
        priorityQueue.add(5);
        priorityQueue.add(15);

        assertEquals(5, priorityQueue.remove(), "Remove debe retornar el elemento con mayor prioridad.");
        assertEquals(10, priorityQueue.peek(), "Peek debe retornar el siguiente elemento con mayor prioridad después de un remove.");
        assertFalse(priorityQueue.isEmpty(), "La cola de prioridad no debe estar vacía después de los removes.");

        priorityQueue.remove();
        priorityQueue.remove();
        assertTrue(priorityQueue.isEmpty(), "La cola de prioridad debe estar vacía después de remover todos los elementos.");
    }

    @Test
    void testSize() {
        assertEquals(0, priorityQueue.size(), "El tamaño debe ser 0 inicialmente.");
        priorityQueue.add(10);
        assertEquals(1, priorityQueue.size(), "El tamaño debe ser 1 después de añadir un elemento.");
        priorityQueue.add(20);
        assertEquals(2, priorityQueue.size(), "El tamaño debe ser 2 después de añadir otro elemento.");
        priorityQueue.remove();
        assertEquals(1, priorityQueue.size(), "El tamaño debe decrecer a 1 después de un remove.");
    }
}

