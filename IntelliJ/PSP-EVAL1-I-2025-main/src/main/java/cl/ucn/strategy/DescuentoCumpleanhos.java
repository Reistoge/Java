package cl.ucn.strategy;

import cl.ucn.modelo.Cliente;
import cl.ucn.modelo.Producto;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;

public class DescuentoCumpleanhos implements IDescuentoStrategy {

    @Override
    public int calcular(List<Producto> productos, Cliente cliente, String fechaActual) {

        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        LocalDate fechaNac = LocalDate.parse(cliente.getFechaNacimiento(), formatter);
        LocalDate fechaAct = LocalDate.parse(fechaActual, formatter);
        if ((fechaNac.getMonthOfYear() == fechaAct.getMonthOfYear()) &&
                (fechaNac.getDayOfMonth() == fechaAct.getDayOfMonth()))
            return 100;
        return 0;
    }
}