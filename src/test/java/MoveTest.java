import Game.Board;
import Game.Move;
import Game.Piece_Color;
import Game.Player;
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
        assertTrue(move.makeMove(0,5));
        assertEquals(this.board.getPosFill(0,5), Piece_Color.BLACK);
        assertFalse(this.P1.IsActive());
        assertTrue(this.P2.IsActive());
    }
    @Test
    public void checkXandY()
    {
        move.makeMove(5, 1);
        assertEquals(move.getX(), 5);
        assertEquals(move.getY(), 1);
    }
    @Test
    public void checkInvalidMove()
    {
        assertFalse(move.makeMove(-1,5));
        assertFalse(move.makeMove(16,7));
        assertFalse(move.makeMove(4, -8));
        assertFalse(move.makeMove(1, 19));
        assertTrue(move.makeMove(1,2));
        assertFalse(move.makeMove(1, 2));
    }
    @Test
    public void checkEscortFilling()
    {
        move.makeMove(1, 1);
        move.makeMove(2, 2);
        move.fillEscorts();
        assertEquals(board.getPosFill(1, 1), board.getPosFill(1, 2));
        board.printBoard();
    }
}
