package Test;

import modelo.Asalariado;
import modelo.IncentivoAntiguedad;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AsalariadoTest {

    @Test
    public void testSalarioQuincenal() {
        Asalariado emp = new Asalariado("604880338", "Makin Artavia", 200000.0, new IncentivoAntiguedad(), 10);
        
        double expected = 100000.0;

        assertEquals(expected, emp.salarioQuicena(), 0.01, "El salario quincenal no coincide");
    }

    @Test
    public void testBono() {
        Asalariado emp = new Asalariado("604880338", "Makin Artavia", 200000.0, new IncentivoAntiguedad(), 10);
        double expectedBono = 100 * emp.getAniosServicio();

        assertEquals(expectedBono, emp.bono(), 0.01, "El bono por antigüedad no coincide");
    }

    @Test
    public void testNombreYCedula() {
        Asalariado emp = new Asalariado("604880338", "Makin Artavia", 200000.0, new IncentivoAntiguedad(), 10);

        assertEquals("Makin Artavia", emp.getNombre(), "El nombre no coincide");
        assertEquals("604880338", emp.getCedula(), "La cédula no coincide");
    }
}
