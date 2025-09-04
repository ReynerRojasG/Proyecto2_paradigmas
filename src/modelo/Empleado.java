package modelo;

public abstract class Empleado implements Bonificable {

    private String cedula;

    private String nombre;

    private double salarioXquincena;

    private Incentivo incentivo;
    
        public Empleado(String cedula, String nombre, double salarioXquincena, Incentivo incentivo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.salarioXquincena = salarioXquincena;
        this.incentivo = incentivo;
    }

    public abstract double salarioQuicena();

    public abstract String toCSV();      
    
    public void setIncentivo(Incentivo incentivo) {
        this.incentivo = incentivo;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalarioXquincena() {
        return salarioXquincena;
    }

    public Incentivo getIncentivo() {
        return incentivo;
    }
    
    

}
