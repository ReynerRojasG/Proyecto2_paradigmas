package Test;

import modelo.PorHora;
import modelo.IncentivoProductividad;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PorHoraTest {

    @Test
    public void testSalarioQuincena() {
        PorHora empleado = new PorHora("123", "Ana", new IncentivoProductividad(), 2, 2000.0, 40.0);

        double salarioEsperado = 2000.0 * 40.0; 
        assertEquals(salarioEsperado, empleado.salarioQuicena(), 
                "El salario quincenal no coincide con la tarifa * horas");
    }

    @Test
    public void testToCSV() {
        PorHora empleado = new PorHora("456", "Luis", new IncentivoProductividad(), 1, 1500.0, 30.0);

        String esperado = "PORHORA;456;Luis;1500.0;30.0";
        assertEquals(esperado, empleado.toCSV(), "El formato CSV no coincide");
    }

    @Test
    public void testSettersAndGetters() {
        PorHora empleado = new PorHora("789", "Maria", new IncentivoProductividad(), 3, 1000.0, 20.0);

        empleado.setTarifaHora(2500.0);
        empleado.setHorasQuincena(50.0);

        assertEquals(2500.0, empleado.getTarifaHora(), "La tarifa por hora no se actualizó correctamente");
        assertEquals(50.0, empleado.getHorasQuincena(), "Las horas quincenales no se actualizaron correctamente");
    }
}
