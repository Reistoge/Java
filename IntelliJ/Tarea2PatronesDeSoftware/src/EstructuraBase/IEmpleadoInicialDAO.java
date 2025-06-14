package EstructuraBase;

public interface IEmpleadoInicialDAO {
    void agregarEmpleado(EmpleadoInicial empleado);
    EmpleadoInicial obtenerEmpleado(String nombre);
    void eliminarEmpleado(String nombre);
    void actualizarEmpleado(EmpleadoInicial empleado );
}