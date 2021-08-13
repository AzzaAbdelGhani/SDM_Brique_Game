
import Game.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class GraphTest {
    private final Graph g = new Graph(Piece_Color.BLACK);
    private Board board = new Board();


    @Test
    public void isAddingNodeProperly()
    {
        g.add_node(new Coordinates(0,7));
        assertEquals(7, g.Adjacency_List.get(7).get(0));
    }

    @Test
    public void checkEdgesBetweenNodes()
    {
        g.add_node(new Coordinates(0,5));
        g.add_node(new Coordinates(1,5));
        assertTrue(g.Adjacency_List.get(5).contains(20));
    }

    @Test
    public void checkConnectionBetweenBorders()
    {
        g.add_node(new Coordinates(10, 7));
        g.add_node(new Coordinates(8, 7));
        g.add_node(new Coordinates(0, 7));
        g.add_node(new Coordinates(6, 7));
        g.add_node(new Coordinates(14, 7));
        g.add_node(new Coordinates(1, 7));
        g.add_node(new Coordinates(5, 7));
        g.add_node(new Coordinates(2, 7));
        g.add_node(new Coordinates(7, 7));
        g.add_node(new Coordinates(3, 7));
        g.add_node(new Coordinates(12, 7));
        g.add_node(new Coordinates(4, 7));
        g.add_node(new Coordinates(13, 7));
        g.add_node(new Coordinates(9, 7));
        g.add_node(new Coordinates(11, 7));
        assertTrue(g.areBordersConnected());
    }
}
