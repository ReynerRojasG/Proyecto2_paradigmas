package Test;


import modelo.Comisionista;
import modelo.IncentivoAntiguedad;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author Reyner
 */
public class ComisionistaTest {
    
    @Test
    public void testSalarioQuincenal() {
        Comisionista emp = new Comisionista("305670123", "Carlos Ruiz",
                new IncentivoAntiguedad(), 5,
                500.0, 0.10, 1000.0);
        
        double expected = 500.0 + (0.10 / 1000.0);

        assertEquals(expected, emp.salarioQuicena(), 0.0001,
                "El salario quincenal no coincide con la fórmula de la clase actual");
    }

    @Test
    public void testBono() {
        Comisionista emp = new Comisionista("305670123", "Carlos Ruiz",
                new IncentivoAntiguedad(), 5,
                500.0, 0.10, 1000.0);

        double expectedBono = 100 * emp.getAniosServicio();

        assertEquals(expectedBono, emp.bono(), 0.01,
                "El bono por antigüedad no coincide");
    }

    @Test
    public void testNombreYCedula() {
        Comisionista emp = new Comisionista("305670123", "Carlos Ruiz",
                new IncentivoAntiguedad(), 5,
                500.0, 0.10, 1000.0);

        assertEquals("Carlos Ruiz", emp.getNombre(), "El nombre no coincide");
        assertEquals("305670123", emp.getCedula(), "La cédula no coincide");
    }

}
