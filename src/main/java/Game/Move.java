package Game;

import java.util.ArrayList;

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

    public void changePlayerTurn() {
        currentPlayer.setActive(Boolean.FALSE);
        otherPlayer.setActive(Boolean.TRUE);
    }

    public boolean makeMove(Coordinates coordinates){
        if (board.isValidPos(coordinates) && board.getPos(coordinates).getPieceColor() == Piece_Color.BLANK){
            this.coordinates = coordinates;
            ArrayList<Coordinates> escortToBeFilled = board.fillPositionAndGetEscorts(coordinates, currentColor);
            escortToBeFilled.add(coordinates);
            for(Coordinates e: escortToBeFilled) currentPlayer.getGraph().updateBoard(board,e);
            changePlayerTurn();
            return Boolean.TRUE;
        }
        else
            return Boolean.FALSE;
    }



}
