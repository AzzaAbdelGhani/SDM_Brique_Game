import Game.Piece_Color;
import Game.Pos_Color;
import Game.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    private final Position pos = new Position(0 ,1);
    @Test
    public void checkRowAndColIdx()
    {
        assertEquals(pos.getRow_idx(),0);
        assertEquals(pos.getCol_idx(), 1);
    }
    @Test
    public void checkPosColor()
    {
        assertEquals(pos.getPosColor(), Pos_Color.DARK);
        assertEquals(new Position(2, 2).getPosColor(), Pos_Color.LIGHT);
    }
    @Test
    public void checkPieceColor()
    {
        assertEquals(pos.getPieceColor(), Piece_Color.BLANK);
        pos.setPieceColor(Piece_Color.BLACK);
        assertEquals(pos.getPieceColor(), Piece_Color.BLACK);
    }
}
