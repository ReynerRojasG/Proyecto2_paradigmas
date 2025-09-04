package modelo;

public class Asalariado extends Empleado {

    private double salarioMensual;

    public Asalariado(String cedula, String nombre, double salarioMensual, Incentivo incentivo) {
        super(cedula, nombre, 0.0, incentivo);
        this.salarioMensual = salarioMensual;
    }
    
    public double salarioQuicena() {
        if (salarioMensual > 0){
            return salarioMensual/2;
        }else {
            return salarioMensual = 0.0;
        }  
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }
     
    @Override
    public String toCSV() {
        return getCedula() + ";" + getNombre() + ";" + salarioMensual + ";" + salarioQuicena();
    }

    @Override
    public double bono() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
