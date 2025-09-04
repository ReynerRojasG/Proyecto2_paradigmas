package modelo;

public class IncentivoAntiguedad implements Incentivo {

    public double calcularBono(Empleado empleado) {
        return empleado.getAniosServicio() * 100;
        
    }
}
