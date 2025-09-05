package com.mycompany.infra;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import modelo.Empleado;
import modelo.Practicante;
import modelo.Asalariado;
import modelo.Comisionista;
import modelo.PorHora;
import modelo.Temporal;
import modelo.IncentivoAntiguedad;
import modelo.IncentivoDesempeno;
import modelo.IncentivoProductividad;
import modelo.Bonificable;

public class FileManager {

    private final String route = "data/empleados.csv";
    private Integer fileStatus;

    //Crear la carpeta data
    public FileManager() {
        File folder = new File("data");
        if (!folder.exists()) {
            folder.mkdirs();
            System.out.println("Carpeta 'data' creada.");
        }
    }

    // Verifica si ya existe un empleado en el archivo por su cedula
    private boolean existeCedulaEnArchivo(String cedula) {
        File file = new File(route);
        if (!file.exists()) {
            return false;
        }

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.isBlank()) {
                    continue;
                }
                String[] cols = linea.split(";", -1);
                if (cols.length < 2) {
                    continue;
                }
                String ced = cols[1].trim();
                if (ced.equals(cedula)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Verificar si un empleado existe
    public boolean existeEmpleado(String cedula) {
        return existeCedulaEnArchivo(cedula);
    }

    // Asegura que la carpeta out exista para exportar archivos
    private static void ensureOutFolder() {
        File out = new File("out");
        if (!out.exists()) {
            out.mkdirs();
        }
    }

    // Guarda un empleado en el CSV
    public void guardarEmpleado(Empleado emp) {
        try {
            if (existeCedulaEnArchivo(emp.getCedula())) {
                System.out.println("El empleado con cedula " + emp.getCedula() + " ya existe.");
                return;
            }
            try (FileWriter writer = new FileWriter(route, true)) {
                writer.write(emp.toCSV());
                writer.write(System.lineSeparator());
            }
            System.out.println("Empleado guardado en CSV: " + emp.getNombre());
            fileStatus = 0;
        } catch (IOException e) {
            fileStatus = 1;
            e.printStackTrace();
        }
    }

    // Guarda un practicantes en el CSV
    public void guardarPracticante(Practicante prc) {
        try {
            if (existeCedulaEnArchivo(prc.getCedula())) {
                System.out.println("El empleado con cedula " + prc.getCedula() + " ya existe.");
                return;
            }
            try (FileWriter writer = new FileWriter(route, true)) {
                writer.write(prc.toCSV());
                writer.write(System.lineSeparator());
            }
            System.out.println("Empleado guardado en CSV: " + prc.getNombre());
            fileStatus = 0;
        } catch (IOException e) {
            fileStatus = 1;
            e.printStackTrace();
        }
    }

    // Lee todos los empleados del archivo CSV y los devuelve en una lista
    public ArrayList<Empleado> getEmpleados() {
        ArrayList<Empleado> empleados = new ArrayList<>();
        File file = new File(route);
        if (!file.exists()) {
            return empleados;
        }

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.isBlank()) {
                    continue;
                }
                String[] p = linea.split(";", -1);
                String tipo = p[0].trim().toUpperCase();

                try {
                    switch (tipo) {
                        case "ASALARIADO": {
                            String cedula = p[1].trim();
                            String nombre = p[2].trim();
                            double salarioMensual = Double.parseDouble(p[3].trim());
                            int aniosServicio = Integer.parseInt(p[5].trim());
                            empleados.add(new Asalariado(cedula, nombre, salarioMensual,
                                    new IncentivoAntiguedad(), aniosServicio));
                            break;
                        }
                        case "PORHORA": {
                            String cedula = p[1].trim();
                            String nombre = p[2].trim();
                            double tarifaHora = Double.parseDouble(p[3].trim());
                            int horasQuincena = (int) Math.round(Double.parseDouble(p[4].trim()));
                            empleados.add(new PorHora(cedula, nombre, new IncentivoProductividad(),
                                    0, tarifaHora, horasQuincena));
                            break;
                        }
                        case "TEMPORAL": {
                            String cedula = p[1].trim();
                            String nombre = p[2].trim();
                            double tarifaDiaria = Double.parseDouble(p[3].trim());
                            int diasActivos = Integer.parseInt(p[4].trim());
                            int aniosServicio = Integer.parseInt(p[5].trim());
                            empleados.add(new Temporal(cedula, nombre, new IncentivoAntiguedad(),
                                    aniosServicio, tarifaDiaria, diasActivos));
                            break;
                        }
                        case "COMISIONISTA": {
                            String cedula = p[1].trim();
                            String nombre = p[2].trim();
                            double base = Double.parseDouble(p[3].trim());
                            double porcentaje = Double.parseDouble(p[4].trim());
                            double ventas = Double.parseDouble(p[5].trim());
                            empleados.add(new Comisionista(cedula, nombre, new IncentivoDesempeno(),
                                    0, base, porcentaje, ventas));
                            break;
                        }
                        case "PRACTICANTE":
                            //Falto
                            break;
                        default:
                            System.out.println("Linea no reconocida (tipo): " + linea);
                    }
                } catch (Exception parseEx) {
                    System.out.println("Error procesando linea: " + linea);
                }
            }
            fileStatus = 0;
        } catch (IOException e) {
            fileStatus = 1;
            e.printStackTrace();
        }
        return empleados;
    }

    // Guarda la planilla de pagos de todos los empleados en un CSV
    public ArrayList<String> guardarPlanilla(ArrayList<Empleado> empleados) {
        ensureOutFolder();
        String salida = "out/planilla_quincena.csv";
        ArrayList<String> lineas = new ArrayList<>();

        try (FileWriter writer = new FileWriter(salida, false)) {
            // encabezado
            String encabezado = "cedula;nombre;tipo;salarioQuincena;bono;totalAPagar";
            writer.write(encabezado + "\n");
            lineas.add(encabezado);

            // filas de empleados
            for (Empleado e : empleados) {
                double base = e.salarioQuicena();
                double bono = 0.0;
                if (e instanceof Bonificable) {
                    bono = ((Bonificable) e).bono();
                }
                double total = base + bono;

                String fila = e.getCedula() + ";"
                        + e.getNombre() + ";"
                        + e.getClass().getSimpleName().toUpperCase() + ";"
                        + String.format("%.2f", base) + ";"
                        + String.format("%.2f", bono) + ";"
                        + String.format("%.2f", total);

                writer.write(fila + "\n");
                lineas.add(fila);
            }

            System.out.println("Planilla guardada en " + salida);
            fileStatus = 0;
        } catch (IOException e) {
            fileStatus = 1;
            e.printStackTrace();
        }

        return lineas;
    }

    public Integer getFileStatus() {
        return fileStatus;
    }
}
