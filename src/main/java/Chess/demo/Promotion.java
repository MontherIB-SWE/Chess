package sql.demo;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Promotion implements Initializable {
    public ImageView first;
    public ImageView forth;
    public ImageView third;
    public ImageView second;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (HelloController.promote.startsWith("B")) {

            Image image1 = new Image(Objects.requireNonNull(getClass().getResource("/images/BBishop.png")).toExternalForm()); // Load from resources
            Image image2 = new Image(Objects.requireNonNull(getClass().getResource("/images/BKnight.png")).toExternalForm()); // Load from resources
            Image image3 = new Image(Objects.requireNonNull(getClass().getResource("/images/BRook.png")).toExternalForm()); // Load from resources
            Image image4 = new Image(Objects.requireNonNull(getClass().getResource("/images/BQueen.png")).toExternalForm()); // Load from resources

            first.setImage(image1);
            second.setImage(image2);
            third.setImage(image3);
            forth.setImage(image4);
        } else if (HelloController.promote.startsWith("W")) {

            Image image1 = new Image(Objects.requireNonNull(getClass().getResource("/images/WBishop.png")).toExternalForm()); // Load from resources
            Image image2 = new Image(Objects.requireNonNull(getClass().getResource("/images/WKnight.png")).toExternalForm()); // Load from resources
            Image image3 = new Image(Objects.requireNonNull(getClass().getResource("/images/WRook.png")).toExternalForm()); // Load from resources
            Image image4 = new Image(Objects.requireNonNull(getClass().getResource("/images/WQueen.png")).toExternalForm()); // Load from resources
            first.setImage(image1);
            second.setImage(image2);
            third.setImage(image3);
            forth.setImage(image4);

        }
    }

    public void button(ActionEvent event,String[][] boardState,int toX,int toY) {

        Button button = (Button) event.getSource();
        ImageView buttonImage = (ImageView) button.getGraphic();
        String url = buttonImage.getImage().getUrl();

        String imageName = url.substring(url.lastIndexOf("/") + 1);
        piecePro = imageName.split("\\.")[0];

        Image image = new Image(Objects.requireNonNull(getClass().getResource("/images/"+piecePro+".png")).toExternalForm()); // Load from resources
        Button button1 = HelloController.clickedButton;
        ImageView buttonImage1 = (ImageView) button1.getGraphic();
        buttonImage1.setImage(image);

        Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage1.close();


    }

    static String piecePro;
}
