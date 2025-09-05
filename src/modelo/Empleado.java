package modelo;
//Clase padre Empleado
public abstract class Empleado implements Bonificable {

    private String cedula;

    private String nombre;

    private double salarioXquincena;

    private Incentivo incentivo;
    
    private Integer aniosServicio; 
    
    public Empleado(String cedula, String nombre, Incentivo incentivo, Integer aniosServicio) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.incentivo = incentivo;
        this.aniosServicio = aniosServicio;
    }
    
    public Empleado(String cedula, String nombre, double salarioXquincena, Integer aniosServicio) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.salarioXquincena = salarioXquincena;
        this.incentivo = null;
        this.aniosServicio = aniosServicio;
    }
    //Función que hereda en las subclases y calcula un salario quincenal diferente
    public abstract double salarioQuicena();

    public abstract String toCSV();      
    
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

    public Integer getAniosServicio() {
        return aniosServicio;
    }
    
    public void setSalarioXquincena(double salario) {
        this.salarioXquincena = salario;
    }
    
    public void setIncentivo(Incentivo incentivo) {
        this.incentivo = incentivo;
    }

    public void setAniosServicio(Integer aniosServicio) {
        this.aniosServicio = aniosServicio;
    }
    
    @Override
    public double bono(){
        return incentivo.calcularBono(this);
    }   
}
