package modelo;
//Subclase para empleados temporales
public class Temporal extends Empleado {

    private double tarifaDiaria;

    private int diasActivos;

    public Temporal(String cedula, String nombre, Incentivo incentivo, Integer aniosServicio, double tarifaDiaria, int diasActivos) {
        super(cedula, nombre, incentivo,aniosServicio);
        this.tarifaDiaria = tarifaDiaria;
        this.diasActivos =diasActivos;
    }
    //Calcular salario quincenal para un empleado temporal
    public double salarioQuicena() {
        return diasActivos * tarifaDiaria;
    }
    //Retornar To string para guardar en el archivo CSV
    public String toCSV() {
        return "TEMPORAL;" + getCedula() + ";" + getNombre() + ";" + getTarifaDiaria() + ";" + getDiasActivos()+ ";" + getAniosServicio();
    }

    public double getTarifaDiaria() {
        return tarifaDiaria;
    }

    public int getDiasActivos() {
        return diasActivos;
    }

    public void setTarifaDiaria(double tarifaDiaria) {
        this.tarifaDiaria = tarifaDiaria;
    }

    public void setDiasActivos(int diasActivos) {
        this.diasActivos = diasActivos;
    }
    
    
}
