package Game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CoordinateTest {

    @ParameterizedTest
    @CsvSource({"3, 5, 3, 5", "8,10, 8, 10", "16, 18, 16, 18", "9, 3, 9, 3", "-1,-6, -1, -6"})
    public void checkGetRowIdAndGetColId(int row_id, int col_id, int expected_row_id, int expected_col_id)
    {
        Coordinates coordinates1 = new Coordinates(row_id, col_id);
        assertEquals(coordinates1.getRow_idx(),expected_row_id);
        assertEquals(coordinates1.getCol_idx(),expected_col_id);
    }

    @ParameterizedTest
    @CsvSource({"4, 6, 4, 7", "8, 17, 8, 18", "-5, -3, -5, -2", "19, 23, 19, 24"})
    public void checkGetUpCoordinate(int row_id, int col_id, int expected_row_id, int expected_col_id)
    {
        Coordinates up = (new Coordinates(row_id, col_id)).getNeighbours(0,1);
        assertEquals(up.getRow_idx(), expected_row_id);
        assertEquals(up.getCol_idx(), expected_col_id);
    }

    @ParameterizedTest
    @CsvSource({"2, 6, 2, 5", "9, 1, 9, 0", "18, -1, 18, -2", "4, 20, 4, 19"})
    public void checkGetDownCoordinate(int row_id, int col_id, int expected_row_id, int expected_col_id)
    {
        Coordinates down = (new Coordinates(row_id, col_id)).getNeighbours(0,-1);
        assertEquals(down.getRow_idx(), expected_row_id);
        assertEquals(down.getCol_idx(), expected_col_id);
    }

    @ParameterizedTest
    @CsvSource({"5, 8, 4, 8", "13, 5, 12, 5", "-5, 14, -6, 14", "10, 14, 9, 14"})
    public void checkGetLeftCoordinate(int row_id, int col_id, int expected_row_id, int expected_col_id)
    {
        Coordinates left = (new Coordinates(row_id, col_id)).getNeighbours(-1,0);
        assertEquals(left.getRow_idx(), expected_row_id);
        assertEquals(left.getCol_idx(), expected_col_id);
    }

    @ParameterizedTest
    @CsvSource({"2, 6, 3, 6", "7, 8, 8, 8", "10, 28, 11, 28", "12, 18, 13, 18"})
    public void checkGetRightCoordinate(int row_id, int col_id, int expected_row_id, int expected_col_id)
    {
        Coordinates right = (new Coordinates(row_id, col_id)).getNeighbours(1,0);
        assertEquals(right.getRow_idx(), expected_row_id);
        assertEquals(right.getCol_idx(), expected_col_id);
    }

    @ParameterizedTest
    @CsvSource({"1, 1 , 2, 2 ", "10, 20, 11, 21", "-4, 4, -3, 5", "15, 5, 16, 6"})
    public void checkGetDiagUpCoordinate(int row_id, int col_id, int expected_row_id, int expected_col_id)
    {
        Coordinates diagUp = (new Coordinates(row_id, col_id)).getNeighbours(1,1);
        assertEquals(diagUp.getRow_idx(), expected_row_id);
        assertEquals(diagUp.getCol_idx(), expected_col_id);
    }

    @ParameterizedTest
    @CsvSource({"6, 6, 5, 5", "3, 1, 2, 0", "14, 10, 13, 9", "8, 12, 7, 11"})
    public void checkGetDiagDownCoordinate(int row_id, int col_id, int expected_row_id, int expected_col_id)
    {
        Coordinates diagDown = (new Coordinates(row_id, col_id)).getNeighbours(-1,-1);
        assertEquals(diagDown.getRow_idx(), expected_row_id);
        assertEquals(diagDown.getCol_idx(), expected_col_id);
    }

}
