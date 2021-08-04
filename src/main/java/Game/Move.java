package Game;

import java.util.Scanner;

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
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    //getters
    public int getX() { return this.x; }
    public int getY() { return this.y; }

    public boolean makeMove(int x, int y){
        if (this.board.isValidPos(x,y) && this.board.getPosFill(x,y) == Piece_Color.BLANK){
            this.x = x;
            this.y = y;
            this.board.setPiece(x, y, currentPlayer.getColor());
            this.currentPlayer.setActive(Boolean.FALSE);
            this.otherPlayer.setActive(Boolean.TRUE);
            return Boolean.TRUE;
        }
        else
            return Boolean.FALSE;
    }

}
