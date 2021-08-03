
import Game.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphTest {
    private final Graph g = new Graph(Piece_Color.BLACK);
    private Board board = new Board();


    @Test
    public void isAddingNodeProperly()
    {
        g.add_node(0,7);
        assertEquals(7, g.Adjacency_List.get(7).get(0));
    }
}
