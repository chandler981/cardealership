module org.openjfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;

    opens org.dealership.controllerClasses to javafx.fxml;
    opens org.dealership.Entities;
    exports org.dealership;
    exports org.dealership.controllerClasses;
}
