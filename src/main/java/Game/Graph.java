package Game;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public final List<List<Integer>> Adjacency_List;
    private Piece_Color pieceColor;
    private Board board = new Board();

    public Graph(Piece_Color pieceColor)
    {
        this.pieceColor = pieceColor;
        Adjacency_List = new ArrayList<List<Integer>>();
        for (int i =0; i < 255 ; i++)
        {
            ArrayList<Integer> new_list = new ArrayList<>();
            Adjacency_List.add(i, new_list);
        }
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
        int[] num_neighbours = {1,-1};
        for (int i : num_neighbours) {
            neighbours.add(coordinates.getNeighbours(i,0));
            neighbours.add(coordinates.getNeighbours(0,i));
        }
        for(Coordinates n:neighbours) {
            if(isNeighbourFilled(n)) setEdge(get_Index(coordinates),get_Index(n));
        }
    }

    private ArrayList<List<Integer>> getBorders()
    {
        ArrayList<List<Integer>> borders = new ArrayList<List<Integer>>();
        for (int i = 0; i < 2; i++)
        {
            ArrayList<Integer> new_list = new ArrayList<>();
            borders.add(i,new_list);
        }
        if (this.pieceColor == Piece_Color.BLACK)
        {
            ArrayList<Integer> up = new ArrayList<Integer>();
            ArrayList<Integer> down = new ArrayList<Integer>();
            for (int i = 0, j = 210; i < 15 && j < 225; i++, j++) {
                up.add(i);
                down.add(j);
            }
            borders.add(0,up);
            borders.add(1,down);
        }
        else if (this.pieceColor == Piece_Color.WHITE)
        {
            ArrayList<Integer> right = new ArrayList<Integer>();
            ArrayList<Integer> left = new ArrayList<Integer>();
            for (int i = 0, j = 14; i < 211 && j < 225; i+=15, j+=15) {
                left.add(i);
                right.add(j);
            }
            borders.add(0,left);
            borders.add(1,right);
        }

        return borders;
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
        ArrayList<List<Integer>> borders = getBorders();
        ArrayList<Integer> visited = new ArrayList<Integer>();
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

    public void printGraph()
    {
        System.out.println ("Adjacency List for the graph \n");
        for (List<Integer> l : Adjacency_List)
        {
            if(!l.isEmpty()) {
                for (int i = 0; i < l.size(); i++) {
                    System.out.print("->" + l.get(i));
                }
                System.out.print("\n");
            }
        }
    }

}
