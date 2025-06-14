package cl.ucn.modelo;

import cl.ucn.strategy.*;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDescuento {
    private final List<IDescuentoStrategy> estrategias;

    public GerenciadorDescuento() {
        estrategias = new ArrayList<>();
        estrategias.add(new DescuentoPorCategoria());
        estrategias.add(new DescuentoCumpleanhos());
        estrategias.add (new DescuentoCantidad());
        estrategias.add(new DescuentoFidelidad());
        // Agregar otras estrategias
    }

    public List<Integer> calcularPrecioFinal(List<Producto> productos, Cliente cliente, String fechaActual) {
        if (productos == null || cliente == null || fechaActual == null) {
            // validacion de los datos.
            return List.of(0, 0, 0, 0, 0, 0);
        }
        int precioInicial = productos.stream().mapToInt(Producto::getPrecioProducto).sum();
        List<Integer> descuentos = new ArrayList<>();
        for (IDescuentoStrategy estrategia : estrategias) {
            descuentos.add(estrategia.calcular(productos, cliente, fechaActual));
        }

        int precioFinal = precioInicial - descuentos.stream().mapToInt(Integer::intValue).sum();

        List<Integer> resultado = new ArrayList<>();
        resultado.add(precioInicial);
        resultado.addAll(descuentos);
        resultado.add(precioFinal);

        return resultado;
    }
}
