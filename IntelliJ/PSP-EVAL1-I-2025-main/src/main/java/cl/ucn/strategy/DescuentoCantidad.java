package cl.ucn.strategy;

import cl.ucn.modelo.Cliente;
import cl.ucn.modelo.Producto;

import java.util.List;

public class DescuentoCantidad implements IDescuentoStrategy {

    // Descuento del 10% si la cantidad de productos es mayor a 2
    @Override
    public int calcular(List<Producto> productos, Cliente cliente, String fechaActual) {
        // logica asociada al descuento por cantidad, encapsulada.
        if (productos.size() > 2) {
            // hacemos un 10% de descuento
            return 100;
        }
        return 0;
    }
}


