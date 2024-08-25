module sql.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens Chess to javafx.fxml;
    exports Chess;
}