package servicios;


import modelo.Empleado;
import java.util.ArrayList;

public class Planilla {
    private ArrayList<Empleado> empleados;
    
    public Planilla(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }
    
    public void calcularPagos() {
        for (Empleado emp : empleados) {
            double salario = emp.salarioQuicena();
            double bono = emp.bono();
            double pagoFinal = emp.pagoFinal();

            System.out.println(emp.getNombre() + 
                " Salario base: " + salario +
                " | Bono: " + bono +
                " | Pago final: " + pagoFinal);
        }
    }
    /*
    private double bono;

    public ArrayList<Empleado> pago(ArrayList<Empleado> empleados) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    */
}
