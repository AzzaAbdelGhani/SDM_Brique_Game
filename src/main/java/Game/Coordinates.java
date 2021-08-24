package Game;

public class Coordinates {
    protected int row_idx;
    protected int col_idx;

    public Coordinates(int row_idx, int col_idx){
        this.row_idx = row_idx;
        this.col_idx = col_idx;
    }
    //getters
    public int getRow_idx() { return this.row_idx; }

    public int getCol_idx() { return this.col_idx; }

    public Coordinates getNeighbours(int i, int j){return new Coordinates(this.row_idx+i, this.col_idx+j);}

    public Coordinates getDiagUp() { return new Coordinates(this.row_idx+1, this.col_idx+1); }

    public Coordinates getDiagDown() { return new Coordinates(this.row_idx-1, this.col_idx-1); }
}
