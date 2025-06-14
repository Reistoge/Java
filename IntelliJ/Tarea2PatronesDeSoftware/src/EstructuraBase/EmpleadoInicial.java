package EstructuraBase;

public class EmpleadoInicial {
    private String nombre;
    private String puesto ;
    private double salario ;
    public EmpleadoInicial(String nombre, String puesto , double salario ) {
        this .nombre = nombre;
        this . puesto = puesto ;
        this . salario = salario ;
    }
    public String getNombre() {
        return nombre;
    }
    public String getPuesto() {
        return puesto ;
    }
    public double getSalario () {
        return salario ;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto ;
    }
    public void setSalario (double salario ) {
        this.salario = salario ;
    }
}