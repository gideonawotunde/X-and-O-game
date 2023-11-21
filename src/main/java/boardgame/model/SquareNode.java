package boardgame.model;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class SquareNode extends StackPane {
    private Square square;

    public SquareNode(Square square) {
        this.square = square;
        updateAppearance();
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
        updateAppearance();
    }

    private void updateAppearance() {

        getChildren().clear();
        if (square != Square.NONE) {
            Label squareLabel = new Label(square.toString());
            squareLabel.getStyleClass().add("square-label");
            getChildren().add(squareLabel);
        }
    }
}
