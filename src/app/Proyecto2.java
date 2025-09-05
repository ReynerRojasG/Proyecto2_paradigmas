package app;
import infra.FileManager;
import java.util.ArrayList;
import modelo.*;
import servicios.Planilla;

/**
 *
 * @author Reyner
 */
public class Proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empleado as1 = new Asalariado("604880338", "Makin Artavia", 200000.0, new IncentivoAntiguedad(), 10);
        Empleado cm1 = new Comisionista("6048454338", "Reyner Rojas",new IncentivoDesempeno(),5,40000,0.5,25);
        Empleado ph1 = new PorHora("604885538", "Cipriano Rivera", new IncentivoProductividad(), 4, 2000,100);
        Empleado tmp1 = new Temporal("6040232338", "Machita DeCipri", new IncentivoAntiguedad(), 15,2000,12);
        Practicante pr1 = new Practicante("6023230338", "Annet Gutierrez", 0.0);

        FileManager fm = new FileManager();
        
        fm.guardarEmpleado(as1);
        fm.guardarEmpleado(cm1);
        fm.guardarEmpleado(ph1);
        fm.guardarEmpleado(tmp1);
        fm.guardarPracticante(pr1);
        
        ArrayList<Empleado> empleados = fm.getEmpleados();
        Planilla planilla = new Planilla();
        planilla.pago(empleados);
        fm.guardarPlanilla(empleados);
    }   
}
