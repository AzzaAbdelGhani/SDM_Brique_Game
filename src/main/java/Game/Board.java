package Game;

public class Board {
    private static final int size = 15;
    private Position[][] grid = new Position[size][size];

    public Board() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.grid[i][j] = new Position(i, j);
            }
        }
    }
    //setters
    public void setPiece(int i, int j, Piece_Color color) { this.grid[i][j].setPieceColor(color);}

    //getters
    public Position getPos(int i, int j) { return this.grid[i][j];}

    public Pos_Color getPosColor(int i, int j) { return this.grid[i][j].getPosColor();}

    public Piece_Color getPosFill(int i, int j) {return this.grid[i][j].getPieceColor();}

}
