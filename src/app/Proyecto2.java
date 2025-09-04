package app;
import modelo.*;

/**
 *
 * @author Reyner
 */
public class Proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Incentivo incentivoProd = new IncentivoProductividad(5000.0);
         
         Asalariado empleado1= new Asalariado("123456", "Juan Perez", 250000.0, incentivoProd);
         System.out.println("Salario quincenal inicial: " + empleado1.salarioQuicena());
         incentivoProd.calcularBono(empleado1);
    }
    
}
