import Game.Game;
import Game.Player;
import Game.Piece_Color;
import Game.Status;
import Game.Board;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private static final Player P1 = new Player("Player1", Piece_Color.BLACK);
    private static final Player P2 = new Player("Player2", Piece_Color.WHITE);
    private static final Player P3 = new Player("Player3", Piece_Color.BLACK);
    private static final Game g = new Game(P1, P2);
    private static final Game g1 = new Game(P1, P3);

    @Test
    public void checkActiveAndOtherPlayer()
    {
        assertEquals(g.getActivePlayer(), P1);
        assertEquals(g.getOtherPlayer(), P2);
    }
    @Test
    public void checkGameStatus()
    {
        assertEquals(g.getStatus(), Status.ON);
        g.setStatus(Status.OVER);
        assertEquals(g.getStatus(), Status.OVER);
    }
    @Test
    public void checkPlayersOfSamePieceColors()
    {
        assertEquals(g1.getActivePlayer(), P1);
        assertEquals(g1.getOtherPlayer(), P3);
    }

}
