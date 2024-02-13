module org.openjfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;

    opens org.dealership to javafx.fxml;
    exports org.dealership;
}
