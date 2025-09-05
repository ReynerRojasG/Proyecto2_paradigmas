package modelo;
//Subclase para empleados por hora

public class PorHora extends Empleado {

    private double tarifaHora;

    private double horasQuincena;

    public PorHora(String cedula, String nombre, Incentivo incentivo, Integer aniosServicio, double tarifaHora, double horasQuincena) {
        super(cedula, nombre, incentivo, aniosServicio);
        this.tarifaHora = tarifaHora;
        this.horasQuincena = horasQuincena;
    }

    public PorHora(String cedula, String nombre, Integer aniosServicio, double tarifaHora, double horasQuincena) {
        super(cedula, nombre, null, aniosServicio);
        this.tarifaHora = tarifaHora;
        this.horasQuincena = horasQuincena;
    }

    //Calcular salario quincenal para un empleado por hora
    public double salarioQuicena() {
        return tarifaHora * horasQuincena;
    }

    //Retornar To string para guardar en el archivo CSV
    public String toCSV() {
        return "PORHORA;" + getCedula() + ";" + getNombre() + ";" + getTarifaHora() + ";" + getHorasQuincena();
    }

    public double getTarifaHora() {
        return tarifaHora;
    }

    public double getHorasQuincena() {
        return horasQuincena;
    }

    public void setTarifaHora(double tarifaHora) {
        this.tarifaHora = tarifaHora;
    }

    public void setHorasQuincena(double horasQuincena) {
        this.horasQuincena = horasQuincena;
    }
}
