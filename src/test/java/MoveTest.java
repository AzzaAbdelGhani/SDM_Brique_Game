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
        move.makeMove(0,5);
        assertEquals(this.board.getPosFill(0,5), Piece_Color.BLACK);
        assertFalse(this.P1.IsActive());
        assertTrue(this.P2.IsActive());
    }
    @Test
    public void checkXandY()
    {
        move.makeMove(1, 2);
        assertEquals(move.getX(), 1);
        assertEquals(move.getY(), 2);
    }
}
