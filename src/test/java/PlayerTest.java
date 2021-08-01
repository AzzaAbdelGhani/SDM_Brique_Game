import Game.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PlayerTest {
    private final Player p = new Player("test", "Black");
    @Test
    public void checkNameAndColorAndActivity()
    {
        assertEquals(p.getName(), "test");
        assertEquals(p.getColor(), "Black");
        assertFalse(p.IsActive());
    }

    @Test
    public void checkStatusOfPlayer() {
        p.setActive(Boolean.TRUE);
        assertTrue(p.IsActive());

    }

}
