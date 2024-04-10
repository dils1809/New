
import com.example.Paciente;
import com.example.VectorHeap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VectorHeapTest {

    private VectorHeap<Paciente> heap;

    @BeforeEach
    void setUp() {
        heap = new VectorHeap<>();
    }

    @Test
    void testAddAndRemovePatients() {
        Paciente paciente1 = new Paciente("Juan", "Dolor de cabeza", 'C');
        Paciente paciente2 = new Paciente("Maria", "Apendicitis", 'A');
        Paciente paciente3 = new Paciente("Pedro", "Fractura de brazo", 'B');

        // Añadir pacientes al heap
        heap.add(paciente1);
        heap.add(paciente2);
        heap.add(paciente3);

        // El primer paciente a remover debe ser Maria por su alta prioridad (A)
        assertEquals(paciente2, heap.remove(), "Maria debería ser atendida primero");
        // Luego sigue Pedro con prioridad B
        assertEquals(paciente3, heap.remove(), "Pedro debería seguir");
        // Finalmente, Juan es atendido
        assertEquals(paciente1, heap.remove(), "Juan debería ser el último en ser atendido");

        assertTrue(heap.isEmpty(), "El heap debería estar vacío después de atender a todos los pacientes");
    }

    @Test
    void testPeek() {
        Paciente paciente1 = new Paciente("Juan", "Dolor de cabeza", 'C');
        heap.add(paciente1);
        // Verificar que peek retorna el elemento correcto sin removerlo
        assertEquals(paciente1, heap.peek(), "Peek debería mostrar a Juan sin removerlo del heap");
        assertFalse(heap.isEmpty(), "El heap no debería estar vacío después de peek");
    }
}


