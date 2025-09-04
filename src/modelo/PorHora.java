package modelo;

public class PorHora extends Empleado {

    private double tarifaHora;

    private double horasQuincena;

    public PorHora(String cedula, String nombre, Incentivo incentivo, Integer aniosServicio, double tarifaHora, double horasQuincena) {
        super(cedula, nombre, incentivo, aniosServicio);
        this.tarifaHora = tarifaHora;
        this.horasQuincena = horasQuincena;
    }

    public double salarioQuicena() {
        return tarifaHora * horasQuincena;
    }

    public String toCSV() {
        return "PORHORA;" + getCedula() + ";" + getNombre() + ";" + getTarifaHora() + ";" + getHorasQuincena();
    }

    public double getTarifaHora() {
        return tarifaHora;
    }

    public void setTarifaHora(double tarifaHora) {
        this.tarifaHora = tarifaHora;
    }

    public double getHorasQuincena() {
        return horasQuincena;
    }

    public void setHorasQuincena(double horasQuincena) {
        this.horasQuincena = horasQuincena;
    }
    
    
}
