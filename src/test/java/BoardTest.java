import Game.Board;
import Game.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private final Board board = new Board();
    private final Position pos = new Position(0,5);

    @Test
    public void checkSize()
    {
        assertEquals(board.getSize(), 15);
    }
    @Test
    public void checkBoardRowIdxAndColIdx()
    {
        assertEquals(board.getPos(0,5).getRow_idx(),pos.getRow_idx());
        assertEquals(board.getPos(0,5).getCol_idx(),pos.getCol_idx());
    }
    @Test
    public void checkBoardPositionColor()
    {
        assertEquals(board.getPosColor(0,5), pos.getPosColor());
        assertEquals(board.getPosColor(0,0), new Position(0,0).getPosColor());
    }
    @Test
    public void checkBoardPieceColor()
    {
        assertEquals(board.getPosFill(0,5), pos.getPieceColor());
    }
}
