package boardgame;

import boardgame.controller.BoardGameController;
import boardgame.model.BoardGameModel;
import boardgame.model.Square;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BoardGameApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/pregame.fxml"));
        Parent root = loader.load();


        String player1Name = "Player 1";
        String player2Name = "Player 2";

        primaryStage.setTitle("Board Game");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
