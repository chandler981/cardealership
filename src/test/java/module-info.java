module org.openjfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;
    requires javafx.base;

    opens org.dealership.controllerClasses to javafx.fxml;
    opens org.dealership.Entities;
    exports org.dealership;
    exports org.dealership.controllerClasses;
}
