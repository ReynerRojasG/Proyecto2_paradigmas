package modelo;
//Subclase para empleados asalariados
    public class Asalariado extends Empleado {

        private double salarioMensual;

        public Asalariado(String cedula, String nombre, double salarioMensual, Incentivo incentivo, Integer aniosServicio) {
            super(cedula, nombre, incentivo,aniosServicio);
            this.salarioMensual = salarioMensual;
        }
        //Calcular salario quincenal para un asalariado
        public double salarioQuicena() {
            if (salarioMensual > 0){
                return salarioMensual/2;
            }else {
                return salarioMensual = 0.0;
            }  
        }

        public double getSalarioMensual() {
            return salarioMensual;
        }
        //Retornar To string para guardar en el archivo CSV
        @Override
        public String toCSV() {
            return "ASALARIADO;" + getCedula() + ";" + getNombre() + ";" + salarioMensual + ";" + salarioQuicena() + ";" + getAniosServicio();
        }
    }
