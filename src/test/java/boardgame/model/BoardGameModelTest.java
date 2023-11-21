package boardgame.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardGameModelTest {

    @Test
    void squareProperty() {
    }

    @Test
    void getSquare() {
    }

    @Test
    void placeShape() {
        BoardGameModel model = new BoardGameModel("Aduaka", "Samson");
        model.placeShape(0, 0);
        assertEquals(Square.X, model.getSquare(0, 0));
        assertEquals(Square.X, model.getSquare(1, 0));
        assertEquals(Square.X, model.getSquare(0, 1));
        assertEquals(Square.NONE, model.getSquare(1, 1));
    }

    @Test
    void isFull() {
    }

    @Test
    void testToString() {
    }

    @Test
    void getCurrentPlayerData() {
    }
}