package cl.ucn.proxy;

import cl.ucn.modelo.Cliente;
import cl.ucn.modelo.Producto;
import jakarta.persistence.EntityManager;

import java.util.List;


public class ClienteFileDAO implements IClienteDAO {

    // En esta clase se implementaria el codigo necesario para poder extraer los datos de un csv
    // y ahorrar el procesamiento de de datos frente a las consultas de base de datos.

    @Override
    public List<Cliente> getClientes() {
        return List.of();
    }
    public Cliente getCliente(Long rut) {
        // Proceso menos demandante - implementacion actual de un archivo csv
        return null;
    }
    public List<Producto> getProductosByRut(Long rut) {
        // Proceso menos demandante - implementacion actual de un archivo csv
        return List.of();
    }
    private void cargarDatosCsv(){
        // aqui se implementaria la logica para obtener los datos del csv

    }

}
