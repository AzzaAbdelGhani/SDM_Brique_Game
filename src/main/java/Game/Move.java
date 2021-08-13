package Game;

public class Move {
    private Board board;
    private Player currentPlayer, otherPlayer;
    private Coordinates coordinates;

    public Move(Board board, Player currentPlayer, Player otherPlayer){
        this.board = board;
        this.currentPlayer = currentPlayer;
        this.otherPlayer = otherPlayer;
    }


    //getters
    public Coordinates getCoordinates() { return this.coordinates; }


    public void fillBoardAndUpdateGraph(Coordinates coordinates, Piece_Color color)
    {
        board.setPiece(coordinates, color);
        currentPlayer.getGraph().updateBoard(board,coordinates);
    }

    public void fillEscorts(){
        Piece_Color current = currentPlayer.getColor();
        Pos_Color color = board.getPos(coordinates).getPosColor();
        int size = board.getSize();
        if ( coordinates.getRow_idx() != size-1 && coordinates.getCol_idx() != size-1 ) {
            if (current == board.getPos(coordinates.getDiagUp()).getPieceColor() && color == Pos_Color.LIGHT) { fillBoardAndUpdateGraph(coordinates.getUp(), current); }
            if (current == board.getPos(coordinates.getDiagUp()).getPieceColor()  && color == Pos_Color.DARK) { fillBoardAndUpdateGraph(coordinates.getRight(), current); }
        }
        if ( coordinates.getRow_idx() != 0 && coordinates.getCol_idx() != 0 ){
            if (current == board.getPos(coordinates.getDiagDown()).getPieceColor()  && color == Pos_Color.LIGHT) { fillBoardAndUpdateGraph(coordinates.getDown(), current); }
            if (current == board.getPos(coordinates.getDiagDown()).getPieceColor()  && color == Pos_Color.DARK){ fillBoardAndUpdateGraph(coordinates.getRight(), current);}
        }
        
    }

    public boolean makeMove(Coordinates coordinates){
        if (board.isValidPos(coordinates) && board.getPos(coordinates).getPieceColor() == Piece_Color.BLANK){
            board.setPiece(coordinates, currentPlayer.getColor());
            fillEscorts();
            currentPlayer.setActive(Boolean.FALSE);
            otherPlayer.setActive(Boolean.TRUE);
            return Boolean.TRUE;
        }
        else
            return Boolean.FALSE;
    }

}
