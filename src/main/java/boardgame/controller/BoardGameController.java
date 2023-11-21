package boardgame.controller;

import boardgame.model.BoardGameModel;
import boardgame.model.Square;
import boardgame.model.SquareNode;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class BoardGameController {
    @FXML
    public GridPane board;
    private BoardGameModel model;
    private String dateStarted;

    public void initializeGame(String player1Name, String player2Name) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        model = new BoardGameModel(player1Name, player2Name);
    }

    @FXML
    private void initialize() {
        for (var i = 0; i < board.getRowCount(); i++) {
            for (var j = 0; j < board.getColumnCount(); j++) {
                SquareNode square = createSquare();
                board.add(square, j, i);
            }
        }
    }

    private SquareNode createSquare() {
        SquareNode square = new SquareNode(Square.NONE);
        square.getStyleClass().add("square");
        square.setOnMouseClicked(this::handleMouseClick);
        return square;
    }

    @FXML
    private void handleMouseClick(MouseEvent event) {
        SquareNode selectedSquare = (SquareNode) event.getSource();

        if (selectedSquare.getSquare() != Square.NONE) {
            System.out.println("Invalid move");
            return;
        }

        int row = GridPane.getRowIndex(selectedSquare);
        int col = GridPane.getColumnIndex(selectedSquare);

        model.placeShape(row, col);

        updateBoard();

        int numberOfEmptyCells = getNumberOfEmptyCells();
        if (numberOfEmptyCells == 0) {
            // Implement logic to display results or perform any other action when the game ends.
            System.out.println("Game Over");
        }
        System.out.printf("Click on square (%d,%d)%n", row, col);
    }

    private void updateBoard(){
        for (var i = 0; i < board.getRowCount(); i++){
            for (var j = 0; j < board.getColumnCount(); j++){
                SquareNode node = (SquareNode) getNodeByRowColumnIndex(i, j);
                node.setSquare(model.getSquare(i, j));
            }
        }
    }

    public Node getNodeByRowColumnIndex(final Integer row, final Integer column) {
        Node result = null;
        ObservableList<Node> children = board.getChildren();

        for (Node node : children) {
            if (Objects.equals(GridPane.getRowIndex(node), row) && Objects.equals(GridPane.getColumnIndex(node), column)) {
                result = node;
                break;
            }
        }

        return result;
    }

    public int getNumberOfEmptyCells() {
        int totalCells = board.getRowCount() * board.getColumnCount();
        int emptyCells = 0;

        for (var i = 0; i < board.getRowCount(); i++) {
            for (var j = 0; j < board.getColumnCount(); j++) {
                SquareNode node = (SquareNode) getNodeByRowColumnIndex(i, j);
                if (node.getSquare() == Square.NONE) {
                    emptyCells++;
                }
            }
        }

        return emptyCells;
    }


}
