package Test;

import modelo.Practicante;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PracticanteTest {

    @Test
    public void testCreacionYGetters() {
        Practicante p = new Practicante("506780123", "Maria Lopez", 1200.0);

        assertEquals("506780123", p.getCedula(), "La cedula no coincide");
        assertEquals("Maria Lopez", p.getNombre(), "El nombre no coincide");
        assertEquals(1200.0, p.getApoyoQuincena(), 0.001,
                "El apoyo quincenal no coincide");
    }

    @Test
    public void testSetters() {
        Practicante p = new Practicante("506780123", "Maria Lopez", 1200.0);

        p.setCedula("707890456");
        p.setNombre("Juan Perez");
        p.setApoyoQuincena(1500.0);

        assertEquals("707890456", p.getCedula(), "La cedula no se actualizo correctamente");
        assertEquals("Juan Perez", p.getNombre(), "El nombre no se actualizo correctamente");
        assertEquals(1500.0, p.getApoyoQuincena(), 0.001,
                "El apoyo quincenal no se actualizó correctamente");
    }

    @Test
    public void testToCSV() {
        Practicante p = new Practicante("506780123", "Maria Lopez", 1200.0);

        String expected = "PRACTICANTE;506780123;Maria Lopez;1200.0";
        assertEquals(expected, p.toCSV(),
                "El formato CSV no coincide con el esperado");
    }
}
