package Game;

public class Player {
    private String name;
    private Piece_Color pieceColor; //each player choose a color to play with
    private Boolean active = Boolean.FALSE;
    private Graph graph;

    public Player(String name, Piece_Color pieceColor)
    {
        this.name = name;
        this.pieceColor = pieceColor;
        this.graph = new Graph(this.pieceColor);
    }

    // getters
    public String getName() {return this.name;}
    public Piece_Color getColor() {return this.pieceColor;}
    public Boolean IsActive() {return this.active;}
    public Graph getGraph() {return this.graph;}
    public boolean checkPath() {return this.graph.areBordersConnected();}

    //setters
    public void setName(String name){this.name = name;}
    public void setPieceColor(Piece_Color pieceColor){this.pieceColor = pieceColor;}
    public void setActive(Boolean active) {this.active = active;}
    public void setGraph(Graph graph) {this.graph = graph;}


}