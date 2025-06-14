module ResilienciaPSPII20204 {
    requires jakarta.persistence;
    requires javafx.controls;
    requires javafx.graphics;
    requires org.hibernate.orm.core;
    requires org.joda.time;
    opens cl.ucn.modelo to org.hibernate.orm.core;
    exports cl.ucn.main;

}