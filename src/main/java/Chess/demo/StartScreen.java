package sql.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartScreen {
    public void start(ActionEvent event) throws IOException {

        Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage1.close();


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 462, 571);
        Stage stage = new Stage();
        stage.setTitle("Chess");
        stage.setScene(scene);
        stage.show();
    }
}
