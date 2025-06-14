package cl.ucn.config;

import java.util.Properties;

// En package cl.ucn.config
public class ConfiguracionSistema {
    private static ConfiguracionSistema instance;
    private Properties config;

    private ConfiguracionSistema() {
        config = new Properties();
        // Aqui se cargan las configuraciones
    }

    public static ConfiguracionSistema getInstance() {
        if (instance == null) {
            instance = new ConfiguracionSistema();
        }
        return instance;
    }

    public String getFechaActual() {
        return config.getProperty("fecha.actual");
    }

    public String getFormatoFecha() {
        return config.getProperty("fecha.formato", "yyyy-MM-dd");
    }
}