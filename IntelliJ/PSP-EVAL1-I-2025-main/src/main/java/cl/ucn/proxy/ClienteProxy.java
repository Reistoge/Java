package cl.ucn.proxy;

import cl.ucn.modelo.Cliente;
import cl.ucn.modelo.Producto;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ClienteProxy implements  IClienteDAO {
    private final ClienteDBDAO dbDao;
    private final ClienteFileDAO fileDao;
    private final EntityManager em;

    public ClienteProxy(EntityManager em) {
        this.em = em;
        this.dbDao = new ClienteDBDAO(em);
        this.fileDao = new ClienteFileDAO();
    }

    @Override
    public Cliente getCliente(Long rut) {
        if (rut == null) return null;
        // primero verificamos si en el csv estan los datos para ahorrar procesamiento
        Cliente cliente = fileDao.getCliente(rut);
        if (cliente == null) {
            // si no se encuentra en el csv, buscamos en la base de datos
            cliente = dbDao.getCliente(rut);
        }
        return cliente;
    }
    public List<Cliente> getClientes(){
        // primero verificamos si en el csv estan los datos para ahorrar procesamiento
        List<Cliente> clientes = fileDao.getClientes( );
//        Cliente cliente = new Cliente();
//        cliente.setNombre("A1");
//        cliente.setAnhoRegistro(2023);
//        cliente.setRut(212345678L);
//        cliente.setFechaNacimiento("01-01-2000");
//        clientes.add(cliente);
        if (clientes == null || clientes.isEmpty()) {
            // si no se encuentra en el csv, solicitamos a la base de datos
            clientes = dbDao.getClientes( );
        }

        if(clientes != null)
        {
            return clientes;

        }
        else{
            return  List.of();
        }


    }

    @Override
    public List<Producto> getProductosByRut(Long rut) {
        if (rut == null) return List.of();

        List<Producto> productos = fileDao.getProductosByRut(rut);
        if (productos == null || productos.isEmpty()) {
            productos = dbDao.getProductosByRut(rut);
        }
        if(productos != null)
        {
            return productos;

        }
        else{
            return  List.of();
        }


    }

}
