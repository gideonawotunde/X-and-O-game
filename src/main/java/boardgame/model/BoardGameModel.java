package boardgame.model;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import boardgame.model.PlayerData;

/**
 * Represents the board game model, that stores the game state and provides methods to
 * manipulate the game state
 */
public class BoardGameModel {
    public static int BOARD_SIZE = 6;

    private ReadOnlyObjectWrapper<Square>[][] board = new ReadOnlyObjectWrapper[BOARD_SIZE][BOARD_SIZE];
    private PlayerData player1Data;
    private PlayerData player2Data;
    private Player currentPlayer;

    /**
     * Creates a new board game model with an empty board and 2 players
     * @param player1Name name of the first player
     * @param player2Name name of the second player
     */
    public BoardGameModel(String player1Name, String player2Name) {
        for (var i = 0; i < BOARD_SIZE; i++) {
            for (var j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = new ReadOnlyObjectWrapper<Square>(Square.NONE);
            }
        }
        player1Data = new PlayerData(player1Name, 0, Square.X);
        player2Data = new PlayerData(player2Name, 0, Square.O);
        currentPlayer = Player.PLAYER_1;
    }

    /**
     * It returns a read-only object property for the square at the specified position
     * @param i row index
     * @param j column index
     * @return read-only property for the square at the specified position
     */

    public ReadOnlyObjectProperty<Square> squareProperty(int i, int j) {
        return board[i][j].getReadOnlyProperty();
    }

    public Square getSquare(int i, int j) {
        return board[i][j].get();
    }

    /**
     * It checks if the given row and column indexes are valid coordinates on the board.
     * @param row row index
     * @param col col column index
     * @return true if the coordinates are valid and correct, otherwise it is false
     */
    private boolean isValidCoordinate(int row, int col) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE;
    }

    /**
     * This places the current player's shape at the specified position on the board
     * and it also updates the neighboring cells.
     * @param i row index
     * @param j column
     */
    public void placeShape(int i, int j){
        Square square = currentPlayer == Player.PLAYER_1 ? Square.X : Square.O;
        if(getSquare(i, j) == Square.NONE){
            board[i][j].set(square);
            for (int[] offset : new int [][]{{-1,0}, {1,0}, {0,-1}, {0,1}}){
                int newRow = i + offset[0];
                int newCol = j + offset[1];
                if(isValidCoordinate(newRow, newCol) && getSquare(newRow, newCol) == Square.NONE) {
                    board[newRow][newCol].set(square);
                }
            }
            PlayerData currentPlayerData = getCurrentPlayerData();
            currentPlayerData.setNumberOfTurns(currentPlayerData.getNumberOfTurns() +1);

            currentPlayer = currentPlayer.alter();
        }
    }


    public boolean isFull(){
        for (int i = 0; i < BOARD_SIZE; i++){
            for (int j = 0; j < BOARD_SIZE; j++){
                if(getSquare(i, j) == Square.NONE){
                    return false;
                }

            }
        }
        return true;
        }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var i = 0; i < BOARD_SIZE; i++) {
            for (var j = 0; j < BOARD_SIZE; j++) {
                sb.append(board[i][j].get().ordinal()).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
    public PlayerData getCurrentPlayerData(){
        return currentPlayer == Player.PLAYER_1 ? player1Data : player2Data;
    }

    public static void main(String[] args) {
        var model = new BoardGameModel("", "");
        System.out.println(model);
    }


    public enum Player{
        PLAYER_1,
        PLAYER_2;

        public Player alter(){
            return switch (this){
                case PLAYER_1 -> PLAYER_2;
                case PLAYER_2 -> PLAYER_1;
            };
        }
    }
}
