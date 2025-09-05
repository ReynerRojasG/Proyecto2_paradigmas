package modelo;
//Calcular incentivo por antiguedad
public class IncentivoAntiguedad implements Incentivo {

    public double calcularBono(Empleado empleado) {
        return empleado.getAniosServicio() * 100;      
    }
}
