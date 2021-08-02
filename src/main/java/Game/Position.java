package Game;

public class Position {
    private int row_idx;
    private int col_idx;

    //No setters implemented, only constructors
    public Position(int row_idx, int col_idx){
        this.row_idx = row_idx;
        this.col_idx = col_idx;
    }

    //getters
    public int getRow_idx(){
        return this.row_idx;
    }
    public int getCol_idx(){ return this.col_idx; }

}
