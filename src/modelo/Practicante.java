package modelo;

public class Practicante {

    private double apoyoQuincena;

    private String cedula;

    private String nombre;

    public Practicante( String cedula, String nombre,double apoyoQuincena) {
        this.apoyoQuincena = apoyoQuincena;
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public String toCSV() {
        return "PRACTICANTE;" + getCedula() + ";" + getNombre() + ";" + getApoyoQuincena();
    }

    public double getApoyoQuincena() {
        return apoyoQuincena;
    }

    public void setApoyoQuincena(double apoyoQuincena) {
        this.apoyoQuincena = apoyoQuincena;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
