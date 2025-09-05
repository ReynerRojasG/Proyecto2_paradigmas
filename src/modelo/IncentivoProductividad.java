package modelo;

public class IncentivoProductividad implements Incentivo {

    @Override
    public double calcularBono(Empleado empleado) {
        return empleado.getSalarioXquincena() * 0.05 + empleado.getAniosServicio() * 50;
    }
}
