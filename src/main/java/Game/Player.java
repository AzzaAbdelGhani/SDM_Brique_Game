package Game;

public class Player {
    private String name;
    private Piece_Color pieceColor; //each player choose a color to play with
    private Boolean active = Boolean.FALSE;

    public Player(String name, Piece_Color pieceColor)
    {
        this.name = name;
        this.pieceColor = pieceColor;
    }

    // getters
    public String getName() {return name;}
    public Piece_Color getColor() {return pieceColor;}
    public Boolean IsActive() {return active;}

    //setters
    public void setName(String name){this.name = name;}
    public void setColor(Piece_Color pieceColor){this.pieceColor = pieceColor;}
    public void setActive(Boolean active) {this.active = active;}
}