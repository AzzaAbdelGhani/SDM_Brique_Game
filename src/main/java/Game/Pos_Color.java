package Game;
public enum Pos_Color {
    LIGHT ("WHITE"),
    DARK ("DARK");

    private String posColor;
    Pos_Color(String s){ posColor = s;}
    public String getString() {return posColor;}
}
