package Brique_CLI;
import Game.*;
import java.util.Scanner;

public class LaunchGame {
    public static void main(String[] args)
    {
        Player P1 = new Player("P1", Piece_Color.BLACK);
        Player P2 = new Player("P2", Piece_Color.WHITE);
        Scanner scanner = new Scanner(System.in);
        System.out.println("WELCOME TO BRIQUE GAME : ");
        System.out.println("Default settings are : P1 has White color and P2 has Black color ");
        System.out.println("would you like to change the default settings ? yes/No");

        String input1 = scanner.next();
        input1 = input1.toLowerCase();
        while (!input1.equals("yes") && !input1.equals("no") && !input1.equals("y") && !input1.equals("n")) {
            System.out.println("Please enter yes or no : ");
            input1 = scanner.next();
        }
        if (input1.equals("yes") || input1.equals("y"))
        {
            Settings s = new Settings();
            s.changeSettings(P1,P2);
        }

        Game game = new Game(P1,P2);
    }
}
