package modelo;

public class Comisionista extends Empleado {

    private double base;

    private double porcentaje;

    private double ventasQuincena;

    public Comisionista(String cedula, String nombre, Incentivo incentivo, Integer aniosServicio, double base, double porcentaje, double ventasQuincena) {
        super(cedula, nombre, incentivo, aniosServicio);
        this.base = base;
        this.porcentaje = porcentaje;
        this.ventasQuincena = ventasQuincena;
    }

    public Comisionista(String cedula, String nombre, Integer aniosServicio, double base, double porcentaje, double ventasQuincena) {
        super(cedula, nombre, null, aniosServicio);
        this.base = base;
        this.porcentaje = porcentaje;
        this.ventasQuincena = ventasQuincena;
    }

    public double salarioQuicena() {
        return base + (porcentaje / ventasQuincena);
    }

    public String toCSV() {
        return "COMISIONISTA;" + getCedula() + ";" + getNombre() + ";" + getBase() + ";" + getPorcentaje() + ";" + getVentasQuincena();
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double getVentasQuincena() {
        return ventasQuincena;
    }

    public void setVentasQuincena(double ventasQuincena) {
        this.ventasQuincena = ventasQuincena;
    }
}
