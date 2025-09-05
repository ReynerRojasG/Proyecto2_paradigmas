package modelo;

public class Temporal extends Empleado {

    private double tarifaDiaria;

    private int diasActivos;

    public Temporal(String cedula, String nombre, Incentivo incentivo, Integer aniosServicio, double tarifaDiaria, int diasActivos) {
        super(cedula, nombre, incentivo,aniosServicio);
        this.tarifaDiaria = tarifaDiaria;
        this.diasActivos =diasActivos;
    }

    public double salarioQuicena() {
        return diasActivos*tarifaDiaria;
    }

    public String toCSV() {
        return "TEMPORAL;" + getCedula() + ";" + getNombre() + ";" + getTarifaDiaria() + ";" + getDiasActivos()+ ";" + getAniosServicio();
    }

    public double getTarifaDiaria() {
        return tarifaDiaria;
    }

    public void setTarifaDiaria(double tarifaDiaria) {
        this.tarifaDiaria = tarifaDiaria;
    }

    public int getDiasActivos() {
        return diasActivos;
    }

    public void setDiasActivos(int diasActivos) {
        this.diasActivos = diasActivos;
    }
    
    
}
