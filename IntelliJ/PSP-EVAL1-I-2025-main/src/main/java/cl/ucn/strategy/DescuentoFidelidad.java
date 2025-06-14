package cl.ucn.strategy;

import cl.ucn.modelo.Cliente;
import cl.ucn.modelo.Producto;
import java.util.List;

public class DescuentoFidelidad implements IDescuentoStrategy {
    @Override
    public int calcular(List<Producto> productos, Cliente cliente, String fechaActual) {
        if (Integer.valueOf(fechaActual.substring(0,4)) - cliente.getAnhoRegistro() >= 2)
            return 500;
        return 0;
    }
}