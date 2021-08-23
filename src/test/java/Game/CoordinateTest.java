package Game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoordinateTest {
    private final Coordinates coordinates = new Coordinates(5,7);

    @Test
    public void checkGetRowIdAndGetColId()
    {
        assertEquals(coordinates.getRow_idx(),5);
        assertEquals(coordinates.getCol_idx(), 7);
    }
    @Test
    public void checkNeighbours()
    {
        Coordinates up = coordinates.getUp();
        Coordinates down = coordinates.getDown();
        Coordinates right = coordinates.getRight();
        Coordinates left = coordinates.getLeft();
        Coordinates diagDown = coordinates.getDiagDown();
        Coordinates diagUp = coordinates.getDiagUp();
        assertEquals(up.getRow_idx(), 5);
        assertEquals(up.getCol_idx(), 8);
        assertEquals(down.getRow_idx(), 5);
        assertEquals(down.getCol_idx(), 6);
        assertEquals(right.getRow_idx(), 6);
        assertEquals(right.getCol_idx(), 7);
        assertEquals(left.getRow_idx(), 4);
        assertEquals(left.getCol_idx(), 7);
        assertEquals(diagDown.getRow_idx(), 4);
        assertEquals(diagDown.getCol_idx(), 6);
        assertEquals(diagUp.getRow_idx(), 6);
        assertEquals(diagUp.getCol_idx(), 8);
    }
}
