module sql.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens sql.demo to javafx.fxml;
    exports sql.demo;
}