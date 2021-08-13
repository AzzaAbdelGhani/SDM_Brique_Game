package Game;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Board {
    private static final int size = 15;
    private Position[][] grid = new Position[size][size];

    public Board() {
        IntStream.range(0,size).forEach(i->IntStream.range(0,size).forEach(j->this.grid[i][j] = new Position(i,j)));
    }
    //setters
    protected void setPiece(int i, int j, Piece_Color color) { this.grid[i][j].setPieceColor(color);}

    //getters
    public int getSize() { return size; }

    public Position getPos(int i, int j) { return this.grid[i][j];}

    public Pos_Color getPosColor(int i, int j) { return this.grid[i][j].getPosColor();}

    public Piece_Color getPosFill(int i, int j) {return this.grid[i][j].getPieceColor();}

    public Boolean isValidPos(int i, int j){
        if (i < 0 || j < 0 || i >= size || j >= size) { return Boolean.FALSE; }
        return Boolean.TRUE;
    }

    public void printBoard(){
        for(int i = size-1; i >=0; i--){
            for(int j = 0; j < size; j++){
                Piece_Color color = getPosFill(i,j);
                System.out.print(color.getString() + "\t");
            }
            System.out.println(" ");
        }
    }
}
