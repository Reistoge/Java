package EstructuraBase;

public class EmpleadoInicialService implements IEmpleadoInicialService {
    private IEmpleadoInicialDAO empleadoDAO;
    public EmpleadoInicialService(IEmpleadoInicialDAO empleadoDAO) {
        this .empleadoDAO = empleadoDAO;
    }
    @Override
    public void agregarEmpleado(EmpleadoInicial empleado) {
        empleadoDAO. agregarEmpleado(empleado );
    }
    @Override
    public EmpleadoInicial obtenerEmpleado(String nombre) {
        return empleadoDAO.obtenerEmpleado(nombre);
    }
    @Override
    public void eliminarEmpleado(String nombre) {
        empleadoDAO. eliminarEmpleado(nombre);
    }
    @Override
    public void actualizarEmpleado(EmpleadoInicial empleado) {
        empleadoDAO. actualizarEmpleado(empleado);
    }
}
