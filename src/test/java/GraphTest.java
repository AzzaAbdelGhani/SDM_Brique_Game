
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
}
