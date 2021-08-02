package Game;

public class Position {
    private int row_idx;
    private int col_idx;
    private Pos_Color posColor;
    private Piece_Color pColor = Piece_Color.BLANK;

    public Position(int row_idx, int col_idx){
        this.row_idx = row_idx;
        this.col_idx = col_idx;
        if ((row_idx + col_idx) % 2 == 0) this.posColor = Pos_Color.LIGHT;
        else this.posColor = Pos_Color.DARK;
    }

    //setters
    public void setPieceColor(Piece_Color pColor) {
        this.pColor = pColor;
    }

    //getters
    public int getRow_idx(){
        return this.row_idx;
    }
    public int getCol_idx(){ return this.col_idx; }

    public Pos_Color getPosColor(){
        return this.posColor;
    }

    public Piece_Color getPieceColor(){ return this.pColor; }

}
