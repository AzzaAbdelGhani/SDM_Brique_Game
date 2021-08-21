import Game.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MoveTest {
    private Board board = new Board();
    private Player P1 = new Player("Player 1", Piece_Color.BLACK);
    private Player P2 = new Player("Player 2 ", Piece_Color.WHITE);
    private Move move = new Move(board, P1, P2);

    @Test
    public void checkMakeMove()
    {
        Coordinates coordinates = new Coordinates(0,5);
        assertTrue(move.makeMove(coordinates));
        assertEquals(this.board.getPos(coordinates).getPieceColor(), Piece_Color.BLACK);
        assertFalse(this.P1.IsActive());
        assertTrue(this.P2.IsActive());
    }
    @Test
    public void checkXandY()
    {
        Coordinates coordinates = new Coordinates(0,5);
        move.makeMove(coordinates);
        assertEquals(move.getCoordinates(), coordinates);
    }
    @Test
    public void checkInvalidMove()
    {
        assertFalse(move.makeMove(new Coordinates(-1, 6)));
        assertFalse(move.makeMove(new Coordinates(16,3)));
        assertFalse(move.makeMove(new Coordinates(4,-7)));
        assertFalse(move.makeMove(new Coordinates(1, 18)));
        assertTrue(move.makeMove(new Coordinates(1,9)));
        assertFalse(move.makeMove(new Coordinates(18, -6)));
    }
    @Test
    public void checkEscortFilling()
    {
        Coordinates co = new Coordinates(1,1);
        Coordinates co1 = co.getDiagUp();
        move.makeMove(co);
        move.makeMove(co1);
        move.fillEscorts();
        assertEquals(board.getPos(co).getPieceColor(), board.getPos(co.getUp()).getPieceColor());
    }
}
