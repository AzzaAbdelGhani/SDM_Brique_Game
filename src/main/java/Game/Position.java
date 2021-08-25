package Game;

import java.util.ArrayList;

public class Position extends Coordinates {
    private Pos_Color posColor;
    private Piece_Color pColor = Piece_Color.BLANK;

    public Position(int row_idx, int col_idx){
        super(row_idx, col_idx);
        if ((row_idx + col_idx) % 2 == 0) this.posColor = Pos_Color.LIGHT;
        else this.posColor = Pos_Color.DARK;
    }

    //setters
    public void setPieceColor(Piece_Color pColor) {
        this.pColor = pColor;
    }

    //getters
    public Pos_Color getPosColor(){
        return this.posColor;
    }

    public Piece_Color getPieceColor(){ return this.pColor; }

    public ArrayList<Coordinates> getEscorts()
    {
        ArrayList<Coordinates> escortList = new ArrayList<>();
        if(posColor == Pos_Color.LIGHT) {
            escortList.add(0,getNeighbours(1,0));
            escortList.add(1,getNeighbours(0,-1));
        }
        else {
            escortList.add(0,getNeighbours(0,1));
            escortList.add(1,getNeighbours(-1,0));
        }
        return escortList;
    }

}
