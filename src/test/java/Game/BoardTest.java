package Game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    private final Board board = new Board();
    private final Position pos = new Position(0,5);
    Coordinates coordinates = new Coordinates(0,5);

    @Test
    public void checkSize()
    {
        assertEquals(board.getSize(), 15);
    }

    /*@ParameterizedTest
    @CsvSource({""})
    public void checkGetPos(int row_id, int col_id, int expected_row_id, int expected_col_id)
    {
        Position po = new Position(row_id, col_id);
        Coordinates co = new Coordinates(row_id, col_id);
        assertEquals(board.getPos(co).getRow_idx(), po.getRow_idx());
        assertEquals(board.getPos(co).getCol_idx(), po.getCol_idx());
    }*/
}
