package Game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    private final Position pos = new Position(0 ,1);

    @Test
    public void checkRowAndColIdx()
    {
        Position pos = new Position(0, 1);
        assertEquals(pos.getRow_idx(),0);
        assertEquals(pos.getCol_idx(), 1);
    }

    @ParameterizedTest
    @CsvSource({"1, 4","7, 8", "10, 3", "3, 8", "9, 2"})
    public void checkDarkPosColor(int row_id, int col_id)
    {
        Position pos = new Position(row_id, col_id);
        assertEquals(pos.getPosColor(), Pos_Color.DARK);
    }

    @ParameterizedTest
    @CsvSource({"8, 4","10, 2", "1, 5", "3, 9", "7, 5"})
    public void checkLightPosColor(int row_id, int col_id)
    {
        Position pos = new Position(row_id, col_id);
        assertEquals(pos.getPosColor(), Pos_Color.LIGHT);
    }

    @ParameterizedTest
    @CsvSource({"BLANK, BLANK", "BLACK, BLACK", "WHITE, WHITE"})
    public void checkPieceColor(String piece, String expected_piece)
    {
        assertEquals(pos.getPieceColor(), Piece_Color.BLANK);
        pos.setPieceColor(Piece_Color.valueOf(piece));
        assertEquals(pos.getPieceColor().getString(), expected_piece );
    }
}
