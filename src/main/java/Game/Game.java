package Game;

public class Game {
    private Board board = new Board();
    private Player P1, P2;
    private Status gStatus;

    public Game(Player P1, Player P2){
        this.P1 = P1;
        this.P2 = P2;
        this.gStatus = Status.ON;

        //Check if the Players have same colors
        if(P1.getColor() == P2.getColor()) {
            System.out.println("Both players have same color: hence "
                    + P1.getName() + " is given black and "
                    + P2.getName() + " is given white by default");
            P1.setPieceColor(Piece_Color.BLACK);
            P2.setPieceColor(Piece_Color.WHITE);
        }
        //Black plays first
        if(P1.getColor() == Piece_Color.BLACK) { P1.setActive(true); }
        else { P2.setActive(true); }
    }

    //setters
    public void setStatus(Status status) { this.gStatus = status; }

    //getters
    public Board getBoard(){return this.board;}

    public Player getActivePlayer() { if(P1.IsActive()) { return P1; } else { return P2; } }

    public Player getOtherPlayer() { if(P1.IsActive()) { return P2; } else { return P1; } }

    public Status getStatus() { return this.gStatus; }
}
