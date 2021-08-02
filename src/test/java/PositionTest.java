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

}
