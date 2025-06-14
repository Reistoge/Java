package cl.ucn.proxy;

import cl.ucn.modelo.Cliente;
import cl.ucn.modelo.Producto;

import java.util.List;

public interface IClienteDAO {
    // necesitamos un contrato para obtener un cliente por su rut
    Cliente getCliente(Long rut);
    // necesitamos un contrato para obtener todos los clientes
    List<Cliente> getClientes();
    // necesitamos un contrato para obtener todos los productos de un cliente
    List<Producto> getProductosByRut(Long rut);
}

