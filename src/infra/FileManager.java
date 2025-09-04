package infra;

import java.io.File;
import modelo.Empleado;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import modelo.Practicante;

public class FileManager {

    private String route = "data/empleados.csv";

    private Integer fileStatus;
    
    public FileManager() {
        File folder = new File("data");
        if (!folder.exists()) {
            folder.mkdirs(); 
            System.out.println("Carpeta 'data' creada.");
        }
    }

    public void guardarEmpleado(Empleado emp) {
        try (FileWriter writer = new FileWriter(route, true)) {
            writer.write(emp.toCSV() + "\n");
            System.out.println("Empleado guardado en CSV: " + emp.getNombre());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void guardarPracticante(Practicante prc) {
        try (FileWriter writer = new FileWriter(route, true)) {
            writer.write(prc.toCSV() + "\n");
            System.out.println("Empleado guardado en CSV: " + prc.getNombre());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Empleado> getEmpleados() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void guardarPlanilla(ArrayList<Empleado> empleados) {
        try (FileWriter writer = new FileWriter(route)) {
            for (Empleado emp : empleados) {
                writer.write(emp.toCSV() + "\n");
            }
            System.out.println("Planilla guardada correctamente en " + route);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
