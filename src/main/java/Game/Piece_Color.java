package Game;

public enum Piece_Color {
    BLACK ("BLACK"),
    WHITE ("WHITE"),
    BLANK ("BLANK");

    private String pColor;
    Piece_Color(String s){this.pColor = s;}
    public String getString() {return pColor;}

}
