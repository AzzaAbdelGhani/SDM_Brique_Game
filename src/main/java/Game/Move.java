package Game;

public class Move {
    private Board board;
    private Player currentPlayer, otherPlayer;
    private Coordinates coordinates;
    private Piece_Color currentColor;

    public Move(Board board, Player currentPlayer, Player otherPlayer){
        this.board = board;
        this.currentPlayer = currentPlayer;
        this.otherPlayer = otherPlayer;
        this.currentColor = currentPlayer.getColor();
    }


    //getters
    public Coordinates getCoordinates() { return this.coordinates; }


    public void fillBoardAndUpdateGraph(Coordinates coordinates)
    {
        board.getPos(coordinates).setPieceColor(currentColor);
        currentPlayer.getGraph().updateBoard(board,coordinates);
    }

    protected boolean isEscortFilled(Coordinates coordinates){
        if (!board.isValidPos(coordinates)) return Boolean.FALSE;
        if (board.getPos(coordinates).getPieceColor() == currentPlayer.getColor()) return Boolean.TRUE;
        return Boolean.FALSE;
    }

    public void fillEscorts(){
        Pos_Color color = board.getPos(coordinates).getPosColor();
        if(color == Pos_Color.LIGHT){
            if (isEscortFilled(coordinates.getNeighbours(1,1))) fillBoardAndUpdateGraph(coordinates.getNeighbours(1,0));
            if (isEscortFilled(coordinates.getNeighbours(-1,-1))) fillBoardAndUpdateGraph(coordinates.getNeighbours(0,-1));
        }
        else {
            if (isEscortFilled(coordinates.getNeighbours(1,1))) fillBoardAndUpdateGraph(coordinates.getNeighbours(0,1));
            if (isEscortFilled(coordinates.getNeighbours(-1,-1))) fillBoardAndUpdateGraph(coordinates.getNeighbours(-1,0));
        }
    }
    public void changePlayerTurn() {
        currentPlayer.setActive(Boolean.FALSE);
        otherPlayer.setActive(Boolean.TRUE);
    }

    public boolean makeMove(Coordinates coordinates){
        if (board.isValidPos(coordinates) && board.getPos(coordinates).getPieceColor() == Piece_Color.BLANK){
            this.coordinates = coordinates;
            fillBoardAndUpdateGraph(coordinates);
            fillEscorts();
            changePlayerTurn();
            return Boolean.TRUE;
        }
        else
            return Boolean.FALSE;
    }



}
