package Brique_CLI;
import Game.*;
import java.util.Scanner;

public class LaunchGame {
    public static void main(String[] args)
    {
        Player P1 = new Player("P1", Piece_Color.BLACK);
        Player P2 = new Player("P2", Piece_Color.WHITE);

        System.out.println("WELCOME TO BRIQUE GAME : ");
        System.out.println("Default settings are : P1 has White color and P2 has Black color ");

        Game game = new Game(P1,P2);
    }
}
