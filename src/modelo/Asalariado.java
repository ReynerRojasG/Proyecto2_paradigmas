package modelo;

    public class Asalariado extends Empleado {

        private double salarioMensual;

        public Asalariado(String cedula, String nombre, double salarioMensual, Incentivo incentivo, Integer aniosServicio) {
            super(cedula, nombre, incentivo,aniosServicio);
            this.salarioMensual = salarioMensual;
        }

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

        @Override
        public String toCSV() {
            return "ASALARIADO;" + getCedula() + ";" + getNombre() + ";" + salarioMensual + ";" + salarioQuicena();
        }
    }
