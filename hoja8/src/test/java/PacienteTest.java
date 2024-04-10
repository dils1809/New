import com.example.Paciente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    @Test
    void testCompareTo() {
        Paciente paciente1 = new Paciente("Juan", "Dolor de cabeza", 'B');
        Paciente paciente2 = new Paciente("Maria", "Apendicitis", 'A');
        assertTrue(paciente1.compareTo(paciente2) > 0);
        assertTrue(paciente2.compareTo(paciente1) < 0);
    }

    @Test
    void testToString() {
        Paciente paciente = new Paciente("Juan", "Dolor de cabeza", 'B');
        assertEquals("Juan, Dolor de cabeza, B", paciente.toString());
    }

    @Test
    void testGetNombre() {
        Paciente paciente = new Paciente("Juan", "Dolor de cabeza", 'B');
        assertEquals("Juan", paciente.getNombre());
    }

    @Test
    void testGetSintoma() {
        Paciente paciente = new Paciente("Juan", "Dolor de cabeza", 'B');
        assertEquals("Dolor de cabeza", paciente.getSintoma());
    }

    @Test
    void testGetCodigoEmergencia() {
        Paciente paciente = new Paciente("Juan", "Dolor de cabeza", 'B');
        assertEquals('B', paciente.getCodigoEmergencia());
    }
}

