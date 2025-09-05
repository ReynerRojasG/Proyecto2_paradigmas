package modelo;
//Calcular incentivo por desempeño
public class IncentivoDesempeno implements Incentivo {

    public double calcularBono(Empleado empleado) {
        return empleado.getSalarioXquincena() * 0.15;
    }
}
