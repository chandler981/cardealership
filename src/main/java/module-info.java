module org.openjfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;

    opens org.dealership.controllerClasses to javafx.fxml;
    exports org.dealership;
    exports org.dealership.controllerClasses;
}
