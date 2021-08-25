package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Graph {
    public final List<List<Integer>> Adjacency_List = new ArrayList<>();
    private Piece_Color pieceColor;
    private Board board = new Board();
    private int listSize = board.getSize()*board.getSize();

    public Graph(Piece_Color pieceColor)
    {
        this.pieceColor = pieceColor;
        IntStream.range(0,listSize).forEach(i->Adjacency_List.add(i, new ArrayList<>()));
    }

    public void updateBoard(Board board, Coordinates coordinates)
    {
        this.board = board;
        add_node(coordinates);
    }
    private int get_Index(Coordinates coordinates) {return (coordinates.getRow_idx() *15 + coordinates.getCol_idx());}

    public void add_node(Coordinates coordinates)
    {
        int idx = get_Index(coordinates);
        Adjacency_List.get(idx).add(idx);
        this.board.getPos(coordinates).setPieceColor(pieceColor);
        check_neighbours(coordinates);
    }

    public void setEdge(int src, int des)
    {
        Adjacency_List.get(des).add(src);
        Adjacency_List.get(src).add(des);
    }

    private boolean isNeighbourFilled(Coordinates coordinates){
        if(board.isValidPos(coordinates)){
            if(board.getPos(coordinates).getPieceColor() == pieceColor) return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private void check_neighbours(Coordinates coordinates)
    {
        ArrayList<Coordinates> neighbours = new ArrayList<>();
        int[] orthogonal_neighbours = {1,-1};
        for (int i : orthogonal_neighbours) {
            neighbours.add(coordinates.getNeighbours(i,0));
            neighbours.add(coordinates.getNeighbours(0,i));
        }
        for(Coordinates n:neighbours) {
            if(isNeighbourFilled(n)) setEdge(get_Index(coordinates),get_Index(n));
        }
    }


    private void DFS(Integer e, ArrayList<Integer> visited)
    {
        visited.add(e);
        for (Integer i : Adjacency_List.get(e))
        {
            if (!visited.contains(i))
                DFS(i,visited);
        }
    }

    public boolean areBordersConnected()
    {
        ArrayList<List<Integer>> borders = this.board.getBorders(this.pieceColor);
        ArrayList<Integer> visited = new ArrayList<>();
        for(Integer e : borders.get(0))
        {
            if (Adjacency_List.get(e).contains(e))
            {
                DFS(e,visited);
                if(!visited.isEmpty()){
                    for (Integer v : visited)
                    {
                        if (borders.get(1).contains(v)) return true;
                    }
                }
            }
        }
        return false;
    }

}
