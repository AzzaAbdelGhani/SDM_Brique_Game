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
    public int get_Index(int row, int col) {return (row*15 + col);}

    public void add_node(int row, int col)
    {
        int idx = get_Index(row, col);
        Adjacency_List.get(idx).add(idx);
        this.board.setPiece(row,col,this.pieceColor);
        check_neighbours(row, col, this.board);
    }

    public void setEdge(int src, int des)
    {
        Adjacency_List.get(des).add(src);
        Adjacency_List.get(src).add(des);
    }

    public void check_neighbours(int row, int col, Board board)
    {
        if(board.isValidPos(row-1, col))
        {
            if ( this.pieceColor == board.getPosFill(row-1,col))
                setEdge(get_Index(row,col), get_Index(row-1,col));
        }
        if(board.isValidPos(row+1, col))
        {
            if ( this.pieceColor == board.getPosFill(row+1,col))
                setEdge(get_Index(row,col), get_Index(row+1,col));
        }
        if(board.isValidPos(row, col-1))
        {
            if ( this.pieceColor == board.getPosFill(row,col-1))
                setEdge(get_Index(row,col), get_Index(row,col-1));
        }
        if(board.isValidPos(row, col+1))
        {
            if ( this.pieceColor == board.getPosFill(row,col+1))
                setEdge(get_Index(row,col), get_Index(row,col+1));
        }
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
