package cl.ucn.strategy;

import cl.ucn.modelo.Cliente;
import cl.ucn.modelo.Producto;
import java.util.List;

public class DescuentoPorCategoria implements IDescuentoStrategy {
    @Override
    public int calcular(List<Producto> productos, Cliente cliente, String fechaActual) {
        for (Producto producto : productos) {
            if (producto.getCategoria().equals("casa")) {
                return 200;
            }
        }
        return 0;
    }
}
