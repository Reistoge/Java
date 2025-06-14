package cl.ucn.utilities;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class CargadorCSV {

    public static List<RegistroClienteProducto> cargarRegistros(String rutaArchivo) {

        ClassLoader classLoader = CargadorCSV.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(rutaArchivo);

        try (  Reader reader = new InputStreamReader(inputStream)) {
            CsvToBean<RegistroClienteProducto> csvToBean = new CsvToBeanBuilder<RegistroClienteProducto>(reader)
                    .withType(RegistroClienteProducto.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            // Retorna una lista con los datos del archivo csv
            return csvToBean.parse();

        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
    public static void main(String[] args) {

        List<RegistroClienteProducto> registros = cargarRegistros("clientes.csv");
        for (RegistroClienteProducto registro : registros) {
            System.out.println(registro.getNombre() + " compró " + registro.getNombreProducto());
        }
    }
}

