package servicios;

import modelo.Empleado;
import java.util.ArrayList;
//Clase para el pago final
public class Planilla {

    public ArrayList<Empleado> pago(ArrayList<Empleado> empleados) {
        for (Empleado e : empleados) {
            e.setSalarioXquincena(e.salarioQuicena());
            double salario = e.salarioQuicena();
            double bono = e.bono();
            double total = salario + bono;

            System.out.println(e.getNombre() +
                    " Salario base: " + salario +
                    " | Bono: " + bono +
                    " | Pago final: " + total);
        }
        return empleados;
    }
}

