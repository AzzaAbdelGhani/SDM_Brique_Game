package Game;

public class Player {
    private String name;
    private String color;
    private Boolean active = Boolean.FALSE;

    public Player(String name, String color)
    {
        this.name = name;
        this.color = color;
    }

    // getters
    public String getName() {return name;}
    public String getColor() {return color;}
    public Boolean IsActive() {return active;}

    //setters
    public void setName(String name){this.name = name;}
    public void setColor(String color){this.color = color;}
    public void setActive(Boolean active) {this.active = active;}
}