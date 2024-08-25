package Chess;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class PromotionDialog extends Dialog<String> {

    public PromotionDialog() {
        setTitle("Promotion");

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Promotion.fxml"));
            AnchorPane anchorPane = fxmlLoader.load(); // Load as AnchorPane
            getDialogPane().setContent(anchorPane);

            Promotion promotionController = fxmlLoader.getController();
            promotionController.initialize(null, null); // Manually call initialize since it's a dialog now

            // Set up buttons
            ButtonType selectButtonType = new ButtonType("Select", ButtonBar.ButtonData.OK_DONE);
            getDialogPane().getButtonTypes().addAll(selectButtonType, ButtonType.CANCEL);

            // Get the result (the chosen piece)
            setResultConverter(dialogButton -> {
                if (dialogButton == selectButtonType) {
                    return promotionController.getChosenPiece();
                }
                return null;
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
