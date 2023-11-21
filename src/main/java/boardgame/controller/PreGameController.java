package boardgame.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.tinylog.Logger;

import java.io.IOException;

public class PreGameController {
    @FXML
    private TextField PLAYER_1;
    @FXML
    private TextField PLAYER_2;
    @FXML
    private Button startGameButton;
    @FXML
    private Button viewHighScoreButton;

    @FXML
    private void handleStartGameButtonClick(ActionEvent event) throws IOException {
        String player1Name = PLAYER_1.getText();
        String player2Name = PLAYER_2.getText();

        Logger.info("Name entered: {}", PLAYER_1.getText());
        Logger.info("Name entered: {}", PLAYER_2.getText());

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gameboard.fxml"));
        Parent root = fxmlLoader.load();

        BoardGameController controller = fxmlLoader.getController();
        controller.initializeGame(player1Name, player2Name);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }


}
