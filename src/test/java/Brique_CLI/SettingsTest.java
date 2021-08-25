package Brique_CLI;

import Game.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SettingsTest {
    Player P1 = new Player("P1", Piece_Color.BLACK);
    Player P2 = new Player("P2", Piece_Color.WHITE);
    Board board = new Board();
    Move move = new Move(board, P1, P2);
    ByteArrayInputStream input = new ByteArrayInputStream("abc WHITE xyz".getBytes());

    @Test
    public void checkPieRule()
    {
        move.makeMove(new Coordinates(0,8));
        Settings.applyPieRule(P1, P2);
        assertEquals(Piece_Color.WHITE, P1.getColor());
        assertEquals(Piece_Color.BLACK, P2.getColor());
        Graph g2 = P2.getGraph();
        assertEquals(8, g2.Adjacency_List.get(8).get(0));
    }

    @Test
    public void checkChangingTheSettings()
    {
        System.setIn(input);
        Settings.changeSettings(P1, P2);
        assertEquals("abc", P1.getName());
        assertEquals("xyz", P2.getName());
        assertEquals(Piece_Color.WHITE, P1.getColor());
        assertEquals(Piece_Color.BLACK, P2.getColor());
    }
}
