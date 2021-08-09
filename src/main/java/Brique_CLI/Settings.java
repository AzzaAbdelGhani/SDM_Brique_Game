package Brique_CLI;
import Game.*;
import java.util.Scanner;

public class Settings {

    public void changeSettings(Player p1, Player p2)
    {
        Scanner scanner = new Scanner(System.in);
        Piece_Color color1, color2;
        System.out.println("Please Enter the first player's name : ");
        String name1 = scanner.next();
        System.out.println("Please Enter the first player's color, BLACK or WHITE : ");
        String color = scanner.next();
        color = color.toUpperCase();
        while (!color.equals("BLACK") && !color.equals("WHITE") && !color.equals("B") && !color.equals("W") ) {
            System.out.println("This color is invalid, please enter BLACK or WHITE : ");
            color = scanner.next();
        }
        if (color.equals("B")) color = "BLACK";
        if (color.equals("W")) color = "WHITE";
        color1 = Piece_Color.valueOf(color);
        if(color1 == Piece_Color.BLACK) color2 = Piece_Color.WHITE;
        else color2 = Piece_Color.BLACK;
        System.out.println("Please Enter the second player's name : ");
        String name2 = scanner.next();

        p1.setName(name1);
        p1.setPieceColor(color1);
        p2.setName(name2);
        p2.setPieceColor(color2);
    }
}