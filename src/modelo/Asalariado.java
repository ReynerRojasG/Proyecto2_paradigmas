package modelo;

public class Asalariado extends Empleado {

    private double salarioMensual;

    public Asalariado(String cedula, String nombre, double salarioXquincena, Incentivo incentivo) {
        super(cedula, nombre, salarioXquincena, incentivo);
        this.salarioMensual = salarioXquincena * 2;
    }
    
    public double salarioQuicena() {
        return salarioMensual/2;
    }

    public String toCSV() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double bono() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
