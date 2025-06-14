package cl.ucn.proxy;

import cl.ucn.modelo.Cliente;
import cl.ucn.modelo.Producto;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ClienteDBDAO implements IClienteDAO {
    private final EntityManager em;

    public ClienteDBDAO(EntityManager em) {
        // atributo necesario para el procesamiento de la base de datos.
        this.em = em;
    }


    @Override
    public Cliente getCliente(Long rut) {
        // PROCESO DEMANDANTE - implementacion actual de una base de datos
        // hacer consultas de la entidad Cliente
        // con el rut necesario para obtener una instancia de Cliente
        return null;
    }
    @Override
    public List<Cliente> getClientes() {
        // PROCESO DEMANDANTE - implementacion actual de una base de datos
        // hacer consultas de las entidades Clientes para despues retornar una lista de Cliente
         return List.of();
    }
    @Override
    public List<Producto> getProductosByRut(Long rut) {
        // PROCESO DEMANDANTE - implementacion actual de una base de datos
        // hacer consultas de la entidad Producto con el rut necesario
        // para obtener una lista de Producto
        return null;
    }
}