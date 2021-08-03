package Game;

public enum Status {
    ON ("ON"),
    OVER ("OVER"),
    P1_WINS ("P1_WINS"),
    P2_WINS ("P2_WINS");

    public final String gameStatus;

    public String getString() {return this.gameStatus;}
    Status(String s){ this.gameStatus = s;}
}
