package modelo;

public class Temporal extends Empleado {

    private double tarifaDiaria;

    private int diasActivos;

    public Temporal(String cedula, String nombre, double salarioXquincena, Incentivo incentivo) {
        super(cedula, nombre, salarioXquincena, incentivo);
    }

    public double salarioQuicena() {
        return 0.0;
    }

    public String toCSV() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double bono() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
