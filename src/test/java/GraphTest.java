
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
        g.add_node(0,7);
        assertEquals(7, g.Adjacency_List.get(7).get(0));
    }

    @Test
    public void checkEdgesBetweenNodes()
    {
        Graph g2 = new Graph(Piece_Color.BLACK);
        g2.add_node(0,5);
        g2.add_node(1,5);
        assertTrue(g2.Adjacency_List.get(5).contains(20));
    }

    @Test
    public void checkConnectionBetweenBorders()
    {
        Graph g3 = new Graph(Piece_Color.BLACK);
        g3.add_node(10, 7);
        g3.add_node(8, 7);
        g3.add_node(0, 7);
        g3.add_node(6, 7);
        g3.add_node(14, 7);
        g3.add_node(1, 7);
        g3.add_node(5, 7);
        g3.add_node(2, 7);
        g3.add_node(7, 7);
        g3.add_node(3, 7);
        g3.add_node(12, 7);
        g3.add_node(4, 7);
        g3.add_node(13, 7);
        g3.add_node(9, 7);
        g3.add_node(11, 7);
        assertTrue(g3.areBordersConnected());
    }
}
