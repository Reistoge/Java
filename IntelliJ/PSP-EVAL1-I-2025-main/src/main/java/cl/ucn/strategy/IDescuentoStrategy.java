package cl.ucn.strategy;

import cl.ucn.modelo.Cliente;
import cl.ucn.modelo.Producto;
import java.util.List;

public interface IDescuentoStrategy {
    // encapsulamos a los distintos descuentos de una venta con el contrato calcular()
    int calcular(List<Producto> productos, Cliente cliente, String fechaActual);

}

