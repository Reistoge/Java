module Eval1PSPI2025 {
    requires javafx.controls;
    requires javafx.graphics;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires org.joda.time;
    requires com.opencsv;
    requires java.desktop;
    requires java.base;

    // Open packages for JavaFX and Hibernate
    opens cl.ucn.main to javafx.graphics, javafx.controls;
    opens cl.ucn.modelo to org.hibernate.orm.core;
    opens cl.ucn.proxy to org.hibernate.orm.core;
    opens cl.ucn.strategy to org.hibernate.orm.core;
    opens cl.ucn.utilities to com.opencsv;
    opens cl.ucn.config to java.base;

    // Export necessary packages
    exports cl.ucn.main;
    exports cl.ucn.modelo;
    exports cl.ucn.proxy;
    exports cl.ucn.strategy;
    exports cl.ucn.utilities;
    exports cl.ucn.config;
}