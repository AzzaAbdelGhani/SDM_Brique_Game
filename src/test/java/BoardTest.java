import Game.Board;
import Game.Coordinates;
import Game.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private final Board board = new Board();
    private final Position pos = new Position(0,5);
    Coordinates coordinates = new Coordinates(0,5);

    @Test
    public void checkSize()
    {
        assertEquals(board.getSize(), 15);
    }
    @Test
    public void checkGetPos()
    {
        assertEquals(board.getPos(coordinates), pos);
    }
}
