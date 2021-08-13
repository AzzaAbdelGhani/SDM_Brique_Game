package Game;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {
    private static final int size = 15;
    private Position[][] grid = new Position[size][size];

    public Board() {
        IntStream.range(0,size).forEach(i->IntStream.range(0,size).forEach(j->this.grid[i][j] = new Position(i,j)));
    }
    //setters
    protected void setPiece(Coordinates coordinates, Piece_Color color) { this.grid[coordinates.getRow_idx()][coordinates.getCol_idx()].setPieceColor(color);}

    //getters
    public int getSize() { return size; }

    public Position getPos(Coordinates coordinates) { return this.grid[coordinates.getRow_idx()][coordinates.getCol_idx()];}

    public Boolean isValidPos(Coordinates coordinates){
        List<Integer> range = IntStream.range(0,size).boxed().collect(Collectors.toList());
        if(range.contains(coordinates.getRow_idx()) && range.contains(coordinates.getCol_idx())) { return Boolean.TRUE; }
        return Boolean.FALSE;
    }

    public void printBoard(){
        for(int i = size-1; i >=0; i--){
            for(int j = 0; j < size; j++){
                Piece_Color color = getPos(new Coordinates(i,j)).getPieceColor();
                System.out.print(color.getString() + "\t");
            }
            System.out.println(" ");
        }
    }
}
