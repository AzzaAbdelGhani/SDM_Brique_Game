package Game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private final Board board = new Board();

    @Test
    public void checkSize()
    {
        assertEquals(board.getSize(), 15);
    }

    @ParameterizedTest
    @CsvSource({"-1,5", "18, 1", "-4, -5", "1, -6", "4, 15", "16, 20", "-4 ,25"})
    public void checkInvalidPositions(int row_id, int col_id){
        Coordinates co = new Coordinates(row_id, col_id);
        assertFalse(board.isValidPos(co));
    }

    @ParameterizedTest
    @CsvSource({"1,5", "14, 14", "0,0", "6,9", "10, 13", "3, 1"})
    public void checkValidPositions(int row_id, int col_id){
        Coordinates co = new Coordinates(row_id, col_id);
        assertTrue(board.isValidPos(co));
    }

    @ParameterizedTest
    @CsvSource({"4,5", "14, 3", "0, 9", "10, 14", "1, 0"})
    public void getThePositionFromBoard_ValidPositions(int row_id, int col_id){
        Coordinates co = new Coordinates(row_id, col_id);
        Position pos = board.getPos(co);
        assertEquals(pos.getRow_idx(), co.getRow_idx());
        assertEquals(pos.getCol_idx(), co.getCol_idx());
    }

    @ParameterizedTest
    @CsvSource({"19,6", "7, 15", "-6, 28", "6, -29", "-7, -9"})
    public void getThePositionFromBoard_InvalidPositions(int row_id, int col_id){
        Coordinates co = new Coordinates(row_id, col_id);
        Position pos = board.getPos(co);
        assertEquals(pos.getRow_idx(), -1);
        assertEquals(pos.getCol_idx(), -1);
    }

}
