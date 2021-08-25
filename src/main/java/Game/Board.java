package Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {
    private static final int size = 15;
    private Position[][] grid = new Position[size][size];

    public Board() {
        IntStream.range(0,size).forEach(i->IntStream.range(0,size).forEach(j->this.grid[i][j] = new Position(i,j)));
    }

    //getters
    public int getSize() { return size; }

    public Position getPos(Coordinates coordinates) {
        if(isValidPos(coordinates)) return this.grid[coordinates.getRow_idx()][coordinates.getCol_idx()];
        else return new Position(-1,-1);
    }

    public Boolean isValidPos(Coordinates coordinates){
        List<Integer> range = IntStream.range(0,size).boxed().collect(Collectors.toList());
        if(range.contains(coordinates.getRow_idx()) && range.contains(coordinates.getCol_idx())) { return Boolean.TRUE; }
        return Boolean.FALSE;
    }

    public ArrayList<List<Integer>> getBorders(Piece_Color color){
        ArrayList<List<Integer>> borders = new ArrayList<>();
        if (color == Piece_Color.BLACK)
        {
            borders.add(0,IntStream.range(0,size).boxed().collect(Collectors.toList()));
            borders.add(1,IntStream.range(size*size-size,size*size).boxed().collect(Collectors.toList()));
        }
        else if (color == Piece_Color.WHITE)
        {
            borders.add(0,IntStream.iterate(0,i -> i+size).limit(size).boxed().collect(Collectors.toList()));
            borders.add(1,IntStream.iterate(size-1,i -> i+size).limit(size).boxed().collect(Collectors.toList()));
        }
        return borders;
    }

    protected boolean isANeighbourFilled(Coordinates coordinates, Piece_Color color){
        if (!isValidPos(coordinates)) return Boolean.FALSE;
        if (getPos(coordinates).getPieceColor() == color) return Boolean.TRUE;
        return Boolean.FALSE;
    }

    public ArrayList<Coordinates> fillPositionAndGetEscorts(Coordinates coordinates, Piece_Color pcolor){
        ArrayList <Coordinates> escortList = getPos(coordinates).getEscorts();
        ArrayList <Coordinates> escortToBeFilled = new ArrayList<>();
        escortToBeFilled.add(coordinates);
        if (isANeighbourFilled(coordinates.getNeighbours(1,1), pcolor)) escortToBeFilled.add(escortList.get(0));
        if (isANeighbourFilled(coordinates.getNeighbours(-1,-1), pcolor)) escortToBeFilled.add(escortList.get(1));
        for (Coordinates e: escortToBeFilled) getPos(e).setPieceColor(pcolor);
        return escortToBeFilled;
    }
}
