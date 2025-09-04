package modelo;

public class IncentivoProductividad implements Incentivo {
    private double monto;
    
    public IncentivoProductividad(double monto) {
        this.monto = monto;
    }
    
    @Override
    public Empleado calcularBono(Empleado empleado) {
        double nuevoSalario = empleado.salarioQuicena() + monto;
        System.out.println("Se aplico un bono de " + monto + " al empleado.");
        System.out.println("Nuevo salario: " + nuevoSalario);
        return empleado;
    }
}
