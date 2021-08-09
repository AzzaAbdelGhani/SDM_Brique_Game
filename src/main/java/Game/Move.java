package Game;

public class Move {
    private Board board;
    private Player currentPlayer, otherPlayer;
    private int x,y;

    public Move(Board board, Player currentPlayer, Player otherPlayer){
        this.board = board;
        this.currentPlayer = currentPlayer;
        this.otherPlayer = otherPlayer;
    }

    //setters
    protected void setX(int x) { this.x = x; }
    protected void setY(int y) { this.y = y; }

    //getters
    public int getX() { return this.x; }
    public int getY() { return this.y; }

    public void fillBoardAndUpdateGraph(int i, int j, Piece_Color color)
    {
        board.setPiece(i, j, color);
        currentPlayer.updateGraph(board,i,j);
    }

    public void fillEscorts(){
        Piece_Color current = currentPlayer.getColor();
        Pos_Color color = board.getPosColor(x, y);
        int size = board.getSize();
        if ( x != size-1 && y != size-1 ) {
            if (current == board.getPosFill(x+1, y+1) && color == Pos_Color.LIGHT) { fillBoardAndUpdateGraph(x, y+1, current); }
            if (current == board.getPosFill(x+1, y+1) && color == Pos_Color.DARK) { fillBoardAndUpdateGraph(x +1, y, current); }
        }
        if ( x != 0 && y != 0 ){
            if (current == board.getPosFill(x-1, y-1) && color == Pos_Color.LIGHT) { fillBoardAndUpdateGraph(x -1, y, current); }
            if (current == board.getPosFill(x-1, y-1) && color == Pos_Color.DARK){ fillBoardAndUpdateGraph(x, y -1, current);}
        }
        if (x == size-1 && color == Pos_Color.DARK) { fillBoardAndUpdateGraph(x, y +1, current); }
        
    }

    public boolean makeMove(int x, int y){
        if (board.isValidPos(x,y) && board.getPosFill(x,y) == Piece_Color.BLANK){
            this.x = x;
            this.y = y;
            board.setPiece(x, y, currentPlayer.getColor());
            currentPlayer.setActive(Boolean.FALSE);
            otherPlayer.setActive(Boolean.TRUE);
            return Boolean.TRUE;
        }
        else
            return Boolean.FALSE;
    }

}
