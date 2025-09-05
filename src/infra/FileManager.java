package infra;

import java.io.*;
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

    public FileManager() {
        File folder = new File("data");
        if (!folder.exists()) {
            folder.mkdirs();
            System.out.println("Carpeta 'data' creada.");
        }
    }

    private static String stripBOM(String s) {
        if (s != null && !s.isEmpty() && s.charAt(0) == '\uFEFF') return s.substring(1);
        return s;
    }

    private boolean existeCedulaEnArchivo(String cedula) {
        File file = new File(route);
        if (!file.exists()) return false;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.isBlank()) continue;
                String[] cols = linea.split(";", -1);
                if (cols.length < 2) continue;
                String ced = stripBOM(cols[1]).trim();
                if (ced.equals(cedula)) return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean existeEmpleado(String cedula) {
        return existeCedulaEnArchivo(cedula);
    }

    private static void ensureOutFolder() {
        File out = new File("out");
        if (!out.exists()) out.mkdirs();
    }


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

    public ArrayList<Empleado> getEmpleados() {
        ArrayList<Empleado> empleados = new ArrayList<>();
        File file = new File(route);
        if (!file.exists()) return empleados;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.isBlank()) continue;
                String[] p = linea.split(";", -1);
                String tipo = stripBOM(p[0]).trim().toUpperCase();

                try {
                    switch (tipo) {
                        case "ASALARIADO": {
                            String cedula = p[1].trim();
                            String nombre = p[2].trim();
                            double salarioMensual = Double.parseDouble(p[3].trim());
                            empleados.add(new Asalariado(cedula, nombre, salarioMensual,
                                    new IncentivoAntiguedad(), 0));
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
                            empleados.add(new Temporal(cedula, nombre, new IncentivoAntiguedad(),
                                    2024, tarifaDiaria, diasActivos));
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

    public ArrayList<Practicante> getPracticantes() {
        ArrayList<Practicante> practicantes = new ArrayList<>();
        File file = new File(route);
        if (!file.exists()) return practicantes;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.isBlank()) continue;
                String[] p = linea.split(";", -1);
                String tipo = stripBOM(p[0]).trim().toUpperCase();
                if (!"PRACTICANTE".equals(tipo)) continue;

                try {
                    String cedula = p[1].trim();
                    String nombre = p[2].trim();
                    double apoyo = Double.parseDouble(p[3].trim());
                    practicantes.add(new Practicante(cedula, nombre, apoyo));
                } catch (Exception parseEx) {
                    System.out.println("Error procesando linea (practicante): " + linea);
                }
            }
            fileStatus = 0;
        } catch (IOException e) {
            fileStatus = 1;
            e.printStackTrace();
        }
        return practicantes;
    }

    public void guardarPlanilla(ArrayList<Empleado> empleados) {
        ensureOutFolder();
        String salida = "out/planilla_quincena.csv";

        try (FileWriter writer = new FileWriter(salida, false)) {
            writer.write("cedula;nombre;tipo;salarioQuincena;bono;totalAPagar\n");
            for (Empleado e : empleados) {
                double base = e.salarioQuicena(); 
                double bono = (e instanceof Bonificable b) ? b.bono() : 0.0;
                double total = base + bono;
                writer.write(e.getCedula() + ";" +
                             e.getNombre() + ";" +
                             e.getClass().getSimpleName().toUpperCase() + ";" +
                             String.format("%.2f", base) + ";" +
                             String.format("%.2f", bono) + ";" +
                             String.format("%.2f", total) + "\n");
            }
            System.out.println("Planilla guardada en " + salida);
            fileStatus = 0;
        } catch (IOException e) {
            fileStatus = 1;
            e.printStackTrace();
        }
    }
    
    public Integer getFileStatus(){
        return fileStatus;
    }
}